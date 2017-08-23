Feature: Background & Hooks Keyword

  Background:
    Given I open a browser
    When I navigate to facebook

  Scenario: Validate Background functionality
    Then I validate the facebook page


  @Parameters
  Scenario: Passing parameter to tests
    Then I type "RAHUL RANA" to search text field


  @ScenarioOutline
  Scenario Outline: Data driven using scenario outline
    Then I type "<SearchText>" to search text field

    Examples: Test Data
      | SearchText |
      | Youtube    |
      | Twitter    |


    # ScenarioOutline used when tests need to be run on multiple sets of data
    # DataTable used for tests with long list of inputs but not like ScenarioOutline

