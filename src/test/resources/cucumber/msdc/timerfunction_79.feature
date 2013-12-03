#=========================================================================================
#Project: Match story data capture
#Sprint: Sprint 03 UI
#Author: Archana Aravelly
#Date: 18/11/2013
#=========================================================================================
#Reviewer: 
#Date:
#=========================================================================================

JIRA Ticket:MSDC-79

#=========================================================================================
Feature: As a Sports Information Processor - Timer Function

Scenario: 01 - Clicking PLAY button starts the timer from 0:00 and starts the timer ticking
Given I am on match summary page
When I click on play button
Then the timer starts from 0:00
And timer starts ticking
And actions drop in from the top when the timer reaches their time stamp
And the pause button is shown

Scenario: 02 - Clicking REWIND button 
Given I am on match summary page
When I click on rewind button
Then action list scrolls to the Kick-Off
And timer resets to 0:00 in yellow
And play button is shown

Scenario: 03 - Clicking FORWARD button
Given I am on match summary page
When I click on forward button
Then action list scrolls to the last action
And time stamp is correctly displayed in yellow
And play button is shown

Scenario: 04 - Clicking PAUSE button
Given I am on match summary page
And I click on play button
When I click on pause button
Then timer should stop ticking
And time stamp is correctly displayed in yellow
And play button is shown