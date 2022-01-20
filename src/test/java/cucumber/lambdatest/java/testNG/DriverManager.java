package cucumber.lambdatest.java.testNG;

import org.openqa.selenium.*;
import java.util.concurrent.TimeUnit;

public class DriverManager {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        if (driver.get() == null) {
            setDriver(DriverFactory.createInstance(null, null, null));
        }
        return driver.get();
    }

    public static void setDriver(WebDriver driver) {
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);
        DriverManager.driver.set(driver);
    }
}