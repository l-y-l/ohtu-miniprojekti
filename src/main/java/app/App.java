package app;


import app.io.ConsoleIO;
import app.io.IO;
import app.ui.TextUI;
import bookmarks.AbstractBookmark;
import bookmarks.PodcastBookmark;
import java.util.List; 
import java.util.ArrayList; 

public class App {
    private final TextUI ui;
    private IO io;
    private List<AbstractBookmark> memory; 
    
    public App(TextUI ui, List<AbstractBookmark> memory, IO io){
        this.ui = ui;  
        this.memory = memory; 
        this.io = io;
    }
    
    public void run(){
        ui.printWelcomeMessage();  
        AbstractBookmark bookmark = ui.askForBookmark();        
        if(bookmark != null) memory.add(bookmark);
        
        System.out.println("Welcome!");
        System.out.println("Type \"new\" new bookmark or \"list\" to list all bookmarks or \"exit\" to exit the application");
        String command=ui.getScanner().nextLine();
            switch(command){
                case("new"):
                    AbstractBookmark bookmark=ui.askForBookmark();
                    memory.add(bookmark);
                    System.out.println("Your bookmark has been read! (and will be stored)");
                case("list"):
                    for(AbstractBookmark bmark: this.memory){
                        System.out.println(bmark);
                    }
                case("exit"):
                    System.out.println("Goodbye!");
                    System.exit(0);
            }                
    }
    
}
