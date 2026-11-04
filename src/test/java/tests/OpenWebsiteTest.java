package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class OpenWebsiteTest {

    // Think of WebDriver as the "remote control" for the browser
    WebDriver driver;

    // @BeforeMethod runs BEFORE every test — sets up the browser
    @BeforeMethod
    public void setUp() {
        // Step 1: WebDriverManager automatically downloads the right ChromeDriver
        WebDriverManager.chromedriver().setup();

        // Step 2: Open a new Chrome window
        driver = new ChromeDriver();

        // Step 3: Make the browser window full screen so everything is visible
        driver.manage().window().maximize();
    }

    // @Test is the actual test — this is what the robot will do
    @Test
    public void openWebsite() {
        // Step 4: Tell the browser to go to the website (like typing in the address bar)
        String url = "https://play2.automationcamp.ir/";
        driver.get(url);

        // Step 5: Check the page title is what we expect
        // This is the "assertion" — if it's wrong, the test FAILS automatically
        String pageTitle = driver.getTitle();
        System.out.println("Page title is: " + pageTitle);

        Assert.assertTrue(
            pageTitle.contains("Try Testing This"),
            "Page title should contain 'Try Testing This' but was: " + pageTitle
        );

        System.out.println("TEST PASSED: Website opened successfully!");
    }

    // @AfterMethod runs AFTER every test — closes the browser (cleanup)
    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
