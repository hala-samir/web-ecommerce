Feature: User Registartion
  I want to check that the user can registeration

  Scenario Outline: user can register successfully using table
    Given The user is in homepage
    When User enters correct data <firstName>, <lastName>, <email>, <password>
    Then User can registered successfully

    Examples: 
      | firstName | lastName | email        | password   |
      | "hala"    | "samir"  | "aaa3@exq.cc" | "aaaaaaaa" |
      | "hala"    | "samir"  | "aaa2@ezq.cc" | "aaaaaaaa" |

  Scenario Outline: user can register successfully with data faker
    Given The user is in homepage
    When User enters correct data using Faker
    Then User can registered successfully

  Scenario Outline: user can register successfully with filling data
    Given The user is in homepage
    When User enters correct data hard coded
    Then User can registered successfully
