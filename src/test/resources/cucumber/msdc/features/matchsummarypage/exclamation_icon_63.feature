#===================================
#Project: Match Story Data Capture
#Sprint: Sprint 02 UI
#Author: Shahnaaz Rahamatullah
#Date: 30-10-2013
#Jira Ticket: MSDC-63
#============================
#Reviewer: Not reviewed yet
#Date of review: NA
#============================

Feature: 
As a Sports Information Processor, when I am on a match summary page, I should see an exclamation icon for each action displayed

Scenario 1: Default exclamation icon
Given I am on the summary page for a particular match
Then I should see an exclamation icon for each action displayed and greyed out by default

Scenario 2: Exclamation icon when highlighted
Given I am on the summary page for a particular match
When I select the exclamation icon for a particular action in the match
Then I should see that the exclamation icon is highlighted in red

Scenario 3: Exclamation icon already highlighted
Given I am on the summary page for a particular match
And an exclamation icon for a particular action already selected
When I select the exclamation icon again
Then I should see that the exclamation icon is greyed out