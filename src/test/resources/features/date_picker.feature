Feature: Select today's date using the date picker
  As a tester
  I want to open the date picker and click Today
  So that I can verify today's date is set in the date field

  Scenario: Click the date picker and select today's date
    Given I open the Chrome browser
    When I navigate to "https://play2.automationcamp.ir/"
    And I click on the date picker
    And I click Today in the date picker
    Then the date field should show today's date
