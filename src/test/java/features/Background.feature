Feature: Background & Hooks Keyword

  Background:
    Given I open a browser
    When I navigate to facebook

  @Background
  Scenario: Validate Background functionality
    Then I validate the facebook page

  @DataDriven
  Scenario: Data driven scenario
    Then I type "RAHUL RANA" to search text field

