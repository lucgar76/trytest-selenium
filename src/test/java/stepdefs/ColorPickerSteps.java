package stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utils.DriverManager;

public class ColorPickerSteps {

    @And("I click on the color picker")
    public void i_click_on_the_color_picker() {
        WebElement colorInput = DriverManager.getDriver().findElement(By.id("favcolor"));
        colorInput.click();
        System.out.println("Clicked on the color picker input.");
    }

    // Chrome's native color picker renders its palette inside the browser's shadow DOM,
    // which is not reachable via findElement(). We set the color value directly via
    // JavaScript and fire the change event — the same end result as picking a color.
    @And("I select the color {string} in the color picker")
    public void i_select_the_color_in_the_color_picker(String hexColor) {
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
        js.executeScript(
            "var input = document.getElementById('favcolor');" +
            "input.value = arguments[0];" +
            "input.dispatchEvent(new Event('input', { bubbles: true }));" +
            "input.dispatchEvent(new Event('change', { bubbles: true }));",
            hexColor
        );
        System.out.println("Selected color '" + hexColor + "' in the color picker.");
    }

    @Then("the color field should show {string}")
    public void the_color_field_should_show(String expectedHex) {
        WebElement colorInput = DriverManager.getDriver().findElement(By.id("favcolor"));
        String actualValue = colorInput.getAttribute("value");
        System.out.println("Color field value: " + actualValue + " | Expected: " + expectedHex);
        Assert.assertEquals(
            actualValue.toLowerCase(), expectedHex.toLowerCase(),
            "Expected color field to show '" + expectedHex + "' but got: '" + actualValue + "'"
        );
    }
}
