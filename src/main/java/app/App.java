package app;

import app.dao.BookMarkDAO;
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
    private BookMarkDAO dao;

    public App(IO io) {
        this.io = io;
        this.ui = new TextUI(io);
        this.dao = new BookMarkDAO();
    }
    

    public void run() {
        ui.printWelcomeMessage();
        boolean run = true;
        //TODO: hide this to an other class
        while (run) {
            String command = ui.getMenuCommand();
            switch (command) {
                case ("new"):
                    AbstractBookmark bookmark = ui.askForBookmark();
                    if (bookmark != null) {
                        dao.saveBookmarkToDatabase(bookmark);
                    }
                    break;
                case ("list"):
                    ui.printBookmarkList(dao.getBookMarksOnDatabase());
                    break;
                case("delete"):
                    Long bookmark_id = ui.askForBookmarkToDelete();
                    if (bookmark_id != null) {
                        dao.deleteBookmarkFromDatabase(bookmark_id);
                    }
                    break;
                case ("search"):
                    String field = ui.askForField();
                    String search = ui.askForSearch();
                    ui.printBookmarkList(dao.searchByTitle(field, search));
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

    public void close() {
        this.dao.close();
    }

    public static void main(String[] args) {
        App app = new App(new ConsoleIO());
        app.run();
        app.close();
    }
}
