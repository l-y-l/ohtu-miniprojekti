package app.ui;

import app.io.IO;
import bookmarks.AbstractBookmark;
import bookmarks.BookBookmark;
import bookmarks.BlogBookmark;
import bookmarks.PodcastBookmark;
import bookmarks.VideoBookmark;
import java.util.ArrayList;
import java.util.Arrays;

public class TextUI {

    private final IO io;
    private String defaultSuccessMessage = "Your bookmark has been read!";

    public TextUI(IO io) {
        this.io = io;
    }

    public void printWelcomeMessage() {
        io.println("Welcome");
    }

    public AbstractBookmark askForBookmark() {
        io.println("Add a new bookmark.");
        io.println("Give type (B = Book) (BG = Blog) (P = Podcast) (V = Video): ");
        String type = io.nextLine();

        if (type.equals("B")) {
            BookBookmark bookmark = askForBookBookmarkInfo();
            if (bookmark != null) {
                io.println(defaultSuccessMessage);
                return bookmark;
            }
        } else if (type.equals("BG")) {
            BlogBookmark bookmark = askForBlogBookmarkInfo();
            if (bookmark != null) {
                io.println(defaultSuccessMessage);
                return bookmark;
            }
        } else if (type.equals("P")) {
            PodcastBookmark bookmark = askForPodcastBookmarkInfo();
            if (bookmark != null) {
                io.println(defaultSuccessMessage);
                return bookmark;
            }
        } else if (type.equals("V")) {
            VideoBookmark bookmark = askForVideoBookmarkInfo();
            if (bookmark != null) {
                io.println(defaultSuccessMessage);
                return bookmark;
            }
        } else {
            io.println("Invalid choice");
            return null;
        }
        io.println("Error.");
        return null;
    }


    private BookBookmark askForBookBookmarkInfo() {
        String author = askForAuthor();
        String title = askForTitle();

        io.println("ISBN: ");
        String isbn = io.nextLine();

        ArrayList<String> tagList = askForTags();
        ArrayList<String> prerequisiteList = askForPrerequisites();
        ArrayList<String> relatedCourseList = askForRelatedCourses();
        
        String description = askForDescription();
        String comment = askForComment();

        return new BookBookmark(author, title, isbn, tagList, prerequisiteList, relatedCourseList, description, comment);

    }

    private BlogBookmark askForBlogBookmarkInfo() {
        String author = askForAuthor();
        String title = askForTitle();
        String url = askForUrl();

        ArrayList<String> tagList = askForTags();
        ArrayList<String> relatedCourseList = askForRelatedCourses();

        String description = askForDescription();
        String comment = askForComment();

        return new BlogBookmark(author, title, url, tagList, relatedCourseList, description, comment);
    }

    private PodcastBookmark askForPodcastBookmarkInfo() {
        String author = askForAuthor();
        String title = askForTitle();

        ArrayList<String> tagsList = askForTags();
        ArrayList<String> relatedCourseList = askForRelatedCourses();

        String description = askForDescription();
        String comment = askForComment();

        return new PodcastBookmark(author, title, tagsList, relatedCourseList, description, comment);
    }

    private VideoBookmark askForVideoBookmarkInfo() {
        String title = askForTitle();
        String url = askForUrl();

        ArrayList<String> tagsList = askForTags();
        ArrayList<String> relatedCourseList = askForRelatedCourses();

        String description = askForDescription();
        String comment = askForComment();
        
        return new VideoBookmark(title, url, relatedCourseList, tagsList, description, comment);
    }

    private String askForAuthor() {
        io.println("Author: ");
        return io.nextLine();
    }

    private String askForTitle() {
        io.println("Title: ");
        return io.nextLine();
    }

    private String askForUrl() {
        io.println("Url: ");
        return io.nextLine();
    }

    private ArrayList<String> askForTags() {
        io.println("Tags (separated by \",\"): ");
        String tags = io.nextLine();
        return new ArrayList<>(Arrays.asList(tags.split(",")));
    }

    private ArrayList<String> askForPrerequisites() {
        io.println("Prerequisite courses (separated by \",\"): ");
        String prerequisiteCourses = io.nextLine();
        return new ArrayList<>(Arrays.asList(prerequisiteCourses.split(",")));

    }

    private ArrayList<String> askForRelatedCourses() {
        io.println("Related courses (separated by \",\"): ");
        String relatedCourses = io.nextLine();
        return new ArrayList<>(Arrays.asList(relatedCourses.split(",")));
    }

    private String askForComment() {
        io.println("Comment: ");
        return io.nextLine();
    }

    private String askForDescription() {
        io.println("Description: ");
        return io.nextLine();
    }

}
