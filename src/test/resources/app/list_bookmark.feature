Feature: Listing bookmarks is possible
    Scenario: user can list bookmarks by their title
        Given option "2" is selected
        When input "T" is entered
        And app is created
        Then system response will contain "Antarctic weekly" before "Cucumber Experience"
        And system response will contain "Cucumber Experience" before "Cucumber tutorial"
        And system response will contain "Cucumber tutorial" before "DeleteCast"

    Scenario: user can list bookmarks by their creation date in ascending order
        Given option "2" is selected
        When input "CA" is entered
        And app is created
        Then system response will contain "Cucumber Experience" before "Cucumber tutorial"
        And system response will contain "Cucumber tutorial" before "DeleteCast"
        And system response will contain "DeleteCast" before "Antarctic weekly"

    Scenario: user can list bookmarks by their creation date in descending order
        Given option "2" is selected
        When input "CD" is entered
        And app is created
        Then system response will contain "Antarctic weekly" before "DeleteCast"
        And system response will contain "DeleteCast" before "Cucumber tutorial"
        And system response will contain "Cucumber tutorial" before "Cucumber Experience"