package app.ui;

import app.io.IO;
import app.io.StubIO;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Scanner; 

public class TextUITest {
    private IO io;
    private TextUI ui; 
    
    @Before
    public void setUp() {
        List<String> inputLines = new ArrayList<>();
        // Add input to inputlines for testing.
        
        io = new StubIO(inputLines);
        ui = new TextUI(io);
    }
    
    //@Test
    //public void askForBookMarkReturnsUserInput(){
    //    assertEquals("The Best Bookmark", ui.askForBookmark());
    //}

    
}
