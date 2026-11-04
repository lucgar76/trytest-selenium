Feature: Select checkboxes individually
  As a tester
  I want to click on Option 1 and Option 3 checkboxes independently
  So that I can verify that both checkboxes are checked

  Scenario: Select Option 1 and Option 3 checkboxes
    Given I open the Chrome browser
    When I navigate to "https://play2.automationcamp.ir/"
    And I click the checkbox with name "option1"
    And I click the checkbox with name "option3"
    Then the checkbox with name "option1" should be checked
    And the checkbox with name "option3" should be checked
