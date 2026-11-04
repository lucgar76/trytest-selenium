package stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utils.DriverManager;

public class CheckboxSteps {

    @And("I click the checkbox with name {string}")
    public void i_click_the_checkbox_with_name(String name) {
        WebElement checkbox = DriverManager.getDriver()
            .findElement(By.name(name));
        checkbox.click();
        System.out.println("Clicked checkbox with name='" + name + "'.");
    }

    @Then("the checkbox with name {string} should be checked")
    public void the_checkbox_with_name_should_be_checked(String name) {
        WebElement checkbox = DriverManager.getDriver()
            .findElement(By.name(name));
        Assert.assertTrue(
            checkbox.isSelected(),
            "Expected checkbox with name='" + name + "' to be checked, but it was not."
        );
        System.out.println("Verified: checkbox with name='" + name + "' is checked.");
    }
}
