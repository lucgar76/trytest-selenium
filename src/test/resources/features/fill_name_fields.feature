Feature: Fill in the name fields on the form
  As a tester
  I want to type a first name and last name into the form
  So that I can verify the text input fields work correctly

  Scenario: Enter first name and last name in the form
    Given I open the Chrome browser
    When I navigate to "https://play2.automationcamp.ir/"
    And I type "Lionel" in the first name field
    And I type "Messi" in the last name field
    Then the first name field should contain "Lionel"
    And the last name field should contain "Messi"
