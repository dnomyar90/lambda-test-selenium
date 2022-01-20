package cucumber.lambdatest.java.testNG.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LoginPage {

    private By email_textfield = By.name("email");
    private By password_textfield = By.name("passwd");
    private By loginButton = By.name("SubmitLogin");

    private WebDriver driver;
    private WebDriverWait wait;

    public LoginPage(WebDriver driver) throws Exception {
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, 30);
    }

    public LoginPage enterEmail(String email){
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(email_textfield)).clear();
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(email_textfield)).sendKeys(email);
        return this;
    }

    public LoginPage enterPassword(String password) throws Exception {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(password_textfield)).clear();
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(password_textfield)).sendKeys(password);
        return this;
    }

    public LoginPage clickLogin() throws Exception {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(loginButton)).click();
        return this;
    }
}
