#=========================================================================================
#Project: Match story data capture
#Sprint: Sprint 02 UI
#Author: Archana Aravelly
#Date: 30/10/2013
#=========================================================================================
#Reviewer: 
#Date:
#=========================================================================================

#JIRA Ticket:MSDC-59
#=========================================================================================
Feature: As a Sports Information Processor When I am on the Match summary page, I should see the title bar with teams/score/badges's of the chosen match

Scenario: 01 - Verify title bar details
Given I am on home page
And I have the following selection:
|Competition              |Date                |
|Barclays Premier League  |Sun, 27 Oct, 2013   |
When I go to match summary page
Then I see the following:
| Badge A       | Team A   | Score A| Score B | Team B   | Badge B        |
| CHELSEA Badge | CHELSEA  | 2      | 1       | MAN CITY | MAN CITY Badge |


  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  