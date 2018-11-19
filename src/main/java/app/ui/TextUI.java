package app.ui;

import bookmarks.AbstractBookmark;
import bookmarks.BookBookmark;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class TextUI {

    private final Scanner scanner;

    public TextUI(Scanner scanner) {
        this.scanner = scanner;
    }
    
    public void printWelcomeMessage(){
        System.out.println("Welcome");
    }

    public AbstractBookmark askForBookmark() {
        System.out.println("Add a new bookmark.");
        System.out.println("Give type (B = Book): ");
        String type = scanner.nextLine();
        
        if (type.equals("B")) {
            BookBookmark bookmark = askForBookBookmarkInfo();
            return bookmark;
        } else {
            System.out.println("Invalid choice");
            return null;
        }
    }

    private BookBookmark askForBookBookmarkInfo() {
        String author = askForAuthor();
        String title = askForTitle();
        
        System.out.println("ISBN: ");
        String isbn = scanner.nextLine();
        
        ArrayList<String> tagList = askForTags();
        ArrayList<String> prerequisiteList = askForPrerequisites();
        ArrayList<String>  relatedCourseList = askForRelatedCourses();
   
        return new BookBookmark(author, title, isbn, tagList, prerequisiteList, relatedCourseList);
    }

    private String askForAuthor() {
        System.out.println("Author: ");
        return scanner.nextLine();
    }

    private String askForTitle() {
        System.out.println("Title: ");
        return scanner.nextLine();
    }

    private ArrayList<String> askForTags() {
        System.out.println("Tags (separated by \",\"): ");
        String tags = scanner.nextLine();
        return new ArrayList<>(Arrays.asList(tags.split(",")));
    }

    private ArrayList<String> askForPrerequisites() {
        System.out.println("Prerequisite courses (separated by \",\"): ");
        String prerequisiteCourses = scanner.nextLine();
        return new ArrayList<>(Arrays.asList(prerequisiteCourses.split(","))); 
    }

    private ArrayList<String> askForRelatedCourses() {
        System.out.println("Related courses (separated by \",\"): ");
        String relatedCourses = scanner.nextLine();
        return new ArrayList<>(Arrays.asList(relatedCourses.split(",")));
    }

}
