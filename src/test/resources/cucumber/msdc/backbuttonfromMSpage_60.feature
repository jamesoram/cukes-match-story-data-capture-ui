#=========================================================================================
#Project: Match story data capture
#Sprint: Sprint 02 UI
#Author: Archana Aravelly
#Date: 30/10/2013
#=========================================================================================
#Reviewer: 
#Date:
#=========================================================================================

JIRA Ticket:MSDC-60 
#=========================================================================================
Feature: As a Sports Information Processor When I am on Match summary page, I should be able to go back to Home page

Background:
	Given I am on home page
	And I have the following selection:
		|Competition              |Date                |
		| UEF Champions league    |Wed, 23 Oct, 2013   |
    And I click right arrow button for the first match
    And I am on match summary page

Scenario: 01 - Access back to Home page from Match summary page
	When I click on back button
	Then should be on home page
	And I have the following selection:
		|Competition              |Date                |
		| UEF Champions league    |Wed, 23 Oct, 2013   |

