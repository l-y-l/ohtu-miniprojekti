package app.ui;

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
    private final HashMap<String,String> selectedEditFieldMap = new HashMap<>();
    private final HashMap<String,String> bookmarkTypeToAskEditFieldPrintMap = new HashMap<>();

    public TextUI(IO io) {
        this.io = io;
        initSelectedEditFieldMap();
        initBookmarkTypeToAskEditFieldPrintMap();
    }

    public void printWelcomeMessage() {
        io.println("Welcome!");
    }

    public void printGoodbyeMessage() {
        io.println("Goodbye");
    }

    public void printUnrecognizedOption() {
        io.println("Unrecognized option");
    }

    public String getMenuCommand() {
        io.println("\nSelect one of the following options \n1. Add a new bookmark by typing \n2. List all existing bookmarks\n3. Search a specific bookmark"
                + "\n4. Edit a bookmark\n5. Delete a bookmark\n0. Exit the application");
        return io.nextLine();
    }

    public String askForField() {
        io.println("Which field would you like to search?");
        io.println("Give field (T = Title) (D = Description)");
        String command = io.nextLine();
        switch (command) {
            case ("T"):
                return "title";
            case ("D"):
                return "description";
            default:
                return "";
        }
    }

    public String askForSearch() {
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
        } else if (type.equals("O")) {
            bookmark = askForOtherBookmarkInfo();
        }

        if (bookmark != null) {
            io.println(defaultSuccessMessage);
            return bookmark;
        }

        io.println("Invalid choice");
        return null;

    }
    
    public String askForListingMethod() {
        io.println("Choose listing method:");
        io.println("(T = Title)(CD = Creation time Descending)(CA = Creation time Ascending)");
        return io.nextLine();
    }

    public void printBookmarkList(List<Bookmark> bookmarks) {
        io.println("");
        if (bookmarks.isEmpty()) {
            io.println("No bookmarks found.");
        }
        for (Bookmark bmark : bookmarks) {
            io.println(bmark.toString());

            io.println("==================================================");
        }
    }
    
    private Bookmark askForOtherBookmarkInfo() {
        OtherBookmark bm = new OtherBookmark();
        String url = askForInput("Url: ");
        bm.setUrl(url);
        askForGeneralBookmarkInfo(bm);
        return bm;
    }

    private Bookmark askForBookBookmarkInfo() {
        BookBookmark bm = new BookBookmark();
        String isbn = askForInput("ISBN: ");
        bm.setISBN(isbn);

        String title = askForInput("Title: ");
        bm.setTitle(title);

        String author = askForInput("Author: ");
        bm.setAuthor(author);

        List<Tag> tagsList = askForTags();
        bm.setTags(tagsList);

        String description = askForInput("Description: ");
        bm.setDescription(description);

        return bm;
    }

    private Bookmark askForBlogBookmarkInfo() {
        BlogBookmark bm = new BlogBookmark();
        String url = askForInput("Url: ");
        bm.setUrl(url);
        askForGeneralBookmarkInfo(bm);
        return bm;
    }

    private Bookmark askForGeneralBookmarkInfo(Bookmark bookmark) {
        String title = askForInput("Title: ");
        bookmark.setTitle(title);

        List<Tag> tagsList = askForTags();
        bookmark.setTags(tagsList);

        String description = askForInput("Description: ");
        bookmark.setDescription(description);

        return bookmark;
    }

    public List<Tag> askForTags() {
        System.out.println("Tags (separated by commas): ");
        String input = io.nextLine();
        String[] tags = input.split(",");
        List<Tag> result = new ArrayList();
        for (int i = 0; i < tags.length; i++) {
            // pitäisikö tässä vaiheessa katsoa, että ei lisätä uutta tagia jos samanniminen on?
            result.add(new Tag(tags[i].trim()));
        }

        return result;
    }

    private void shortListBookmarks(List<Bookmark> bookmarks){
        for (Bookmark bookmark : bookmarks) {
            io.println(bookmark.shortPrint());
        }
    }

    private Long getInt(){
        Long value;
        try {
            value = Long.parseLong(io.nextLine());
        } catch (NumberFormatException e) {
            return 0L;
        }
        return value;
    }

    public Long askForBookmarkToEdit(List<Bookmark> bookmarks) {
        io.println("Select an entry to edit by typing its ID: ");
        shortListBookmarks(bookmarks);
        return getInt();
    }

    public Long askForBookmarkToDelete(List<Bookmark> bookmarks) {
        io.println("Give ID of the bookmark you want to delete: ");
        shortListBookmarks(bookmarks);
        return getInt();
    }

    public String askForEditField(String bookmark) {
        askUserForEditFieldMessage(bookmark);

        while (true) {
            String output = selectedEditFieldMap.get(io.nextLine());

            if (output != null) {
                return output;
            }
        }
    }

    private void initSelectedEditFieldMap() {
        selectedEditFieldMap.put("A", "author");
        selectedEditFieldMap.put("T", "title");
        selectedEditFieldMap.put("U", "url");
        selectedEditFieldMap.put("D", "description");
        selectedEditFieldMap.put("X", "tags");
    }

    private void initBookmarkTypeToAskEditFieldPrintMap() {
        bookmarkTypeToAskEditFieldPrintMap.put("Book", "\nA = Author\nT = title\nD = description\nX = tags");
        bookmarkTypeToAskEditFieldPrintMap.put("Blogpost", "\nT = title\nU = url\nD = description\nX = tags");
        bookmarkTypeToAskEditFieldPrintMap.put("Other", "\nT = title\nU = url\nD = description\nX = tags");
    }

    private void askUserForEditFieldMessage(String bookmark) {
        String bookmarkType = bookmark.split(" ")[3].trim();
        String ask = bookmarkType + "\n\nSelect field to edit:";

        ask += bookmarkTypeToAskEditFieldPrintMap.get(bookmarkType);

        io.println(ask);
    }

    public String askForNewField(String field) {
        io.println("Give new entry for " + field);
        return io.nextLine();
    }

    private String askForInput(String prompt) {
        io.println(prompt);
        return io.nextLine();
    }

    public void viewBookmarkEditedMessage(){
        io.println("Bookmark successfully edited.");
    }

    public void viewBookmarkDeletedMessage() {
        io.println("Bookmark successfully deleted.");
    }

}
