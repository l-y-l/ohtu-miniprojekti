package bookmarks;

import app.domain.Course;
import app.domain.Tag;
import bookmarks.PodcastBookmark;
import bookmarks.VideoBookmark;
import bookmarks.BlogBookmark;
import bookmarks.BookBookmark;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;

public class BookmarkTest {
// Abstract bookmark variables.

    Long id;
    String author;
    String title;
    String comment;
    String description;
    List<Tag> tags;
    List<Course> relatedCourses;
    List<Course> prerequisiteCourses;

    // Unique bookmark variables.
    String ISBN;

    // For every type of bookmark but books
    String url;

    // Bookmarks.
    BlogBookmark blogB;
    BookBookmark bookB;
    PodcastBookmark podcastB;
    VideoBookmark videoB;

    public BookmarkTest(){
        setUp();
    }
    public void setUp() {
        initializeAbstractClassVariables();
        initializeUniqueClassVariables();
        initializeBookmarks();
    }



    private void initializeAbstractClassVariables() {
        author = "TestAuthor";
        title = "TestTitle";
        comment = "TestComment";
        description = "TestDescription";

        tags = new ArrayList<>();
        relatedCourses = new ArrayList<>();
        prerequisiteCourses = new ArrayList<>();

        for (int i = 1; i < 4; i++) {
            tags.add(new Tag("tag" + i));
            relatedCourses.add(new Course("relatedCourse" + i));
            prerequisiteCourses.add(new Course("description" + i));

        }
    }

    public void initializeUniqueClassVariables() {
        ISBN = "12345678";
        url = "TestUrl";
    }

    public void initializeBookmarks() {
        blogB = new BlogBookmark(author, title, url, tags, prerequisiteCourses, relatedCourses, description, comment);
        bookB = new BookBookmark(author, title, ISBN, tags, prerequisiteCourses, relatedCourses, description, comment);
        podcastB = new PodcastBookmark(author, title, url, tags, prerequisiteCourses, relatedCourses, description, comment);
        videoB = new VideoBookmark(author, title, url, tags, prerequisiteCourses, relatedCourses, description, comment);
    }

    // Tests:
    @Test
    public void BlogBookmarkTest() {
        String tagsStr = tags.get(0) + ", " + tags.get(1) + ", " + tags.get(2);
        String relatedStr = relatedCourses.get(0) + ", " + relatedCourses.get(1) + ", " + relatedCourses.get(2);
        String preqStr = prerequisiteCourses.get(0) + ", " + prerequisiteCourses.get(1) + ", " + prerequisiteCourses.get(2);


        String testString = "ID: " + id + "\n"
                + " Type: Blogpost"+"\n"
                + " Author: " + author + "\n"
                + " Title: " + title+ "\n"
                + " Url: "+url+ "\n"
                + " Tags: " +tagsStr+"\n"
                + " Prerequisite courses: " + preqStr + "\n"
                + " Related courses: "+ relatedStr+"\n"
                + " Description: "+description +"\n"
                + " Comment: "+comment;
        assertEquals(testString, blogB.toString());
    }

    @Test
    public void BookBookmarkTest() {
        String tagsStr = tags.get(0) + ", " + tags.get(1) + ", " + tags.get(2);
        String relatedStr = relatedCourses.get(0) + ", " + relatedCourses.get(1) + ", " + relatedCourses.get(2);
        String preqStr = prerequisiteCourses.get(0) + ", " + prerequisiteCourses.get(1) + ", " + prerequisiteCourses.get(2);

        String testString = "ID: " + id + "\n"
                + " Type: Book"+"\n"
                + " ISBN: " + ISBN + "\n"
                + " Author: " + author + "\n"
                + " Title: " + title+ "\n"
                + " Tags: " +tagsStr+"\n"
                + " Prerequisite courses: " + preqStr + "\n"
                + " Related courses: "+ relatedStr+"\n"
                + " Description: "+description +"\n"
                + " Comment: "+comment;
        assertEquals(testString, bookB.toString());
    }

    @Test
    public void PodcastBookmarkTest() {
        String tagsStr = tags.get(0) + ", " + tags.get(1) + ", " + tags.get(2);
        String preqStr = prerequisiteCourses.get(0) + ", " + prerequisiteCourses.get(1) + ", " + prerequisiteCourses.get(2);

        String relatedStr = relatedCourses.get(0) + ", " + relatedCourses.get(1) + ", " + relatedCourses.get(2);

        String testString = "ID: " + id + "\n"
                + " Type: Podcast"+"\n"
                + " Author: " + author + "\n"
                + " Title: " + title+ "\n"
                + " Url: "+url+ "\n"
                + " Tags: " +tagsStr+"\n"
                + " Prerequisite courses: " + preqStr + "\n"
                + " Related courses: "+ relatedStr+"\n"
                + " Description: "+description +"\n"
                + " Comment: "+comment;
        assertEquals(testString, podcastB.toString());
    }

    @Test
    public void VideoBookmarkTest() {
        String tagsStr = tags.get(0) + ", " + tags.get(1) + ", " + tags.get(2);
        String relatedStr = relatedCourses.get(0) + ", " + relatedCourses.get(1) + ", " + relatedCourses.get(2);
        String preqStr = prerequisiteCourses.get(0) + ", " + prerequisiteCourses.get(1) + ", " + prerequisiteCourses.get(2);

        String testString = "ID: " + id + "\n"
                + " Type: Video"+"\n"
                + " Author: " + author + "\n"
                + " Title: " + title+ "\n"
                + " Url: "+url+ "\n"
                + " Tags: " +tagsStr+"\n"
                + " Prerequisite courses: " + preqStr + "\n"
                + " Related courses: "+ relatedStr+"\n"
                + " Description: "+description +"\n"
                + " Comment: "+comment;
        assertEquals(testString, videoB.toString());
    }




}
