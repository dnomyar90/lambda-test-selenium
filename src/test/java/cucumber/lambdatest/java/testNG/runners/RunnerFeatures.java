package cucumber.lambdatest.java.testNG.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features = "src/test/resources/features/demo",
        glue = {"cucumber.lambdatest.java.testNG.stepDefinitions"},
        format = {"pretty",
                "html:target/cucumber-report/chrome",
                "json:target/cucumber-report/chrome/cucumber.json",
                "junit:target/cucumber-report/chrome/cucumber.xml"})
public class RunnerFeatures extends AbstractTestNGCucumberTests {
}