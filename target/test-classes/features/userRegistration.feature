Feature: User Registartion
  I want to check that the user can registeration

  Scenario Outline: user can register successfully using javafaker
    Given The user is in homepage
    When User enters correct data <firstName>, <lastName>, <email>, <password>
    Then User can registered successfully

    Examples: 
      | firstName | lastName | email         | password   |
      | "hala"    | "samir"  | "aaa@e10q.cc" | "aaaaaaaa" |

  Scenario Outline: user can register successfully with filling data
    Given The user is in homepage
    When User enters correct data using Faker
    Then User can registered successfully

  Scenario Outline: user can register successfully with filling data
    Given The user is in homepage
    When User enters correct data hard coded
    Then User can registered successfully
