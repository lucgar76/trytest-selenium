package stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utils.DriverManager;

public class SelectGenderSteps {

    // Maps the label text ("Other", "Male", "Female") to its radio button id
    private String resolveGenderId(String label) {
        return label.toLowerCase(); // "Other" → "other", "Male" → "male", "Female" → "female"
    }

    @And("I click the {string} gender radio button")
    public void i_click_the_gender_radio_button(String label) {
        // Find the radio button by its id (e.g. id="other")
        WebElement radioButton = DriverManager.getDriver()
            .findElement(By.id(resolveGenderId(label)));
        radioButton.click();
        System.out.println("Clicked the '" + label + "' radio button.");
    }

    @Then("the {string} gender radio button should be selected")
    public void the_gender_radio_button_should_be_selected(String label) {
        WebElement radioButton = DriverManager.getDriver()
            .findElement(By.id(resolveGenderId(label)));
        // isSelected() returns true if the radio button is currently ticked
        Assert.assertTrue(
            radioButton.isSelected(),
            "Expected the '" + label + "' radio button to be selected, but it was not."
        );
        System.out.println("Verified: '" + label + "' radio button is selected.");
    }
}
