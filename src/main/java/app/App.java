package app;

import app.io.ConsoleIO;
import app.io.IO;
import app.ui.TextUI;
import bookmarks.AbstractBookmark;
import bookmarks.PodcastBookmark;
import java.util.List; 
import java.util.ArrayList; 
import java.util.Scanner;

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
        boolean run = true;
        while (run){
            io.println("Type \"new\" new bookmark or \"list\" to list all bookmarks or \"exit\" to exit the application");
            String command=io.nextLine();
            switch(command){
                case("new"):
                    AbstractBookmark bookmark = ui.askForBookmark();     
                    if(bookmark != null){
                        memory.add(bookmark);
                        io.println("Your bookmark has been read! (and will be stored)");
                    }
                    break;
                case("list"):
                    if (this.memory.isEmpty()){
                        io.println("There are currently no bookmarks on memory. Add a new bookmark with command \"new\"");
                    }
                    for(AbstractBookmark bmark: this.memory){
                        io.println(bmark.toString());
                    }
                    break;
                case("exit"):
                    io.println("Goodbye!");
                    run = false;
                    break;
                default:
                    io.println("Unrecognized option '"+command+"'");
                    run = false;
                    break;
            }
        }
    }
        
    public static void main(String[] args){
        ConsoleIO io = new ConsoleIO(); 
        TextUI ui = new TextUI(io); 
        List<AbstractBookmark> memory = new ArrayList(); 
        App app  = new App(ui, memory, io); 
        app.run(); 
    }
}
