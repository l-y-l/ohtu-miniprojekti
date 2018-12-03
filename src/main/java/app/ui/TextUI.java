package app.ui;

import app.domain.Course;
import app.domain.Tag;
import app.io.IO;
import bookmarks.Bookmark;
import bookmarks.BookBookmark;
import bookmarks.BlogBookmark;
import bookmarks.OtherBookmark;
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
        io.println("Type \"new\" new bookmark, \"list\" to list all bookmarks, \"search\" to search the database, \"delete\" to delete a bookmark, \"edit\" to edit a bookmark or \"exit\" to exit the application");
        return io.nextLine();
    }

    public String askForField() {
        io.println("Which field would you like to search?");
        io.println("Give field (A = Author) (T = Title) (C = Comment) (D = Description)");
        String command = io.nextLine();
        switch(command){
            case("A"):
                return "author";
            case("T"):
                return "title";
            case("C"):
                return "comment";
            case("D"):
                return "description";
            default:
                return "";
        }
    }
    public String askForSearch(){
        io.println("Give a search term: ");
        return io.nextLine();
    }

    public Bookmark askForBookmark() {
        io.println("Add a new bookmark.");
        io.println("Give type (B = Book) (BG = Blog), (O = Other): ");
        String type = io.nextLine();

        Bookmark bookmark = null;

        if (type.equals("B")) {
            bookmark = askForBookBookmarkInfo();
        } else if (type.equals("BG")) {
            bookmark = askForBlogBookmarkInfo();
        } else if (type.equals("O")){
            bookmark = askForOtherBookmarkInfo(); 
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
            io.println("There are currently no bookmarks in memory. Add a new bookmark with command \"new\"");
        }
        for (Bookmark bmark : bookmarks) {
            io.println(bmark.toString());
        }
    }
    
    private Bookmark askForOtherBookmarkInfo(){
        String title = askForInput("Title: "); 
        String url = askForInput("Url: "); 
        String description = askForInput("Description: "); 
        
        return new OtherBookmark(title, url, description); 
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
            // pitäisikö tässä vaiheessa katsoa, että ei lisätä uutta tagia jos samanniminen on?
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
    public long askForEntryToEdit(List<Bookmark> bookmarks){
        System.out.println("Select an entry to edit by typing it's ID: ");
        for(Bookmark bookmark: bookmarks){
           io.println(bookmark.shortPrint());
        }
        return (long)io.nextInt();
    }
    public String askForEditField(){
        System.out.println("Select field to edit: A = Author or T = title");
        String field= io.nextLine();
        while(true){
            if(field.equals("A")){
                return "author";
            }else if(field.equals("T")){
                return "title";
            }else{
                field=io.nextLine();
            }
        }
    }
    public String askForNewField(String field){
        System.out.println("Give new entry for "+field);
        return io.nextLine();
    }
    private String askForInput(String prompt) {
        io.println(prompt);
        return io.nextLine();
    }

    public Long askForBookmarkToDelete() {
        io.println("Give ID of the bookmark you want to delete: ");
        return Long.parseLong(io.nextLine());
    }

}
