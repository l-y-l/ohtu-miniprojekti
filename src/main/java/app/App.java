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
        AbstractBookmark bookmark = ui.askForBookmark();        
        if(bookmark != null) memory.add(bookmark);
                  
    }
    
  public static void main(String[] args){
      ConsoleIO io = new ConsoleIO(); 
      TextUI ui = new TextUI(io); 
      List<AbstractBookmark> memory = new ArrayList(); 
      App app  = new App(ui, memory, io); 
      app.run(); 
  }
    
}
