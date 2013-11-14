#===================================
#Project: Match Story Data Capture
#Sprint: Sprint 02 UI
#Author: Shahnaaz Rahamatullah
#Date: 30-10-2013
#Jira Ticket: MSDC-143
#============================


Feature: 
As a Sports Information Processor When I am on Match summary page, I should see the red card icon for all dismissal actions

@Complete
Scenario: Red card icon
Given I am on the summary page for a particular match "3667002"
And a player has got a red card 
Then I should see a red card icon displayed for that particular action

