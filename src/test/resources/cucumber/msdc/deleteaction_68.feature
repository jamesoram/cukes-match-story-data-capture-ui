#=========================================================================================
#Project: Match story data capture
#Sprint: Sprint 02 UI
#Author: Archana Aravelly
#Date: 28/10/2013
#=========================================================================================
#Reviewer: 
#Date:
#=========================================================================================

JIRA Ticket:MSDC-68 :As a Sports Information Processor When I am on Match summary actions list view, I should be able to delete an action
#=========================================================================================
Feature: As a Sports Information Processor When I am on Match summary actions list view, I should be able to delete an action

Scenario: 01 - delete action 
Given I am on match details page
When I click on delete button
Then the action should be deleted

# Will there be any user confirmation pop up?