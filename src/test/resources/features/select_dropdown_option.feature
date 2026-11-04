Feature: Select an option from the dropdown
  As a tester
  I want to open the dropdown and select 'Option 3'
  So that I can verify dropdown selection works correctly

  Scenario: Select 'Option 3' from the dropdown
    Given I open the Chrome browser
    When I navigate to "https://play2.automationcamp.ir/"
    And I select "Option 3" from the dropdown
    Then the dropdown should show "Option 3" as selected
