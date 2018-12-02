package app;

import app.domain.Course;
import app.domain.Tag;
import app.dao.BookMarkDAO;
import app.io.ConsoleIO;
import app.io.IO;
import app.ui.TextUI;
import bookmarks.Bookmark;
import bookmarks.PodcastBookmark;
import java.util.List;
import java.util.ArrayList;
import java.util.InputMismatchException;
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
        String command = "";
        int safety=0;
        //TODO: hide this to an other class
        while (run) {
            command = ui.getMenuCommand();
            switch (command) {
                case ("1"):
                    Bookmark bookmark = ui.askForBookmark();
                    if (bookmark != null) {
                        dao.saveBookmarkToDatabase(bookmark);
                    }
                    break;
                case ("2"):
                    ui.printBookmarkList(dao.getBookMarksOnDatabase());
                    break;
                case ("3"):
                    String searchfield = ui.askForField();
                    String search = ui.askForSearch();
                    ui.printBookmarkList(dao.searchField(searchfield, search));
                    break;
                case ("4"):
                    Long editID = ui.askForEntryToEdit(dao.getBookMarksOnDatabase());
                    String editfield = ui.askForEditField();
                    io.println("\nOld values: ");
                    io.println(dao.getSingleBookmarkInfo(editID));
                    String newEntry = ui.askForNewField(editfield);
                    dao.editEntry(editID, editfield, newEntry);
                    break;
                case ("5"):
                    Long bookmark_id = ui.askForEntryToEdit(dao.getBookMarksOnDatabase());
                    if (bookmark_id != null) {
                        dao.deleteBookmarkFromDatabase(bookmark_id);
                    }
                    break;
                case ("0"):
                    ui.printGoodbyeMessage();
                    run = false;
                    break;
                default:
                    ui.printUnrecognizedOption();
                    if(safety++>100){
                        run=false;
                    }
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
