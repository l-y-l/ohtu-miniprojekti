package app;

import app.dao.BookMarkDAO;
import app.io.StubIO;
import app.ui.TextUI;
import app.utilities.Utilities;
import bookmarks.Bookmark;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;


public class Stepdefs {
    App app;
    TextUI ui;
    StubIO io;
    List<Bookmark> memory = new ArrayList();
    List<String> inputLines = new ArrayList();
    private BookMarkDAO dao; 
    

    
    
    @Given("bookmark type {string} is selected")
    public void bookmark_type_is_selected(String type) {
        inputLines.add(type);
    }

    @Given("option {string} is selected")
    public void option_is_selected(String input) throws Throwable {
        inputLines.add(input);
    }
    
    
    @When("input {string} is entered")
    public void input_is_entered(String input) throws Throwable {
        inputLines.add(input);
    }
    
    @When("app is created")
    public void app_is_created() throws Throwable {
        inputLines.add("exit");
        io = new StubIO(inputLines); 
        dao = new BookMarkDAO(Utilities.TEST_DATABASE);
        app = new App(io, dao);
        app.run();
    }
    
    @Then("system will respond with {string}")
    public void system_will_respond_with(String expectedOutput) throws Throwable {
        assertTrue(io.getPrints().contains(expectedOutput));
        close();
    }
    
    
    private void close(){
        dao.close();
    }
    
}
