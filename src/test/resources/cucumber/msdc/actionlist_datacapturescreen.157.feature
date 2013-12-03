

#=========================================================================================
#Project: Match story data capture
#Sprint: Sprint 03 UI
#Author: Archana Aravelly
#Date: 120/11/2013
#=========================================================================================
#Reviewer: 
#Date:
#=========================================================================================

JIRA Ticket: MSDC-157

#=========================================================================================
Feature: Action list to appear on data capture screen

Scenario: 01 - 5 Actions list should represent that point in time
Given I am on match summary page
And I click action at certain time
And I click on add action button
When I am Data capture screen
Then the closest existing 5 actions display
And the middle action is highlighted

Scenario: 02 - Edit mode for a selected action
Given I am on Data capture screen
And the closest existing 5 actions display
When I click on one of the action
Then the action to move into middle of the list
And the breadcrumb is available


#Scenario: 03 - AC TO UPDATE / ADD BY BEN !!!!!!!!!!
#TO REPLACE SCROLLING THROUGH LIST

Scenario: 04 - Clicking Back button takes back to Match summary page
Given I am on Data capture screen
When I click on back button
Then I should be taken to Match summary page

Scenario: 05 - Clicking Back button while in PLAY mode takes back to Match summary page in PLAY mode
Given I am on Data capture screen
And I click on Play button at certain action
When I click on back button
Then I should be taken to Match summary page
And the play button is on
And the timing should match with Data capture screen

Scenario: 05 - Clicking Back button while in PAUSE mode takes back to Match summary page in PAUSE mode
Given I am on Data capture screen
And I click on Pause button at certain action
When I click on back button
Then I should be taken to Match summary page
And the pause button is on
And the timing should match with Data capture screen


