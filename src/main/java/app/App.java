package app;


import app.ui.TextUI;
import bookmarks.AbstractBookmark;
import bookmarks.PodcastBookmark;
import java.util.Scanner;
import java.util.List; 
import java.util.ArrayList; 

public class App {
    private final TextUI ui; 
    private List<AbstractBookmark> memory; 
    
    public App(TextUI ui, List<AbstractBookmark> memory){
        this.ui = ui;  
        this.memory = memory; 
    }
    
    public void run(){
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
     
  public static void main(String[] args){
      TextUI ui = new TextUI(new Scanner(System.in)); 
      List<AbstractBookmark> memory = new ArrayList(); 
      App app  = new App(ui, memory); 
      app.run(); 
  }
}
