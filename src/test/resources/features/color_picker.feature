Feature: Select a favourite color using the color picker
  As a tester
  I want to open the color picker and select green
  So that I can verify the selected color is reflected in the color field

  Scenario: Click the color picker and select green
    Given I open the Chrome browser
    When I navigate to "https://play2.automationcamp.ir/"
    And I click on the color picker
    And I select the color "#23b85c" in the color picker
    Then the color field should show "#23b85c"
