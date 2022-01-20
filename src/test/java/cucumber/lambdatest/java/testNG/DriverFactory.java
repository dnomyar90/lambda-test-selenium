package cucumber.lambdatest.java.testNG;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DriverFactory {
    public static RemoteWebDriver createInstance(String browserName, String browserVersion, String operatingSystem) {
        String username = "raymondlucky21";
        String accesskey = "wKp8nhQNiek7QgZZgCaGjt2vNhxKmKLi7m55W8cFi6LtU9OMMH";
        String gridURL = "@hub.lambdatest.com/wd/hub";
        RemoteWebDriver driver = null;
        DesiredCapabilities capabilities = new DesiredCapabilities();

        if (browserName == null)
            browserName = "firefox";

        if (browserVersion == null)
            browserName = "88.0";

        if (operatingSystem == null)
            operatingSystem = "mac";

        if(browserName == "Internet Explorer")
        capabilities.setCapability("ie.compatibility",11001);

        capabilities.setCapability("platform", operatingSystem);
        capabilities.setCapability("browserName", browserName);
        capabilities.setCapability("version", browserVersion);
        capabilities.setCapability("tunnel", true);
        capabilities.setCapability("console", "true");
        capabilities.setCapability("network", true);
        capabilities.setCapability("visual", true);
        capabilities.setCapability("build", "LambdaTestSampleApp");
        capabilities.setCapability("name", "LambdaTestJavaSample");
        try {
            driver = new RemoteWebDriver(new URL("https://" + username + ":" + accesskey + gridURL), capabilities);
        } catch (MalformedURLException e) {
            System.out.println("Invalid grid URL");
        } catch (Exception e) {
            System.out.println("ERROR!");
            System.out.println(e.getMessage());
        }
        // driver = new FirefoxDriver();

        driver.manage().window().maximize();
        return driver;
    }
}