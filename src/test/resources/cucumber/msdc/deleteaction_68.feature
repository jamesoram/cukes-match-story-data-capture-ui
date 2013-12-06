#=========================================================================================
#Project: Match story data capture
#Sprint: Sprint 02 UI
#Author: Archana Aravelly
#Date: 28/10/2013
#=========================================================================================
#Reviewer: 
#Date:
#=========================================================================================

#JIRA Ticket:MSDC-68 :As a Sports Information Processor When I am on Match summary actions list view, I should be able to delete an action
#=========================================================================================
Feature: As a Sports Information Processor When I am on Match summary actions list view, I should be able to delete an action

Scenario: 01 - Clicking Delete button gives delete prompt
Given I am on match summary page
When I click on delete button for an action
Then I get a Delete prompt saying

Scenario: 02 - Clicking YES button on delete prompt deletes action
Given I am on match summary page
And I click on delete button for an action
And I get a Delete prompt saying
When I click on Yes button
Then the action list is refreshed and the action should be deleted

Scenario: 03 - Clicking NO button on delete prompt closes the delete prompt
Given I am on match summary page
And I click on delete button for an action
And I get a Delete prompt saying
When I click on No button
Then the delete prompt is closed
And the action is not deleted
