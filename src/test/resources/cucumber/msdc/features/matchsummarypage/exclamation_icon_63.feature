#===================================
#Project: Match Story Data Capture
#Sprint: Sprint 02 UI
#Author: Shahnaaz Rahamatullah
#Date: 30-10-2013
#Jira Ticket: MSDC-63
#============================


Feature: 
As a Sports Information Processor, when I am on a match summary page, I should see an exclamation icon for each action displayed

@Complete
Scenario: Default exclamation icon
Given I am on the summary page for a particular match "3667001"
Then I should see an exclamation icon for each action displayed and greyed out by default

@Complete
Scenario: Exclamation icon when highlighted
Given I am on the summary page for a particular match "3667001"
When I select the exclamation icon for a particular action in the match
Then I should see that the exclamation icon is highlighted in red

@Complete
Scenario: Exclamation icon already highlighted
Given I am on the summary page for a particular match "3667001"
And an exclamation icon for a particular action already selected
When I select the exclamation icon again
Then I should see that the exclamation icon is greyed out