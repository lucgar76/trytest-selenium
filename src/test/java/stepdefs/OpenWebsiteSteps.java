package stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import utils.DriverManager;

public class OpenWebsiteSteps {

    // Browser is opened/closed by Hooks.java — no @Before/@After needed here

    @Given("I open the Chrome browser")
    public void i_open_the_chrome_browser() {
        System.out.println("Chrome browser is open.");
    }

    @When("I navigate to {string}")
    public void i_navigate_to(String url) {
        DriverManager.getDriver().get(url);
        System.out.println("Navigated to: " + url);
    }

    @Then("the page title should contain {string}")
    public void the_page_title_should_contain(String expectedTitle) {
        String actualTitle = DriverManager.getDriver().getTitle();
        System.out.println("Page title is: " + actualTitle);
        Assert.assertTrue(
            actualTitle.contains(expectedTitle),
            "Expected title to contain '" + expectedTitle + "' but got: " + actualTitle
        );
    }
}
