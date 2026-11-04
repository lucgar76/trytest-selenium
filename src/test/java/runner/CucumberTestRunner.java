package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

// This class is the "launcher" — it finds all .feature files and runs them
@CucumberOptions(
    // Where to find the .feature files
    features = "src/test/resources/features",

    // Where to find the step definitions (the Java code behind each step)
    glue = "stepdefs",

    // How to display results: "pretty" = human-readable, "html" = saves an HTML report
    plugin = {
        "pretty",
        "html:target/cucumber-reports/cucumber-report.html"
    },

    // Shows each step in the console output even if it passed
    monochrome = true
)
public class CucumberTestRunner extends AbstractTestNGCucumberTests {
    // No code needed here — the @CucumberOptions annotation does all the work
}
