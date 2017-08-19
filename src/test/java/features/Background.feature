Feature: Background & Hooks Keyword

  Background:
    Given I open a browser
    When I navigate to facebook

  @Background
  Scenario: Validate Background functionality
    Then I validate the facebook page

  @DataDriven
  Scenario: Passing parameter to tests
    Then I type "RAHUL RANA" to search text field

  @DataDriven
  Scenario Outline: Data driven using scenario outline
    Then I type "<SearchText>" to search text field

    Examples:
      | SearchText |
      | Youtube    |
      | Twitter    |

