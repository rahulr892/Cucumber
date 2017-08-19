Feature: Google & FB Search

  @Smoke
  Scenario: Validate google search results
    Given I open a browser
    When I navigate to google
    Then I validate the search text field

  @Sanity @Simple
  Scenario: Validate facebook page
    Given I open a browser
    When I navigate to facebook
    Then I validate the facebook page
