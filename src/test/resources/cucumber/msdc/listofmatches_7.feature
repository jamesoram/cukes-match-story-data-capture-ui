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
  When I have the following selection:
	|Competition              |Date                |
	|Barclays Premier League  |Sun, 27 Oct, 2013   |
  Then I see a list of matches as following:
    | Time   |  Team A        | Team A logo  | Score A | score B  | Team B logo  | Team B         | Right Arrow | 
    | 13:30  |  SUNDERLAND    | Team A logo  | 2       | 1        | Team B logo  | NEWCASTLE      | Grey        |
    | 16:30  |  CHELSEA       | Team A logo  | 2       | 1        | Team B logo  | MAN CITY       |  			|
    | 16:30  |  SWANSEA       | Team A logo  | 0       | 0        | Team B logo  | WEST HAM       |  			|
    | 16:30  |  SPURS         | Team A logo  | 1       | 0        | Team B logo  | HULL           |  			|
    
  
#Check test data
Scenario: 02 - Green right arrow on the Match row indicates that there is existing data entry
  Given I am on the home page
  And I have the following selection with existing data for a match:
	|Competition              |Date                |
    |Barclays Premier League  |Sun, 27 Oct, 2013   | 
  And I see the list of matches
  When I click on the green right arrow for a match
  Then I should see existing data entry for that match
  

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
  And I have the following selection with existing data for a match:
	|Competition              |Date                |
    |Barclays Premier League  |Sun, 15 Oct, 2013   |
  Then I should see an empty list
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  