package app;

import app.domain.Course;
import app.domain.Tag;
import app.io.ConsoleIO;
import app.io.IO;
import app.ui.TextUI;
import bookmarks.Bookmark;
import bookmarks.PodcastBookmark;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

import org.hibernate.*;
import org.hibernate.cfg.*;

public class App {

    private final TextUI ui;
    private IO io;
    private SessionFactory sessionFactory;

    public App(TextUI ui, List<Bookmark> memory, IO io) {
        this.ui = ui;
        this.io = io;
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    public void close() {
        if (sessionFactory != null) {
            sessionFactory.close();
        }
    }

    private List<Bookmark> getBookMarksOnDatabase() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        List result = session.createQuery("from Bookmark").list();

        session.getTransaction().commit();
        session.close();
        return (List<Bookmark>) result;
    }

    private void saveBookmarkToDatabase(Bookmark bookmark) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.save(bookmark);

        for (Tag t : bookmark.getTags()) {
            session.save(t);
        }

        for (Course c : bookmark.getPrerequisiteCourses()) {
            session.save(c);
        }

        for (Course c : bookmark.getRelatedCourses()) {
            session.save(c);
        }
        session.getTransaction().commit();
        session.close();
    }

    public void run() {
        ui.printWelcomeMessage();
        boolean run = true;
        while (run) {
            String command = ui.getMenuCommand();
            switch (command) {
                case ("new"):
                    Bookmark bookmark = ui.askForBookmark();
                    if (bookmark != null) {
                        saveBookmarkToDatabase(bookmark);
                    }
                    break;
                case ("list"):
                    ui.printBookmarkList(getBookMarksOnDatabase());
                    break;
                case ("exit"):
                    ui.printGoodbyeMessage();
                    run = false;
                    break;
                default:
                    ui.printUnrecognizedOption(command);
                    run = false;
                    break;
            }
        }
    }

    public static void main(String[] args) {
        ConsoleIO io = new ConsoleIO();
        TextUI ui = new TextUI(io);
        List<Bookmark> memory = new ArrayList();
        App app = new App(ui, memory, io);
        app.run();
        app.close();
    }
}
