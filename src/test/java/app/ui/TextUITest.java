package app.ui;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Scanner; 

public class TextUITest {
    private Scanner scanner; 
    private TextUI ui; 
    
    @Before
    public void setUp() {
        scanner = new Scanner("The Best Bookmark"); 
        ui = new TextUI(scanner);
    }
    
    //@Test
    //public void askForBookMarkReturnsUserInput(){
    //    assertEquals("The Best Bookmark", ui.askForBookmark());
    //}

    
}
