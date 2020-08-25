Feature: User Registartion
I want to check that the user can registeration 

Scenario Outline:  user can register successfully
Given The user is in homepage
When User clicks registartion link
And User enters correct "<firstName>" , "<lastName>" , "<email>" , "<password>"
Then User can registered successfully

Examples: 
 | firstName | lastName | email | password |
 | Hala | Samir | tttest@test1.ccm | 123456789 |