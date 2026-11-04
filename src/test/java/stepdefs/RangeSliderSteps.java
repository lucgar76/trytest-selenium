package stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utils.DriverManager;

public class RangeSliderSteps {

    @And("I click on the range slider")
    public void i_click_on_the_range_slider() {
        WebElement slider = DriverManager.getDriver().findElement(By.id("a"));
        slider.click();
        System.out.println("Clicked on the range slider.");
    }

    // Dragging a range slider to a precise pixel position is fragile across screen sizes.
    // Setting the value via JavaScript and firing input + change events is the reliable
    // equivalent of the user moving the thumb to a specific position.
    @And("I set the range slider value to {int}")
    public void i_set_the_range_slider_value_to(int value) {
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
        js.executeScript(
            "var slider = document.getElementById('a');" +
            "slider.value = arguments[0];" +
            "slider.dispatchEvent(new Event('input',  { bubbles: true }));" +
            "slider.dispatchEvent(new Event('change', { bubbles: true }));",
            value
        );
        System.out.println("Set range slider value to: " + value);
    }

    // The <output name="x" for="a"> element reflects the slider's current value on screen
    @Then("the range output should show {int}")
    public void the_range_output_should_show(int expectedValue) {
        WebElement output = DriverManager.getDriver().findElement(By.cssSelector("output[name='x']"));
        String actualText = output.getText().trim();
        System.out.println("Range output text: " + actualText + " | Expected: " + expectedValue);
        Assert.assertEquals(
            actualText, String.valueOf(expectedValue),
            "Expected range output to show '" + expectedValue + "' but got: '" + actualText + "'"
        );
    }
}
