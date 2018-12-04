package app;

import app.domain.Course;
import app.domain.Tag;
import app.dao.BookMarkDAO;
import app.io.ConsoleIO;
import app.io.IO;
import app.ui.TextUI;
import app.utilities.Utilities;
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

    public App(IO io, BookMarkDAO dao) {
        this.io = io;
        this.ui = new TextUI(io);
        this.dao = dao;
    }

    public void run() {
        ui.printWelcomeMessage();
        boolean run = true;
        String command = "";
        String newEntry = "";
        int safety = 0;
        //TODO: hide this to an other class
        while (run) {
            command = ui.getMenuCommand();
            if (command.equals("1") || command.equals("new")) {
                Bookmark bookmark = ui.askForBookmark();
                if (bookmark != null) {
                    dao.saveBookmarkToDatabase(bookmark);
                }
            } else if (command.equals("2") || command.equals("list")) {
                ui.printBookmarkList(dao.getBookMarksOnDatabase());
            } else if (command.equals("3") || command.equals("search")) {
                String searchfield = ui.askForField();
                String search = ui.askForSearch();
                ui.printBookmarkList(dao.searchField(searchfield, search));
            } else if (command.equals("4") || command.equals("edit")) {
                Long editID = ui.askForEntryToEdit(dao.getBookMarksOnDatabase());
                String editfield = ui.askForEditField(dao.getSingleBookmarkInfo(editID));
                List<Tag> tagList = null;
                io.println("\nOld values: ");
                io.println(dao.getSingleBookmarkInfo(editID));
                if (editfield.equals("tags")) {
                    tagList = ui.askForTags();
                } else {
                    newEntry = ui.askForNewField(editfield);
                }

                dao.editEntry(editID, editfield, newEntry, tagList);

            } else if (command.equals("5") || command.equals("delete")) {
                Long bookmark_id = ui.askForEntryToEdit(dao.getBookMarksOnDatabase());
                if (bookmark_id != null) {
                    dao.deleteBookmarkFromDatabase(bookmark_id);
                }
            } else if (command.equals("0") || command.equals("exit")) {
                ui.printGoodbyeMessage();
                run = false;
            } else {
                ui.printUnrecognizedOption();
                if (safety++ > 100) {
                    run = false;
                }
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
