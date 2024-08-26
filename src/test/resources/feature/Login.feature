Feature: Login to CRM
#  format code: ctrl alt L
#  comment code: ctrl /

  Scenario: Successful login
    Given I open the browser
    When I am on the Register screen
    When I select gender
    When I input register information
      | firstname | lastname | email            | password | confirmpassword |
      | trang     | minh     | trang4@gmail.com |trang123 | trang123        |
    When I click register button
    Then I am on the Dashboard screen


