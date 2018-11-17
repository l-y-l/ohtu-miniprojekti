package app;

import java.util.Scanner; 

public class App {
    private final Scanner scanner; 
    
    public App(Scanner scanner){
        this.scanner = scanner; 
    }
    
    public void run(){
        System.out.println("Welcome!");
        System.out.println("Add a new bookmark:");
    }
    
    
  public static void main(String[] args){
      App app  = new App(new Scanner(System.in)); 
      app.run(); 
  }
}
