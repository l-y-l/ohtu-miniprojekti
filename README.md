[![Build Status](https://travis-ci.org/anonOstrich/ohtu-miniprojekti.svg?branch=master)](https://travis-ci.org/anonOstrich/ohtu-miniprojekti)
[![codecov](https://codecov.io/gh/anonOstrich/ohtu-miniprojekti/branch/master/graph/badge.svg)](https://codecov.io/gh/anonOstrich/ohtu-miniprojekti)

# Bookmark Library (ohtu-miniprojekti)
Ohjelmistotuotantokurssin miniprojekti


[backlog](https://docs.google.com/spreadsheets/d/1JXfi_ZUgXKkfvnegcy7C4KUzVWvdBlr7t2WN6icuReA/edit#gid=0)


## Definition of done
- Feature is functioning
- User story's acceptance criteria is tested
- There is enough testing:
  - Tests test relevant things
  - There is 80% row coverage
  - Tests pass
- Code is reviewed at least by one other developer (pull request)
- Documentation is adequate (javadoc +  relevant diagrams)

## Installation

## User guide
* In the beginning, user can choose whether to add a new bookmark or to list existing bookmarks
* Adding a new bookmark
  * First, user chooses which type of bookmark to add. There are four types:
    1. Book (B)
    2. Blog (BG)
    3. Podcast (P)
    4. Video (V)
  * When a bookmark type is chosen, application asks the relevant information concerning that type (eg. author, url,  prerequisite courses)
    * Tags and courses are given as lists where list items are separated by a comma(,)
