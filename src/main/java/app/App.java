package app;


import app.ui.TextUI;
import java.util.Scanner; 

public class App {
    private TextUI ui; 
    
    public App(TextUI ui){
        this.ui = ui;  
    }
    
    public void run(){
        ui.printWelcomeMessage();  
        ui.askForBookmark();
        System.out.println("Your bookmark has been read! (but not stored)");
    }
    
    
  public static void main(String[] args){
      TextUI ui = new TextUI(new Scanner(System.in)); 
      App app  = new App(ui); 
      app.run(); 
  }
}
