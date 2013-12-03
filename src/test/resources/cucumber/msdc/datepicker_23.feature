
#=========================================================================================
#Project: Match story data capture
#Sprint: Sprint 01 UI
#Author: Archana Aravelly
#Date: 15/10/2013
#=========================================================================================
#Reviewer: 
#Date:
#=========================================================================================

#JIRA Ticket:MSDC-23
#=========================================================================================
Feature: As a Sports Information Processor, clicking on the date input or the calendar icon should launch a date picker.
Each match day should be highlighted on the calendar.


Scenario: 01 - To test if the last match date is displayed as default 
Given I am on the home page
Then the last match date should be displayed in the date field


Scenario: 02 - Verify Today's date is default and in grey colour 
Given I am on the home page
When I click on the calendar icon from the date field
Then today's date is highlighted in grey


Scenario: 03 - Selecting a new date from the date picker displays it correctly on the field
Given I am on the home page
And I click on the Calendar icon from the date field 
When I click on a new date
Then the selected date should be displayed in the date field


Scenario: 04 - To test match dates for a selected competition are highlighted in green colour
Given I am on the home page
When I select competition "Barclays Premier League" and match date "Sun, 27 Oct, 2013"
Then the following days should be highlighted in green colour:
| Day |
| 5   |
| 6   |
| 19  |
| 20  |
| 21  |
| 26  |
| 27  |
  
  
  
  
# standard component, automation not needed
#Scenario: 05 - Selecting a month from past using left arrow on date picker
#Given I am on the home page
#And I click on the Calendar icon from the date field
#And the calendar opens below the field 
#When I click on the left arrow 
#Then I should see previous month


# standard component, automation not needed
#Standard component
#Scenario: 06 - Selecting a month from future using right arrow on date picker
#Given I am on the home page
#And I click on the Calendar icon from the date field
#And the date picker opens below the field 
#When I click on the right arrow 
#Then I should see next month
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  