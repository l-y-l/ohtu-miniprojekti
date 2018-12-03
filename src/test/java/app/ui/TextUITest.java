package app.ui;

import app.io.ConsoleIO;
import bookmarks.BlogBookmark;
import bookmarks.BookBookmark;

import bookmarks.Bookmark;
import bookmarks.OtherBookmark;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

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
        Bookmark bookmark = ui.askForBookmark();


        assertEquals(bookmark.getDescription(), "testDescription");
        assertEquals(bookmark.getTitle(), "testTitle");
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
        Bookmark bookmark = ui.askForBookmark();
        try{ 
            BlogBookmark blog = (BlogBookmark) bookmark; 
            assertEquals("testUrl", blog.getUrl());
        } catch (Exception e){
            assertTrue(false); 
        }
        assertEquals(bookmark.getTitle(), "testTitle");
    }
    
    
    @Test
    public void textUICreatesOtherBookmarks() throws FileNotFoundException{
        File file = null; 
        try{
            file = new File("src/test/resources/app/otherbookmark.txt");
        } catch (Exception e){
            e.printStackTrace(); 
        }
        scanner = new Scanner(file);
        ui = new TextUI(new ConsoleIO(scanner));
        Bookmark bookmark =  ui.askForBookmark(); 
        assertTrue(bookmark.toString().contains("Type: Other"));
        
        try{
            OtherBookmark other = (OtherBookmark) bookmark; 
            assertEquals("otherUrl", other.getUrl());
        } catch (Exception e){
            assertTrue(false); 
        }
        assertEquals("otherTitle", bookmark.getTitle());
        assertEquals("Description for a peculiar bookmark", bookmark.getDescription());
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
        Bookmark bookmark = ui.askForBookmark();
        assertNull(bookmark);
    }
}
