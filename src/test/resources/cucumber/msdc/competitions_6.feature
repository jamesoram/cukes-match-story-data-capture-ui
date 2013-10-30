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
  When I click on the down arrow from the Competition field
  Then I should see the following:
  |Competition              |
  |Barclays Premier League  |
   

Scenario: 02 - Selecting a different competition from the list
  Given I am on the home page
  When I click on the down arrow from the competitions list
  And I have the following selection:
  |Competition            |
  |UEFA Champions League  |
  Then the drop down box is closed
  And I have the following selection:
  |Competition            |
  |UEFA Champions League  |
  

  


  

  
  