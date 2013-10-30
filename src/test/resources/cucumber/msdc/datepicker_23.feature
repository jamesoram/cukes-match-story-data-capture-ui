
#=========================================================================================
#Project: Match story data capture
#Sprint: Sprint 01 UI
#Author: Archana Aravelly
#Date: 15/10/2013
#=========================================================================================
#Reviewer: 
#Date:
#=========================================================================================

JIRA Ticket:MSDC-23
#=========================================================================================
Feature: As a Sports Information Processor, clicking on the date input or the calendar icon should launch a date picker.
Each match day should be highlighted on the calendar.

Scenario: 01 - To test if current date is displayed as default 
Given I am on the home page
And I see "Date:" as a label
When I see a field with a calendar icon to pick a date 
Then the current date to be displayed in the date field

Scenario: 02 - To test date picker display, verify weekdays and default date 
Given I am on the home page
When I click on the calendar icon from the date field
Then the date picker opens below the field
And I should see weekdays displayed
And current date is highlighted in grey on the calendar

Scenario: 03 - Selecting a month from past using left arrow on date picker
Given I am on the home page
And I click on the Calendar icon from the date field
And the date picker opens below the field 
When I click on the left arrow the calendar view should display previous month
And I click on the left arrow again
Then correct month should be displayed

Scenario: 04 - Selecting a month from future using right arrow on date picker
Given I am on the home page
And I click on the Calendar icon from the date field
And the date picker opens below the field 
When I click on the right arrow the calendar view should display future month
And I click on the right arrow again
Then correct month should be displayed

Scenario: 05 - Selecting a new date from the date picker display it correctly on the field
Given I am on the home page
And I click on the Calendar icon from the date field
And the date picker opens below the field 
When I click on a new date
Then the selected date to display in the date field

Scenario: 06 - To test current day to be highlighted in grey colour
Given I am on the home page
And I click on the Calendar icon from the date field
And the date picker opens below the field 
Then the current day to be highlighted in grey colour

Scenario: 07 - To test match dates for a selected competition are highlighted in green colour
Given I am on the home page
When I select Barclay's Premier League from the drop down list
And I select a date from the date picker
Then all the match dates to be highlighted in green colour
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  