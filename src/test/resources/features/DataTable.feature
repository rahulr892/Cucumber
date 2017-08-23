Feature: Google Title
  DataTable quite useful in form filling & Registration

  Background:
    Given I open a browser


  @DataMap
  Scenario: Check title of website DataMap
    When I navigate to website
      | website | http://www.google.com |
    Then I validate the website title as mentioned below
      | title | Google |
    And I type text to search text field
      | text1 | searchtypo1 |
      | text2 | searchtypo2 |


  @RawDataTable
  Scenario: Register on newtours RawDataTable
    When I navigate to website
      | website | http://newtours.demoaut.com/ |
    Then I click on register link
    Then I enter valid data using datatable and raw
      | username        | rahul   |
      | password        | test123 |
      | confirmPassword | test123 |
    Then I click on submit
    Then I click signOff


  @MapDataTable
  Scenario: Register on newtours MapDataTable
    When I navigate to website
      | website | http://newtours.demoaut.com/ |
    Then I click on register link
    Then I enter valid data using datatable and map
      | username | password | confirmPassword |
      | rahul    | test123  | test123         |
    Then I click on submit
    Then I click signOff


  @POJODataTable
  Scenario: Register on newtours POJO
    When I navigate to website
      | website | http://newtours.demoaut.com/ |
    Then I click on register link
    Then I enter valid data using datatable and pojo
      | username | password | confirmPassword |
      | rahul    | test123  | test123         |
    Then I click on submit
    Then I click signOff

