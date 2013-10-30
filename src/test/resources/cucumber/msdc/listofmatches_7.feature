#=========================================================================================
#Project: Match story data capture
#Sprint: Sprint 01 UI
#Author: Archana Aravelly
#Date: 15/10/2013
#=========================================================================================
#Reviewer: 
#Date:
#=========================================================================================
# JIRA Ticket:MSDC-7
#=========================================================================================

Feature: As a Sports Information Processor I want to see a list of Match dates for a selected Competition,
so I can select the Match Day and choose a Match

Scenario: 01 - Able to see a list of matches for a selected competition
  Given I am on the home page
  When I select competition "Barclays Premier League" and match date "Sun, 27 Oct, 2013"
  Then I should see the following list of matches with scores:
    | Time   |  Home          | Score  | Away           |
    | 13:30  |  SUNDERLAND    | 2 - 1  | NEWCASTLE      |
    | 16:00  |  CHELSEA       | 2 - 1  | MAN CITY       |
    | 16:00  |  SWANSEA       | 0 - 0  | WEST HAM       |
    | 16:00  |  SPURS         | 1 - 0  | HULL           |
    
  
#TODO when dev work is complete
Scenario: 02 - Green right arrow on the Match row indicates that there is existing data entry
  Given I am on the home page
  And I have the following selection with existing data for a match:
	|Competition              |Date                |
    |Barclays Premier League  |Sun, 27 Oct, 2013   | 
  And I see the list of matches
  When I click on the green right arrow for a match
  Then I should see existing data entry for that match
  
#TODO when dev work is complete
Scenario: 03 - Grey right arrow on the Match row indicates that there is NO existing data entry
  Given I am on the home page
  And I have the following selection with existing data for a match:
	|Competition              |Date                |
    |Barclays Premier League  |Sun, 27 Oct, 2013   |
  And I see list of matches
  When I click on the grey right arrow for a match
  Then I should see no existing data entry for that match

Scenario: 04 - Empty list of matches for a competition
  Given I am on the home page
  When I select competition "Barclays Premier League" and match date "Sun, 15 Oct, 2013"
  Then I should see an empty match list
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  