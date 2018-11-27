package app;

import app.dao.BookMarkDAO;
import app.domain.Course;
import app.domain.Tag;
import app.utilities.Utilities;
import bookmarks.PodcastBookmark;
import bookmarks.VideoBookmark;
import bookmarks.BlogBookmark;
import bookmarks.BookBookmark;
import static org.junit.Assert.*;
import org.junit.*;

import java.util.*;
import java.util.logging.*;
import javax.transaction.Transactional;
import org.hibernate.*;
import org.hibernate.cfg.*;

@Transactional
public class DatabaseTest {

    private BookMarkDAO dao;

    @Before
    public void setUp() throws Exception {
        dao = new BookMarkDAO(Utilities.TEST_DATABASE);
    }

    @After
    public void tearDown() throws Exception {
        dao.close();
    }

    @Transactional
    @Test
    public void blogBookmarksDontCauseCrashing() {
        // Just tests that this doesn't crash
        dao.saveBookmarkToDatabase(new BlogBookmark());
        assertNotNull(dao.getBookMarksOnDatabase());
    }

    @Transactional
    @Test
    public void bookBookmarksDontCauseCrashing() {
        dao.saveBookmarkToDatabase(new BookBookmark());
        assertNotNull(dao.getBookMarksOnDatabase());
    }

    @Transactional
    @Test
    public void podcastBookmarksDontCauseCrashing() {
        dao.saveBookmarkToDatabase(new PodcastBookmark());
        assertNotNull(dao.getBookMarkClass("PodcastBookmark"));
    }

    @Transactional
    @Test
    public void VideoBookmarksDontCauseCrashing() {
        // Just tests that this doesn't crash
        dao.saveBookmarkToDatabase(new VideoBookmark());
        assertNotNull(dao.getBookMarkClass("VideoBookmark"));
    }
    @Transactional
    @Test
    public void searchMethodWorks(){
        dao.saveBookmarkToDatabase(new BookBookmark("simeon", "book","",new ArrayList<Tag>(), new ArrayList<Course>(), new ArrayList<Course>(),"",""));
        assertNotNull(dao.searchField("author", "simeon"));
    }
    @Transactional
    @Test
    public void userCanEditAnEntry(){
        dao.saveBookmarkToDatabase(new BookBookmark());
        long bookmarkID = dao.getBookMarksOnDatabase().get(dao.getBookMarksOnDatabase().size()-1).getId();
        dao.editEntry(bookmarkID, "author", "testAuthor");
        dao.editEntry(bookmarkID, "title", "testTitle");
        assertTrue(dao.getSingleBookmarkInfo(bookmarkID).contains("testAuthor"));
        assertTrue(dao.getSingleBookmarkInfo(bookmarkID).contains("testTitle"));
    }
}
