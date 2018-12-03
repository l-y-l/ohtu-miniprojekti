package bookmarks;

import app.domain.Course;
import app.domain.Tag;
import bookmarks.BlogBookmark;
import bookmarks.BookBookmark;
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
    OtherBookmark otherB; 


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
        otherB = new OtherBookmark(title, url, description); 
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
    public void OtherBookmarkTest(){
        String testString = "ID: " + otherB.getId() + "\n Type: Other\n "
                + "Title: " + title + "\n Url: " + url + "\n Description: " + description; 
        assertEquals(otherB.toString(), testString); 
    }

}
