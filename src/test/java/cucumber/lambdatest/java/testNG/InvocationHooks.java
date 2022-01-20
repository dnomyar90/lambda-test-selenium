package cucumber.lambdatest.java.testNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

public class InvocationHooks implements IInvokedMethodListener {

    @Override
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
        if (method.isTestMethod()) {
            String browserName = method.getTestMethod().getXmlTest().getLocalParameters().get("browserName");
            String browserVersion = method.getTestMethod().getXmlTest().getLocalParameters().get("browserVersion");
            String operatingSystem = method.getTestMethod().getXmlTest().getLocalParameters().get("operatingSystem");
            RemoteWebDriver driver = DriverFactory.createInstance(browserName, browserVersion, operatingSystem);
            DriverManager.setDriver(driver);
        }
    }

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        if (method.isTestMethod()) {
            WebDriver driver = DriverManager.getDriver();
            if (driver != null) {
                driver.quit();
                }
            }
        }
    }