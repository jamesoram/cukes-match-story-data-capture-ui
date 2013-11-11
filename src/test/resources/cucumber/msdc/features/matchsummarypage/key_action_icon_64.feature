#===================================
#Project: Match Story Data Capture
#Sprint: Sprint 02 UI
#Author: Shahnaaz Rahamatullah
#Date: 30-10-2013
#Jira Ticket: MSDC-64
#============================
#Reviewer: Not reviewed yet
#Date of review: NA
#============================

Feature: 
As a Sports Information Processor, when I am on a match summary page, I should see an favourite icon for each action displayed


Scenario: Default favourite icon
Given I am on the summary page for a particular match "3667001"
Then I should see an favourite icon for each action displayed and greyed out by default


Scenario: Exclamation icon when highlighted
Given I am on the summary page for a particular match "3667001"
When I select the favourite icon for a particular action in the match
Then I should see that the favourite icon is highlighted in yellow


Scenario: Exclamation icon already highlighted
Given I am on the summary page for a particular match "3667001"
And an favourite icon for a particular action already selected
When I select the favourite icon again
Then I should see that the favourite icon is greyed out