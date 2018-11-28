Feature: Searching for existing bookmarks is possible
    
    Scenario: user can search by author and find an existing bookmark
        Given option "search" is selected
        When input "A" is entered
        And input "Cucumber Chief" is entered
        And app is created
        Then system response will contain "ISBN: 12345-abcde"

    Scenario: user can search by title and find an existing bookmark
        Given option "search" is selected
        When input "T" is entered
        And input "Cucumber tutorial" is entered
        And app is created
        Then system response will contain "ISBN: 12345-abcde"

    Scenario: user can search by comment and find an existing bookmark
        Given option "search" is selected
        When input "C" is entered
        And input "a valuable part of a good testing arsenal." is entered
        And app is created
        Then system response will contain "ISBN: 12345-abcde"

    Scenario: user can search by description and find an existing bookmark
        Given option "search" is selected
        When input "D" is entered
        And input "a tutorial for definition testing" is entered
        And app is created
        Then system response will contain "ISBN: 12345-abcde"

    Scenario: user will only find bookmarks that match the search term
        Given option "search" is selected
        When input "A" is entered
        And input "nonExistentAuthor" is entered
        And app is created
        Then system response will contain "There are currently no bookmarks in memory."
