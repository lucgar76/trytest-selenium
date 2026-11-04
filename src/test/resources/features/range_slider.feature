Feature: Adjust the range slider value
  As a tester
  I want to move the range slider from its default value of 50 to 85
  So that I can verify the displayed range value updates accordingly

  Scenario: Move range slider from 50 to 85
    Given I open the Chrome browser
    When I navigate to "https://play2.automationcamp.ir/"
    And I click on the range slider
    And I set the range slider value to 85
    Then the range output should show 85
