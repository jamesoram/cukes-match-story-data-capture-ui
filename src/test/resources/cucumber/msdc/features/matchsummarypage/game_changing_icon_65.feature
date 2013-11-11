#==============================
#Project: Match Story Data Capture
#Sprint: Sprint 02 UI
#Author: Shahnaaz Rahamatullah
#Date: 30-10-2013
#Jira Ticket: MSDC-65
#============================
#Reviewer: Not reviewed yet
#Date of review: NA
#============================

Feature: 
As a Sports Information Processor, when I am on a match summary page, I should see a circle (game changing event flag) icon for each action displayed


Scenario: Default circle (game changing event flag) icon
Given I am on the summary page for a particular match "3667001"
Then I should see a circle (game changing event flag) icon for each action displayed and greyed out by default


Scenario: Circle (game changing event flag) icon when highlighted
Given I am on the summary page for a particular match "3667001"
When I select the circle (game changing event flag) icon for a particular action in the match
Then I should see that the circle (game changing event flag) icon is highlighted in red


Scenario: Circle (game changing event flag) icon already highlighted
Given I am on the summary page for a particular match "3667001"
And a circle (game changing event flag) icon for a particular action already selected
When I select the circle (game changing event flag) icon again
Then I should see that the circle (game changing event flag) icon greyed out