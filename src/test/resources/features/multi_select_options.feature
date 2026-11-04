Feature: Select multiple options by clicking and dragging
  As a tester
  I want to click on Option 1, drag down through Option 2 and Option 3, and release
  So that I can verify that all 3 options are selected at once

  Scenario: Select Option 1, Option 2 and Option 3 by drag selection
    Given I open the Chrome browser
    When I navigate to "https://play2.automationcamp.ir/"
    And I click and drag from "Option 1" to "Option 3" in the multi-select list
    Then the multi-select list should have 3 options selected
    And the multi-select list should contain "Option 1" as selected
    And the multi-select list should contain "Option 2" as selected
    And the multi-select list should contain "Option 3" as selected
