package stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.DriverManager;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class SubmitButtonSteps {

    @And("I click the Submit button")
    public void i_click_the_submit_button() {
        WebElement submitButton = DriverManager.getDriver()
            .findElement(By.cssSelector("button.btn.btn-success"));
        submitButton.click();
        System.out.println("Clicked the Submit button.");
    }

    // The Submit button uses window.open(..., '_blank'), so Google opens in a new tab.
    // Selenium stays on the original tab until we explicitly switch to the new window handle.
    @Then("I should be redirected to the Google homepage in a new tab")
    public void i_should_be_redirected_to_google_in_new_tab() {
        WebDriver driver = DriverManager.getDriver();

        // Wait until a second window/tab handle appears
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));

        // Switch to the newly opened tab
        List<String> handles = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(handles.get(1));
        System.out.println("Switched to new tab. Current URL: " + driver.getCurrentUrl());

        // Wait for the Google logo SVG (aria-label="Google") to be present in the DOM
        wait.until(ExpectedConditions.presenceOfElementLocated(
            By.cssSelector("svg[aria-label='Google']")
        ));

        WebElement googleLogo = driver.findElement(By.cssSelector("svg[aria-label='Google']"));
        Assert.assertTrue(
            googleLogo.isDisplayed(),
            "Expected Google logo to be visible on the page, but it was not found."
        );
        System.out.println("Verified: Google homepage opened in new tab.");
    }
}
