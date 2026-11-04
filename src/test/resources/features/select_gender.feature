Feature: Select a gender radio button on the form
  As a tester
  I want to click the 'Other' gender radio button
  So that I can verify radio button selection works correctly

  Scenario: Select 'Other' as the gender
    Given I open the Chrome browser
    When I navigate to "https://play2.automationcamp.ir/"
    And I click the "Other" gender radio button
    Then the "Other" gender radio button should be selected
