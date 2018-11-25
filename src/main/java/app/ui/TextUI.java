package app.ui;

import app.domain.Course;
import app.domain.Tag;
import app.io.IO;
import bookmarks.Bookmark;
import bookmarks.BookBookmark;
import bookmarks.BlogBookmark;
import bookmarks.PodcastBookmark;
import bookmarks.VideoBookmark;
import java.util.*;

public class TextUI {

    private final IO io;
    private final String defaultSuccessMessage = "Your bookmark has been read!";

    public TextUI(IO io) {
        this.io = io;
    }

    public void printWelcomeMessage() {
        io.println("Welcome");
    }

    public void printGoodbyeMessage() {
        io.println("Goodbye");
    }

    public void printUnrecognizedOption(String option) {
        io.println("Unrecognized option '" + option + "'");
    }

    public String getMenuCommand() {
        return askForInput("Type \"new\" new bookmark or \"list\" to list all bookmarks or \"exit\" to exit the application");
    }

    public Bookmark askForBookmark() {
        io.println("Add a new bookmark.");
        io.println("Give type (B = Book) (BG = Blog) (P = Podcast) (V = Video): ");
        String type = io.nextLine();

        Bookmark bookmark = null;

        if (type.equals("B")) {
            bookmark = askForBookBookmarkInfo();
        } else if (type.equals("BG")) {
            bookmark = askForBlogBookmarkInfo();
        } else if (type.equals("P")) {
            bookmark = askForPodcastBookmarkInfo();

        } else if (type.equals("V")) {
            bookmark = askForVideoBookmarkInfo();
        }

        if (bookmark != null) {
            io.println(defaultSuccessMessage);
            return bookmark;
        }

        io.println("Invalid choice");
        return null;

    }

    public void printBookmarkList(List<Bookmark> bookmarks) {
        if (bookmarks.isEmpty()) {
            io.println("There are currently no bookmarks on memory. Add a new bookmark with command \"new\"");
        }
        for (Bookmark bmark : bookmarks) {
            io.println(bmark.toString());
        }
    }

    private Bookmark askForBookBookmarkInfo() {
        BookBookmark bm = new BookBookmark();

        io.println("ISBN: ");
        String isbn = io.nextLine();
        bm.setISBN(isbn);
        askForGeneralBookmarkInfo(bm);
        return bm;
    }

    private Bookmark askForBlogBookmarkInfo() {
        BlogBookmark bm = new BlogBookmark();
        askForGeneralBookmarkInfo(bm);
        return bm;
    }

    private Bookmark askForPodcastBookmarkInfo() {

        PodcastBookmark bm = new PodcastBookmark();
        askForGeneralBookmarkInfo(bm);
        return bm;
    }

    private Bookmark askForVideoBookmarkInfo() {
        VideoBookmark bm = new VideoBookmark();
        askForGeneralBookmarkInfo(bm);
        return bm;
    }

    private Bookmark askForGeneralBookmarkInfo(Bookmark bookmark) {
        String title = askForInput("Title: ");
        bookmark.setTitle(title); 
        
        String author = askForInput("Author: "); 
        bookmark.setAuthor(author);

        String url = askForInput("Url: ");
        bookmark.setUrl(url);

        List<Tag> tagsList = askForTags();
        bookmark.setTags(tagsList);

        List<Course> relatedCourseList = askForRelatedCourses();
        bookmark.setRelatedCourses(relatedCourseList);

        List<Course> prerequisiteCourseList = askForPrerequisites();
        bookmark.setPrerequisiteCourses(prerequisiteCourseList);

        String description = askForInput("Description: ");
        bookmark.setDescription(description);
        
        String comment = askForInput("Comment");
        bookmark.setComment(comment);

        return bookmark;
    }

    private List<Tag> askForTags() {
        io.println("Tags (separated by \",\"): ");
        String input = io.nextLine();

        String[] tags = input.split(",");
        List<Tag> result = new ArrayList();
        for (int i = 0; i < tags.length; i++) {
            // toistaiseksi oletetaan, että jokainen lisättävä kurssi on eri
            result.add(new Tag(tags[i].trim()));
        }

        return result;
    }

    private List<Course> askForPrerequisites() {
        return askForCourses("Prerequisite courses (separated by \",\"): ");

    }

    private List<Course> askForRelatedCourses() {
        return askForCourses("Related courses (separated by \",\"): ");

    }

    private List<Course> askForCourses(String prompt) {
        io.println(prompt);
        String input = io.nextLine();

        String[] courses = input.split(",");
        List<Course> result = new ArrayList();
        for (int i = 0; i < courses.length; i++) {
            // toistaiseksi oletetaan, että jokainen lisättävä kurssi on eri
            result.add(new Course(courses[i].trim()));
        }

        return result;
    }

    private String askForInput(String prompt) {
        io.println(prompt);
        return io.nextLine();
    }

}
