#=========================================================================================
#Project: Match story data capture
#Sprint: Sprint 03 UI
#Author: Archana Aravelly
#Date: 05/11/2013
#=========================================================================================
#Reviewer: 
#Date:
#=========================================================================================
# JIRA Ticket:MSDC-142, MSDC-143
#=========================================================================================

Feature: As a Sports Information Processor When I am on Match summary page, I should be able to see the yellow card icon for all booking actions and Red card icon for all dismissal actions

    
  
#TODO 
Scenario: 01 - Yellow card to show for booking action 
  Given I am on the match summary page for the following selection:
  	|Competition              |Date                |Match                    |
    |Barclays Premier League  |Sat, 19 Oct, 2013   |WEST HAM 1 - 3 MAN CITY  |
  When I scroll down to time line 62:33
  Then I should see an yellow card
  
#TO DO , find a match with red card for test data
Scenario: 02 - Red card to show for booking action 
  Given I am on the match summary page for the following selection:
  	|Competition              |Date                |Match                    |
    |Barclays Premier League  |Sat, 19 Oct, 2013   |WEST HAM 1 - 3 MAN CITY  |
  When I scroll down to time line 62:33
  Then I should see an yellow card

  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  