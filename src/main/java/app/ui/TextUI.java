package app.ui;

import java.util.Scanner;

public class TextUI {

    private final Scanner scanner;

    public TextUI(Scanner scanner) {
        this.scanner = scanner;
    }
    
    public void printWelcomeMessage(){
        System.out.println("Welcome");
    }

    public String askForBookmark() {
        System.out.println("Add a new bookmark:");
        return scanner.nextLine();
    }

}
