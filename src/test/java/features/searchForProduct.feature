Feature: Search for products
  A user can search for products in the website

  Scenario Outline: user can search for a product successfully
    Given The user accesses homepage
    When The user fills a search textfield with data <productPartialName>
    Then The product page is displayed successfully

    Examples: 
      | productPartialName |
      | "Apple Mac"        |
