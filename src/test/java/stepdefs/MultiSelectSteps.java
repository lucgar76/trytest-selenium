package stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import utils.DriverManager;

import java.util.List;

public class MultiSelectSteps {

    @And("I click and drag from {string} to {string} in the multi-select list")
    public void i_click_and_drag_in_multi_select(String fromOption, String toOption) {
        WebDriver driver = DriverManager.getDriver();

        // Find the <select multiple> element by id="owc"
        WebElement selectElement = driver.findElement(By.id("owc"));

        // Find the first and last option by their visible text
        WebElement firstOption  = selectElement.findElement(By.xpath(".//option[text()='" + fromOption + "']"));
        WebElement lastOption   = selectElement.findElement(By.xpath(".//option[text()='" + toOption + "']"));

        // Actions simulates real mouse movements:
        //   1. Press and hold the mouse button on Option 1
        //   2. Slowly move the mouse down to Option 3 (passes over Option 2 on the way)
        //   3. Release the mouse button
        new Actions(driver)
            .clickAndHold(firstOption)
            .moveToElement(lastOption)
            .release()
            .perform();

        System.out.println("Clicked and dragged from '" + fromOption + "' to '" + toOption + "'.");
    }

    @Then("the multi-select list should have {int} options selected")
    public void the_multi_select_should_have_options_selected(int expectedCount) {
        Select multiSelect = new Select(DriverManager.getDriver().findElement(By.id("owc")));
        List<WebElement> selectedOptions = multiSelect.getAllSelectedOptions();
        System.out.println("Number of selected options: " + selectedOptions.size());
        Assert.assertEquals(
            selectedOptions.size(), expectedCount,
            "Expected " + expectedCount + " options to be selected but found: " + selectedOptions.size()
        );
    }

    @And("the multi-select list should contain {string} as selected")
    public void the_multi_select_should_contain_as_selected(String expectedOptionText) {
        Select multiSelect = new Select(DriverManager.getDriver().findElement(By.id("owc")));
        List<WebElement> selectedOptions = multiSelect.getAllSelectedOptions();

        // Check that at least one of the selected options matches the expected text
        boolean found = selectedOptions.stream()
            .anyMatch(option -> option.getText().equals(expectedOptionText));

        System.out.println("Checking '" + expectedOptionText + "' is selected: " + found);
        Assert.assertTrue(
            found,
            "Expected '" + expectedOptionText + "' to be selected, but it was not found among selected options."
        );
    }
}
