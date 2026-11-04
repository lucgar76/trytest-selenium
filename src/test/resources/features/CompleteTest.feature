Feature: CompleteTest
  As a tester
  I want to perform all form interactions in a single end-to-end test
  So that I can verify the entire page works correctly before submitting

  Scenario: CompleteTest
    # 1. Open website
    Given I open the Chrome browser
    When I navigate to "https://play2.automationcamp.ir/"
    Then the page title should contain "Try Testing This"

    # 2. Fill name fields
    And I type "Lionel" in the first name field
    And I type "Messi" in the last name field
    Then the first name field should contain "Lionel"
    And the last name field should contain "Messi"

    # 3. Select gender radio button
    And I click the "Other" gender radio button
    Then the "Other" gender radio button should be selected

    # 4. Select from dropdown
    And I select "Option 3" from the dropdown
    Then the dropdown should show "Option 3" as selected

    # 5. Multi-select by drag
    And I click and drag from "Option 1" to "Option 3" in the multi-select list
    Then the multi-select list should have 3 options selected
    And the multi-select list should contain "Option 1" as selected
    And the multi-select list should contain "Option 2" as selected
    And the multi-select list should contain "Option 3" as selected

    # 6. Checkboxes
    And I click the checkbox with name "option1"
    And I click the checkbox with name "option3"
    Then the checkbox with name "option1" should be checked
    And the checkbox with name "option3" should be checked

    # 7. Color picker
    And I click on the color picker
    And I select the color "#23b85c" in the color picker
    Then the color field should show "#23b85c"

    # 8. Date picker
    And I click on the date picker
    And I click Today in the date picker
    Then the date field should show today's date

    # 9. Range slider
    And I click on the range slider
    And I set the range slider value to 85
    Then the range output should show 85

    # 10. Submit (must be last)
    And I click the Submit button
    Then I should be redirected to the Google homepage in a new tab
