Feature: Adding a bookmark with valid information is possible

    Scenario: user can only select a bookmark type that exists
       Given  option "1" is selected
       And  bookmark type "nothing" is selected
       And  app is created
       Then  system will respond with "Invalid choice"

    Scenario: user can add a Book Bookmark
       Given option "1" is selected
       And  bookmark type "B" is selected
       When  input "testISBN1" is entered
       And  input "testTitle1" is entered
       And  input "testAuthor1" is entered
       And input "testUrl" is entered
       And  input "test,Tags,1" is entered
       And input "testDescription" is entered
       And  app is created
       Then  system will respond with "Your bookmark has been read!"

    Scenario: user can add a Blog Bookmark
       Given option "1" is selected
       And  bookmark type "BG" is selected
       When  input "testUrl1" is entered
       And  input "testTitle1" is entered
       And  input "test,Tags,1" is entered
       And  app is created
       Then  system will respond with "Your bookmark has been read!"

    Scenario: user can add an Other Bookmark
        Given option "1" is selected
        And bookmark type "O" is selected
        When input "testUrl" is entered
        And input "testTitle1" is entered
        And input "testDescription" is entered
        And app is created
        Then system will respond with "Your bookmark has been read!"
