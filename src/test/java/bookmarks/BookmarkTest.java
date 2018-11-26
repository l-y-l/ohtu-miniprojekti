package bookmarks;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;

public class BookmarkTest {
// Abstract bookmark variables.

    String author;
    String title;
    String comment;
    String url;
    String description;
    ArrayList<String> tags;
    ArrayList<String> releatedCourses;
    ArrayList<String> prerequisiteCourses;

// Unique bookmark variables.
    String ISBN;

// Bookmarks.
    BlogBookmark blogB;
    BookBookmark bookB;
    PodcastBookmark podcastB;
    VideoBookmark videoB;

    @Before
    public void setUp() {
        initializeAbstractClassVariables();
        initializeUniqueClassVariables();
        initializeBookmarks();
    }

    private void initializeAbstractClassVariables() {
        author = "TestAuthor";
        title = "TestTitle";
        comment = "TestComment";
        url = "TestUrl";
        description = "TestDescription";

        tags = new ArrayList<>();
        releatedCourses = new ArrayList<>();
        prerequisiteCourses = new ArrayList<>();

        for (int i = 1; i < 4; i++) {
            tags.add("tag" + i);
            releatedCourses.add("relatedCourse" + i);
            prerequisiteCourses.add("description" + i);
        }
    }

    public void initializeUniqueClassVariables() {
        ISBN = "12345678";
    }

    public void initializeBookmarks() {
        blogB = new BlogBookmark(author, title, url, tags, releatedCourses, description, comment);
        bookB = new BookBookmark(author, title, ISBN, tags, prerequisiteCourses, releatedCourses, description, comment);
        podcastB = new PodcastBookmark(author, title, tags, releatedCourses, description, comment);
        videoB = new VideoBookmark(title, url, releatedCourses, tags, description, comment);
    }

// Tests:
    @Test
    public void BlogBookmarkTest() {
        String tagsStr = tags.get(0) + ", " + tags.get(1) + ", " + tags.get(2);
        String relatedStr = releatedCourses.get(0) + ", " + releatedCourses.get(1) + ", " + releatedCourses.get(2);
        String testString = "Author: " + author + "\nTitle: " + title + "\nUrl: " + url + "\nType: Blogpost" + "\nTags: " + tagsStr + "\nRelated courses: " + relatedStr + "\nDescription: " + description + "\nComment: " + comment;
        assertEquals(testString, blogB.toString());
    }

    @Test
    public void BookBookmarkTest() {
        String tagsStr = tags.get(0) + ", " + tags.get(1) + ", " + tags.get(2);
        String relatedStr = releatedCourses.get(0) + ", " + releatedCourses.get(1) + ", " + releatedCourses.get(2);
        String preqStr = prerequisiteCourses.get(0) + ", " + prerequisiteCourses.get(1) + ", " + prerequisiteCourses.get(2);
        String testString =  "Kirjoittaja: "+ author +"\n"
                            +"Title: " + title+ "\n"
                            +"Type: Book"+"\n"
                            +" ISBN: " + ISBN+"\n"
                            +"Tags: " +tagsStr+"\n"
                            +" Esitietokurssit: " + preqStr+"\n"
                            +"Related courses: "+ relatedStr+"\n"
                            +"Description: "+description +"\n"
                            +"Comment: "+comment;
        assertEquals(testString, bookB.toString());
    }

    @Test
    public void PodcastBookmarkTest() {
        String tagsStr = tags.get(0) + ", " + tags.get(1) + ", " + tags.get(2);
        String relatedStr = releatedCourses.get(0) + ", " + releatedCourses.get(1) + ", " + releatedCourses.get(2);
        String testString =  "Author: "+ author +"\n"
                            +"Title: " + title+ "\n"
                            +"Type: Podcast"+"\n"
                            +"Tags: " +tagsStr+"\n"
                            +"Related courses: "+ relatedStr+"\n"
                            +"Description: "+description +"\n"
                            +"Comment: "+comment;
        assertEquals(testString, podcastB.toString());
    }

    @Test
    public void VideoBookmarkTest() {
        String tagsStr = tags.get(0) + ", " + tags.get(1) + ", " + tags.get(2);
        String relatedStr = releatedCourses.get(0) + ", " + releatedCourses.get(1) + ", " + releatedCourses.get(2);
        String testString =  "Otsikko: " + title+ "\n"
                            +"Url: "+url+ "\n"
                            +"Type: Video"+"\n"
                            +"Tags: " +tagsStr+"\n"
                            +"Related courses: "+ relatedStr+"\n"
                            +"Description: "+description +"\n"
                            +"Comment: "+comment;
        assertEquals(testString, videoB.toString());
    }
}
