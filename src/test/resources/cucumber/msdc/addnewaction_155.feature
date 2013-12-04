#=========================================================================================
#Project: Match story data capture
#Sprint: Sprint 03 UI
#Author: Archana Aravelly
#Date: 19/11/2013
#=========================================================================================
#Reviewer: 
#Date:
#=========================================================================================

#JIRA Ticket:MSDC-155

#=========================================================================================
Feature: Adding new actions

Scenario: 01 - Clicking Add button links through to Data Capture screen
Given I am on match summary page
And I click action at certain time
When I click on add action button
Then I should be taken to Data capture screen
And the selected time to shown on Data capture screen


Scenario: 02 - Clicking Add button while playing
Given I am on match summary page
And I click on play button from certain time
And I click action at certain time
When I click on add action button
Then I should be taken to Data capture screen
And the time at playing to shown on Data capture screen



Scenario: 03 - Clicking Add button while pause
Given I am on match summary page
And I click on play from certain time
And I click on pause button at certain time
And I click action at certain time
When I click on add action button
Then I should be taken to Data capture screen
And the time at pause to shown on Data capture screen


Scenario: 04 - Action list should represent that point in time
Given I am on match summary page
And I click action at certain time
And I click on add action button
When I am Data capture screen
Then the closest existing action should be highlighted in the middle of the list of 5 actions

