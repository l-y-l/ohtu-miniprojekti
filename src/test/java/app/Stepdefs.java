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
    List<Integer> inputNumbers = new ArrayList();
    private BookMarkDAO dao;

    public Stepdefs() {
        createTestBookmarks();
    }

    public void createTestBookmarks() {
        inputLines.add("1");
        inputLines.add("BG");
        inputLines.add("martindawes.com/cucumberexperience");
        inputLines.add("Cucumber Experience");
        inputLines.add("cucumber,podcast");
        inputLines.add("Delve into the depths of cucumber.");

        inputLines.add("1");
        inputLines.add("B");
        inputLines.add("12345-abcde");
        inputLines.add("Cucumber tutorial");
        inputLines.add("Cucumber Chief");
        inputLines.add("cucumber,tutorial");
        inputLines.add("a tutorial for definition testing");

        inputLines.add("1");
        inputLines.add("BG");
        inputLines.add("mrdelete.com/deletecast");
        inputLines.add("DeleteCast");
        inputLines.add("deleted");
        inputLines.add("Will be deleted.");
    }

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

    @When("input number {int} is entered")
    public void input_number_is_entered(int input) throws Throwable {
        inputNumbers.add(input);
    }

    @When("app is created")
    public void app_is_created() throws Throwable {
        inputLines.add("0");
        io = new StubIO(inputLines, inputNumbers);
        dao = new BookMarkDAO(Utilities.TEST_DATABASE);
        app = new App(io, dao);
        app.run();
    }

    @Then("system will respond with {string}")
    public void system_will_respond_with(String expectedOutput) throws Throwable {
        assertTrue(io.getPrints().contains(expectedOutput));
        close();
    }

    @Then("system response will contain {string}")
    public void system_response_will_contain(String expectedOutput) {
        boolean found = false;
        for (String print : io.getPrints()) {
            if (print.contains(expectedOutput)) {
                found = true;
                break;
            }
        }
        assertTrue(found);
        close();
    }

    @Then("system response will not contain {string}")
    public void system_response_will_not_contain(String expectedOutput) {
        boolean found = false;
        for (String print : io.getPrints()) {
            if (print.contains(expectedOutput)) {
                found = true;
                break;
            }
        }
        assertTrue(!found);
        close();
    }

    private void close() {
        dao.close();
    }

}
