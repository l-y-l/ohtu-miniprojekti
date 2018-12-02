Feature: Adding a bookmark with valid information is possible

    Scenario: user can only select a bookmark type that exists
       Given  option "new" is selected
       And  bookmark type "nothing" is selected
       And  app is created
       Then  system will respond with "Invalid choice"

    Scenario: user can add a Book Bookmark
       Given option "1" is selected
       And  bookmark type "B" is selected
       When  input "testAuthor1" is entered
       And  input "testTitle1" is entered
       And  input "testISBN1" is entered
       And  input "test,Tags,1" is entered
       And  input "test,Prerequisite,C1" is entered
       And  input "test,Related,C1" is entered
       And  app is created
       Then  system will respond with "Your bookmark has been read!"

    Scenario: user can add a Blog Bookmark
       Given option "1" is selected
       And  bookmark type "BG" is selected
       When  input "testAuthor1" is entered
       And  input "testTitle1" is entered
       And  input "testUrl1" is entered
       And  input "test,Tags,1" is entered
       And  input "test,Related,C1" is entered
       And  app is created
       Then  system will respond with "Your bookmark has been read!"

Scenario: user can add a Podcast Bookmark
       Given option "1" is selected
       And  bookmark type "P" is selected
       When  input "testAuthor1" is entered
       And  input "testTitle1" is entered
       And  input "testDescription1" is entered
       And  input "testTags1" is entered
       And  input "test,Related,C1" is entered
       And  app is created
       Then  system will respond with "Your bookmark has been read!"

Scenario: user can add a Video Bookmark
       Given option "1" is selected
       And  bookmark type "V" is selected
       When  input "testTitle1" is entered
       And  input "testUrl1" is entered
       And  input "testTags1" is entered
       And  input "test,Related,C1" is entered
       And  input "testComment1" is entered
       And  app is created
       Then  system will respond with "Your bookmark has been read!"

