#=========================================================================================
#Project: Match story data capture
#Sprint: Sprint 02 UI
#Author: Archana Aravelly
#Date: 30/10/2013
#=========================================================================================
#Reviewer: 
#Date:
#=========================================================================================

#JIRA Ticket:MSDC-70
#=========================================================================================
Feature: As a Sports Information Processor, When I am on Match summary page I should be able to link actions.

Background:
	Given I am on home page
	And I have the following selection:
		|Competition              |Date                |
		| UEF Champions league    |Wed, 23 Oct, 2013   |
    And I click right arrow button for the first match
    And I am on match summary page

Scenario: 01 - Clicking on link actions button displayed menu
	When I click on link actions button
	Then should see the following menu:
		| Link actions menu       |
		| Long Ball               |
		| Slow Passing            |
		| counter Attack          |
		| Set Piece               |
		| Defensive Possession    |
    And the match summary page should be inactive
    
    
    
Scenario: 02 - Click on the description highlights the action
	When I click on an actions description
	Then the action row should highlight


Scenario: 03 - Click on the description highlights the action
	When I click on an action A description
	And I click on an action B description
	Then the action row for B should highlight
	And the action row for A should not highlight
	
Scenario: 04 - Select 2 action rows using keyboard and mouse access (ctrl + left mouse)
	When I click on an action A description 
	And I ctrl + click on an action B description
	Then the action row for A should highlight
	And the action row for B should highlight
	
	
Scenario: 05 - Select a series of action rows using keyboard and mouse access (Shift + left mouse)
	When I click on an action A description 
	And I shift + click on an action F description
	Then the action rows from A to F should highlight

Scenario: 06 - Can not multi select items that have already been linked
    When I link action A
    And I click on a action Adescription
    Then the action row should not be highlighted 

Scenario: 07 - When the unlink button is used on a linked action all the links are removed




