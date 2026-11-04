package stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utils.DriverManager;

public class FillNameFieldsSteps {

    // --- ENTER VALUES ---

    @And("I type {string} in the first name field")
    public void i_type_in_the_first_name_field(String firstName) {
        WebDriver driver = DriverManager.getDriver();
        // Find the field by its id="fname" (seen in the page source)
        WebElement firstNameField = driver.findElement(By.id("fname"));
        firstNameField.clear();
        firstNameField.sendKeys(firstName);
        System.out.println("Typed '" + firstName + "' in First name field.");
    }

    @And("I type {string} in the last name field")
    public void i_type_in_the_last_name_field(String lastName) {
        WebDriver driver = DriverManager.getDriver();
        // Find the field by its id="lname" (seen in the page source)
        WebElement lastNameField = driver.findElement(By.id("lname"));
        lastNameField.clear();
        lastNameField.sendKeys(lastName);
        System.out.println("Typed '" + lastName + "' in Last name field.");
    }

    // --- VERIFY VALUES ---

    @Then("the first name field should contain {string}")
    public void the_first_name_field_should_contain(String expectedValue) {
        String actualValue = DriverManager.getDriver()
            .findElement(By.id("fname"))
            .getAttribute("value");
        System.out.println("First name field contains: " + actualValue);
        Assert.assertEquals(actualValue, expectedValue,
            "First name field should be '" + expectedValue + "' but was: '" + actualValue + "'");
    }

    @And("the last name field should contain {string}")
    public void the_last_name_field_should_contain(String expectedValue) {
        String actualValue = DriverManager.getDriver()
            .findElement(By.id("lname"))
            .getAttribute("value");
        System.out.println("Last name field contains: " + actualValue);
        Assert.assertEquals(actualValue, expectedValue,
            "Last name field should be '" + expectedValue + "' but was: '" + actualValue + "'");
    }
}
