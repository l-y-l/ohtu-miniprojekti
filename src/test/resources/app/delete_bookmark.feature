Feature: Deleting an existing bookmark is possible

    Scenario: user can delete an existing bookmark
        Given option "delete" is selected
        When input "3" is entered
        And input "search" is entered
        And input "A" is entered
        And input "Mr. Delete" is entered
        And app is created
        Then system response will not contain "Author: Mr. Delete"
