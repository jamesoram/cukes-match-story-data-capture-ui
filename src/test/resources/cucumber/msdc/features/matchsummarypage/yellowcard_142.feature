#===================================
#Project: Match Story Data Capture
#Sprint: Sprint 02 UI
#Author: Shahnaaz Rahamatullah
#Date: 30-10-2013
#Jira Ticket: MSDC-142
#============================
#Reviewer: Not reviewed yet
#Date of review: NA
#============================

Feature: 
As a Sports Information Processor When I am on Match summary page, I should see the yellow card icon for all booking actions


Scenario: Yellow card icon
Given I am on the summary page for a particular match "3669788"
And a player has got a yellow card
Then I should see a yellow card icon displayed for that particular action