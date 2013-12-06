#=========================================================================================
#Project: Match story data capture
#Sprint: Sprint 02 UI
#Author: Archana Aravelly
#Date: 28/10/2013
#=========================================================================================
#Reviewer: 
#Date:
#=========================================================================================

#JIRA Ticket:MSDC-58 :As a Sports Information Processor I want to access the Match summary page by selecting a match from the list on home page
#=========================================================================================
Feature: As a Sports Information Processor I want to access the Match summary page by selecting a match from the list on home page

Scenario: 01 - Access to Match summary page for a past match

Given I have the following selection:
|Competition              |Date                |
|Barclays Premier League  |Sun, 27 Oct, 2013   |
When I click on right arrow button for a match
Then I should be taken to the match summary page

Scenario: 02 - Access to Match summary page for a future match
Given I have the following selection:
|Competition              |Date                |
|Barclays Premier League  |Sat, 12 Apr, 2016   |
When I see the list of matches
Then the right arrow button is not seen