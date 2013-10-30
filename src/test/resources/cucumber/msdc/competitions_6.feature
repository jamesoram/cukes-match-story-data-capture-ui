#=========================================================================================
#Project: Match story data capture
#Sprint: Sprint 01 UI
#Author: Archana Aravelly
#Date: 15/10/2013
#=========================================================================================
#Reviewer: 
#Date:
#=========================================================================================
# JIRA Ticket:MSDC-6
#=========================================================================================

Feature: As a Sports Information Processor I want to see the list of Competitions so I can select the Match to work on

Scenario: 01 - Verifying default competition as Barclays Premier League and choose another competition from the list
  Given I am on the home page
  Then I should see competition "Barclays Premier League" as default

   
Scenario: 02 - Selecting a different competition from the list
  Given I am on the home page
  When I select competition "Barclays Premier League" and match date "Sun, 27 Oct, 2013"
  And I change competition to "UEFA Champions League"
  Then the match date should be different from "Sun, 27 Oct, 2013"
 
  
  