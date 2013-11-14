#==============================
#Project: Match Story Data Capture
#Sprint: Sprint 02 UI
#Author: Shahnaaz Rahamatullah
#Date: 30-10-2013
#Jira Ticket: MSDC-65
#============================


Feature: 
As a Sports Information Processor, when I am on a match summary page, I should see a circle (game changing event flag) icon for each action displayed

@Complete
Scenario: Default game changing event flag 
Given I am on the summary page for a particular match "3667001"
Then I should see a game changing event flag for each action displayed and greyed out by default

@Complete
Scenario: Game changing event flag when highlighted
Given I am on the summary page for a particular match "3667001"
When I select the game changing event flag for a particular action in the match
Then I should see that the game changing event flag is highlighted in red

@Complete
Scenario: Game changing event flag icon already highlighted
Given I am on the summary page for a particular match "3667001"
And a game changing event flag for a particular action already selected
When I select the game changing event flag again
Then I should see that the game changing event flag greyed out