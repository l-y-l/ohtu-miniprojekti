Feature: Deleting an existing bookmark is possible

    Scenario: user can delete an existing bookmark
        Given option "5" is selected
        When input number 2 is entered
        And input "3" is entered
        And input "T" is entered
        And input "Cucumber tutorial" is entered
        And app is created
        Then system response will not contain "ISBN: 12345-abcde"
