package app;

import app.io.ConsoleIO;
import app.io.IO;
import app.ui.TextUI;
import bookmarks.AbstractBookmark;
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


    public App(TextUI ui, List<AbstractBookmark> memory, IO io){
        this.ui = ui;
        this.io = io;
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    public void close(){
        if (sessionFactory != null){
            sessionFactory.close();
        }
    }

    private List<AbstractBookmark> getBookMarksOnDatabase(){
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        List result = session.createQuery( "from AbstractBookmark" ).list();

        session.getTransaction().commit();
        session.close();
        return  (List<AbstractBookmark>) result;
    }

    private void saveBookmarkToDatabase(AbstractBookmark bookmark){
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.save(bookmark);
        
        session.getTransaction().commit();
        session.close();
    }
    
    
    private void deleteBookmarkFromDatabase(Long bookmark_id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        
        session.delete(session.load(AbstractBookmark.class, bookmark_id));
        
        session.getTransaction().commit();
        session.close();
    }

    public void run(){
        ui.printWelcomeMessage(); 
        boolean run = true;
        while (run){
            String command = ui.getMenuCommand();
            switch(command){
                case("new"):
                    AbstractBookmark bookmark = ui.askForBookmark();     
                    if(bookmark != null) {
                        saveBookmarkToDatabase(bookmark);
                    }
                    break;
                case("list"):
                    ui.printBookmarkList(getBookMarksOnDatabase());
                    break;
                case("delete"):
                    deleteBookmarkFromDatabase(ui.askForBookmarkToDelete());
                    break;
                case("exit"):
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
        
    public static void main(String[] args){
        ConsoleIO io = new ConsoleIO(); 
        TextUI ui = new TextUI(io); 
        List<AbstractBookmark> memory = new ArrayList(); 
        App app  = new App(ui, memory, io); 
        app.run(); 
        app.close();
    }
}
