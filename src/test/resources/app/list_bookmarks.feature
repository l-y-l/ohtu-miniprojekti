Feature: Listing bookmarks by storage date or by alphabetical order of the titles is possible.
    
    Scenario: user can list bookmarks by titles in alphabetical order
        Given option "2" is selected
        When input "T" is entered
        And app is created
        Then system response will contain "Antarctic" before "Experience"

    Scenario: user can list bookmarks by storage date in descending order
        Given option "2" is selected
        When input "CD" is entered
        And app is created
        Then system response will contain "Antarctic" before "tutorial"

    Scenario: user can list bookmarks by storage date in ascending order
        Given option "2" is selected
        When input "CA" is entered
        And app is created
        Then system response will contain "Cucumber" before "tutorial"