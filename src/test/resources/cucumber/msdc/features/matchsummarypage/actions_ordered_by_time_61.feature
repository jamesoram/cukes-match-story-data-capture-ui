#===================================
#Project: Match Story Data Capture
#Sprint: Sprint 02 UI
#Author: Shahnaaz Rahamatullah
#Date: 30-10-2013
#Jira Ticket: MSDC-61
#============================


Feature: As a Sports Information Processor, when I am on Match summary page, I should see match actions list ordered by Time


Scenario: Actions displayed in descending order of time
Given I am on the summary page for a particular match "3667001"
Then I should see the actions list displayed in descending order of time