#===================================
#Project: Match Story Data Capture
#Sprint: Sprint 02 UI
#Author: Shahnaaz Rahamatullah
#Date: 31-10-2013
#Jira Ticket: MSDC-66
#============================
#Reviewer: Not reviewed yet
#Date of review: NA
#============================

Feature: 
As a Sports Information Processor, when I am on a match summary page, I should see a football icon for each type of goal action

Scenario 1: Football icon - goal action
Given I am on the summary page for a particular match
Then I should see a football icon for all the "goal" actions in a match

Scenario 2: Football icon - goal from penalty action
Given I am on the summary page for a particular match
Then I should see a football icon for all "goal from penalty" actions in a match

Scenario 3: Football icon - penalty shootout action
Given I am on the summary page for a particular match
Then I should see a football icon for all "penalty shootout" actions in a match

Scenario 4: Football icon - own goal action
Given I am on the summary page for a particular match
Then I should see a football icon for all "own goal" actions in a match