package cucumber.lambdatest.java.testNG.stepDefinitions;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.lambdatest.java.testNG.DriverManager;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class BeforeAfterHooks {

    @Before
    public void deleteAllCookies() {
        DriverManager.getDriver().manage().deleteAllCookies();
    }

    @After
    public static void embedScreenshot(Scenario scenario) {
        if (scenario.isFailed()) {
            scenario.write("URL : " + DriverManager.getDriver().getCurrentUrl());
            byte[] screenshot = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png");
        }
    }
}