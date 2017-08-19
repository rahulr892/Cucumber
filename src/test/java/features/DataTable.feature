Feature: Google Title
  DataTable quite useful in form filling & Registration

  @DataTable
  Scenario: Check title of website
    Given I open a browser
    When I navigate to website
      | website | http://www.google.com |
    Then I validate the website title as mentioned below
      | title | Google |
    And I type text to search text field
      | text1 | searchtypo1 |
      | text2 | searchtypo2 |

