package cucumber.lambdatest.java.testNG.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Homepage {

    private By login_button = By.cssSelector("a[class='login']");
    private By logout_button = By.cssSelector("a[class='logout']");
    private By account_label = By.cssSelector("a[class='account']");
    private By error_label = By.cssSelector("div[class='alert alert-danger']");
    private By women_section = By.cssSelector("a[title='Women']");

    private WebDriver driver;
    private WebDriverWait wait;

    public Homepage(WebDriver driver) throws Exception {
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, 30);
    }

    public void go() throws Exception {
        this.driver.get("http://automationpractice.com/index.php");
        waitForLoad(this.driver);
    }

    public void assertTitle() throws Exception {
        Assert.assertEquals(this.driver.getTitle(), "My Store");
    }

    public void clickLoginButton() throws Exception {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(login_button)).click();
    }

    public void clickLogoutButton() throws Exception {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(logout_button)).click();
    }

    public void clickWomenSection() throws Exception {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(women_section)).click();
    }

    public void assertUserLoggedIn(){
        try{
            this.wait.until(ExpectedConditions.visibilityOfElementLocated(logout_button));
            this.wait.until(ExpectedConditions.visibilityOfElementLocated(account_label));
            WebElement accountLabelElement = this.driver.findElement(account_label);
            Assert.assertEquals(accountLabelElement.getText(), "LT Automation");
        } catch(Exception e){
            Assert.fail("ERROR! User is not logged in!");
        }
    }

    public void assertAuthenticationError(){
        try{
            this.wait.until(ExpectedConditions.visibilityOfElementLocated(login_button));
            this.wait.until(ExpectedConditions.visibilityOfElementLocated(error_label));
            Assert.assertTrue(this.driver.getPageSource().contains("Authentication failed"));
        } catch(Exception e){
            Assert.fail(e.getMessage());
        }
    }

    public void goToURL(String url) throws Exception {
        this.driver.get(url);
        waitForLoad(this.driver);
    }

    public void waitForLoad(WebDriver driver) {
        ExpectedCondition<Boolean> pageLoadCondition = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
                    }
                };
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(pageLoadCondition);
    }
}
