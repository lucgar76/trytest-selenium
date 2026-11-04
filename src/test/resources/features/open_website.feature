Feature: Open the automation testing website
  As a tester
  I want to open the automation practice website in a browser
  So that I can start running automated tests on it

  Scenario: Visit the homepage and verify the page title
    Given I open the Chrome browser
    When I navigate to "https://play2.automationcamp.ir/"
    Then the page title should contain "Try Testing This"
