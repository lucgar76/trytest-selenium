package stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import utils.DriverManager;

/**
 * Hooks runs automatically before and after EVERY scenario,
 * and after EVERY individual step.
 */
public class Hooks {

    @Before
    public void setUp() {
        DriverManager.setUp();
    }

    // Runs after every single step in every scenario
    // This gives a 2-second pause so you can watch what's happening on screen
    @AfterStep
    public void waitAfterEachStep() throws InterruptedException {
        Thread.sleep(500);
    }

    @After
    public void tearDown() {
        DriverManager.tearDown();
    }
}
