#===================================
#Project: Match Story Data Capture
#Sprint: Sprint 02 UI
#Author: Shahnaaz Rahamatullah
#Date: 11-11-2013
#Jira Ticket: MSDC-59
#============================


Feature: 
As a Sports Information Processor When I am on the Match summary page, I should see the title bar with teams/score/badges's of the chosen match

@Complete
Scenario: title bar
Given I am on the summary page for a particular match "3631166"
Then I should see the following details in the title bar:
|homeTeam|awayTeam|score|homeTeamImgSrc|homeTeamImgHt|homeTeamImgWidth|awayTeamImgSrc|awayTeamImgHt|awayTeamImgWidth|
|SWANSEA|SUNDERLAND|4 - 0|http://msn.pa-sport.com/api/football/images/msn/badges/65.png?h=60|60|60|http://msn.pa-sport.com/api/football/images/msn/badges/39.png?h=60|60|60|