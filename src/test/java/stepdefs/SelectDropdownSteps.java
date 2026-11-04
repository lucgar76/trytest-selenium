package stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import utils.DriverManager;

public class SelectDropdownSteps {

    @And("I select {string} from the dropdown")
    public void i_select_from_the_dropdown(String optionText) {
        WebElement dropdownElement = DriverManager.getDriver()
            .findElement(By.id("option"));

        // Selenium's Select class handles dropdowns — it opens the list and picks the item for you
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByVisibleText(optionText); // matches the text the user sees, e.g. "Option 3"
        System.out.println("Selected '" + optionText + "' from the dropdown.");
    }

    @Then("the dropdown should show {string} as selected")
    public void the_dropdown_should_show_as_selected(String expectedOption) {
        WebElement dropdownElement = DriverManager.getDriver()
            .findElement(By.id("option"));

        Select dropdown = new Select(dropdownElement);
        // getFirstSelectedOption() returns whichever option is currently highlighted/selected
        String actualSelected = dropdown.getFirstSelectedOption().getText();
        System.out.println("Dropdown currently shows: " + actualSelected);
        Assert.assertEquals(
            actualSelected, expectedOption,
            "Expected dropdown to show '" + expectedOption + "' but it showed: '" + actualSelected + "'"
        );
    }
}
