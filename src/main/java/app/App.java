package app;


import app.ui.TextUI;
import java.util.Scanner;
import java.util.List; 
import java.util.ArrayList; 

public class App {
    private final TextUI ui; 
    private List<String> memory; 
    
    public App(TextUI ui, List<String> memory){
        this.ui = ui;  
        this.memory = memory; 
    }
    
    public void run(){
        ui.printWelcomeMessage();  
        String bookmark = ui.askForBookmark();
        System.out.println("Your bookmark has been read! (and will be stored)");
        memory.add(bookmark); 
    }
     
  public static void main(String[] args){
      TextUI ui = new TextUI(new Scanner(System.in)); 
      List<String> memory = new ArrayList(); 
      App app  = new App(ui, memory); 
      app.run(); 
  }
}
