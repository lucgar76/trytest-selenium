Feature: Submit button redirects to Google homepage
  As a tester
  I want to click the Submit button
  So that I can verify it opens Google in a new tab

  Scenario: Click Submit and verify Google opens in a new tab
    Given I open the Chrome browser
    When I navigate to "https://play2.automationcamp.ir/"
    And I click the Submit button
    Then I should be redirected to the Google homepage in a new tab
