package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * DriverManager is a shared "toolbox" that holds ONE WebDriver for all step classes.
 *
 * Think of it like a shared car key:
 *   - Hooks.java picks up the key before each scenario (opens Chrome)
 *   - Any step class can use the key to drive the browser
 *   - Hooks.java puts the key back after each scenario (closes Chrome)
 */
public class DriverManager {

    private static WebDriver driver;

    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void tearDown() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
