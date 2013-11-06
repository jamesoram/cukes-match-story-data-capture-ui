#===================================
#Project: Match Story Data Capture
#Sprint: Sprint 02 UI
#Author: Shahnaaz Rahamatullah
#Date: 30-10-2013
#Jira Ticket: MSDC-61
#============================
#Reviewer: Not reviewed yet
#Date of review: NA
#============================

Feature: As a Sports Information Processor, when I am on Match summary page, I should see match actions list ordered by Time

@Shahnaaz
Scenario: Actions displayed in descending order of time
Given I am on the summary page for a particular match
Then I should see the actions list displayed in descending order of time