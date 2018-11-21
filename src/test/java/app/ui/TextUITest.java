package app.ui;

import app.io.ConsoleIO;

import bookmarks.AbstractBookmark;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import org.junit.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.Scanner;

public class TextUITest {
    private Scanner scanner;
    private TextUI ui;
    private InputStream in;

    @Before
    public void setUp() {

    }

    @Test
    public void textUIcreatesBookBookmarks() throws FileNotFoundException {
        File file = null;
        try {
            file = new File("src/test/resources/app/bookmark.txt");
        } catch (Exception e) {
            e.printStackTrace();
        }

        scanner = new Scanner(file);

        ui = new TextUI(new ConsoleIO(scanner));
        AbstractBookmark bookmark = ui.askForBookmark();


        assertEquals(bookmark.getAuthor(), "testAuthor");
        assertEquals(bookmark.getTitle(), "testTitle");
        assertEquals(bookmark.getComment(), "testComment");
    }

    @Test
    public void textUIcreatesVideoBookmarks() throws FileNotFoundException {
        File file = null;
        try {
            file = new File("src/test/resources/app/videobookmark.txt");
        } catch (Exception e) {
            e.printStackTrace();
        }

        scanner = new Scanner(file);
        ui = new TextUI(new ConsoleIO(scanner));
        AbstractBookmark bookmark = ui.askForBookmark();

        assertEquals(bookmark.getUrl(), "testUrl");
        assertEquals(bookmark.getTitle(), "testTitle");
        assertEquals(bookmark.getComment(), "testComment");
    }

    @Test
    public void textUIcreatesBlogBookmarks() throws FileNotFoundException {
        File file = null;
        try {
            file = new File("src/test/resources/app/blogbookmark.txt");
        } catch (Exception e) {
            e.printStackTrace();
        }

        scanner = new Scanner(file);
        ui = new TextUI(new ConsoleIO(scanner));
        AbstractBookmark bookmark = ui.askForBookmark();

        assertEquals(bookmark.getUrl(), "testUrl");
        assertEquals(bookmark.getTitle(), "testTitle");
        assertEquals(bookmark.getComment(), "testComment");
    }
    @Test
    public void textUIcreatesPodcastBookmarks() throws FileNotFoundException {
        File file = null;
        try {
            file = new File("src/test/resources/app/podcastbookmark.txt");
        } catch (Exception e) {
            e.printStackTrace();
        }

        scanner = new Scanner(file);
        ui = new TextUI(new ConsoleIO(scanner));
        AbstractBookmark bookmark = ui.askForBookmark();

        assertEquals(bookmark.getTitle(), "testTitle");
        assertEquals(bookmark.getComment(), "testComment");
    }
    @Test
    public void invalidInputCreatesNoBookMark() throws FileNotFoundException{
        File file = null;
        try {
            file = new File("src/test/resources/app/invalid.txt");
        } catch (Exception e) {
            e.printStackTrace();
        }

        scanner = new Scanner(file);
        ui = new TextUI(new ConsoleIO(scanner));
        AbstractBookmark bookmark = ui.askForBookmark();
        assertNull(bookmark);
    }
}
