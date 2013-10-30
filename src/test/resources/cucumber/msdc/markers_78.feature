#=========================================================================================
#Project: Match story data capture
#Sprint: Sprint 02 UI
#Author: Archana Aravelly
#Date: 25/10/2013
#=========================================================================================
#Reviewer: 
#Date:
#=========================================================================================

JIRA Ticket:MSDC-78 :Add Match start / end markers to Match Actions page
#=========================================================================================
Feature: Add "Kick Off", "Half Time", "Second Half Started" and "Full Time pseudo actions so that scroll-er moves on at the start / end of each half

Scenario: 01 - Verify Kick Off 
Given I am on match summary page
When I scroll down to the bottom of the page
Then I should see "Kick Off"

Scenario: 02 - Verify Half Time 
Given I am on match summary page
When I scroll down to the middle of the page
Then I should see "Half Time"

Scenario: 03 - Verify Second half started
Given I am on match summary page
When I scroll down to the middle of the page
Then I should see "Second Half Time"

Scenario: 01 - Verify Full time
Given I am on match summary page
And I am at the bottom of the page
When I scroll up to the top of the page
Then I should see "Full Time"
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  