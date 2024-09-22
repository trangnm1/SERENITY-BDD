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


  Scenario: Feature products
    Given I open the browser
    When I scroll to the Featured products
    When Feature products is displaying correctly
    When I click on the a product
    Then I go to the product detail screen

  Scenario: Top Menu
    Given I open the browser
    When Menu categories is displaying correctly
    And I click on the a menu
#    Then Menu items displaying correctly





