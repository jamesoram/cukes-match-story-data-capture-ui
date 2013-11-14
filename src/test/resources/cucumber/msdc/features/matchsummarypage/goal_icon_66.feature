#===================================
#Project: Match Story Data Capture
#Sprint: Sprint 02 UI
#Author: Shahnaaz Rahamatullah
#Date: 31-10-2013
#Jira Ticket: MSDC-66
#============================


Feature: 
As a Sports Information Processor, when I am on a match summary page, I should see a football icon for each type of goal action

@Complete
Scenario: Football icon - goal action
Given I am on the summary page for a particular match "3643941"
And a player has scored a goal action
Then I should see a football icon for the goal action

@Complete
Scenario: Football icon - goal from penalty action

Given I am on the summary page for a particular match "3669788"
And a player has scored a goal from penalty action
Then I should see a football icon for the goal from penalty action

@Complete
Scenario: Football icon - penalty shootout action
Given I am on the summary page for a particular match "3510294"
And a player has scored a goal from penalty shootout action
Then I should see a football icon for the penalty shootout action

@Complete
Scenario: Football icon - own goal action
Given I am on the summary page for a particular match "3631371"
And a player has scored an own goal
Then I should see a football icon for the own goal action