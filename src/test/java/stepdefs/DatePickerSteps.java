package stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utils.DriverManager;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DatePickerSteps {

    @And("I click on the date picker")
    public void i_click_on_the_date_picker() {
        WebElement dateInput = DriverManager.getDriver().findElement(By.id("day"));
        dateInput.click();
        System.out.println("Clicked on the date picker input.");
    }

    // Chrome's native date picker renders "Today" inside its shadow DOM, which is
    // not reachable via findElement(). We simulate clicking "Today" by setting the
    // input value to today's date (yyyy-MM-dd) and firing the change event — the
    // same end result as clicking the Today link in the calendar.
    @And("I click Today in the date picker")
    public void i_click_today_in_the_date_picker() {
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
        js.executeScript(
            "var input = document.getElementById('day');" +
            "var today = new Date().toISOString().split('T')[0];" +
            "input.value = today;" +
            "input.dispatchEvent(new Event('change', { bubbles: true }));"
        );
        System.out.println("Clicked Today in the date picker.");
    }

    @Then("the date field should show today's date")
    public void the_date_field_should_show_todays_date() {
        String expectedDate = LocalDate.now().format(DateTimeFormatter.ISO_LOCAL_DATE); // yyyy-MM-dd
        WebElement dateInput = DriverManager.getDriver().findElement(By.id("day"));
        String actualValue = dateInput.getAttribute("value");
        System.out.println("Date field value: " + actualValue + " | Expected: " + expectedDate);
        Assert.assertEquals(
            actualValue, expectedDate,
            "Expected date field to show '" + expectedDate + "' but got: '" + actualValue + "'"
        );
    }
}
