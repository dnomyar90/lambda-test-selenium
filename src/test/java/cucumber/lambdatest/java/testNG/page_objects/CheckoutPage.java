package cucumber.lambdatest.java.testNG.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class CheckoutPage {

    private By total_products_price = By.id("total_product");
    private By proceed_to_checkout = By.cssSelector("a[class='button btn btn-default standard-checkout button-medium']");
    private By proceed_to_checkout_address = By.cssSelector("button[name='processAddress']");
    private By proceed_to_checkout_shipping = By.cssSelector("button[name='processCarrier']");
    private By checkbox_toc = By.id("cgv");
    private By toc_warning_popup = By.cssSelector("p[class='fancybox-error']");
    private By toc_warning_popup_close = By.cssSelector("a[title='Close']");
    private By payment_modules = By.cssSelector("p[class='payment_module']");
    private By overlay_popup = By.cssSelector("div[class='fancybox-overlay fancybox-overlay-fixed']");

    private WebDriver driver;
    private WebDriverWait wait;

    public CheckoutPage(WebDriver driver) throws Exception {
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, 30);
    }

    public void clickProceedCheckout() throws Exception {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(proceed_to_checkout)).click();
    }

    public void clickProceedCheckoutAddress() throws Exception {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(proceed_to_checkout_address)).click();
    }

    public void clickProceedCheckoutShipping() throws Exception {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(proceed_to_checkout_shipping)).click();
    }

    public void checkTOC() throws Exception {
        WebElement element = driver.findElement(checkbox_toc);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", element);
    }

    public void assertTOCPopup() throws Exception {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(toc_warning_popup));
        Assert.assertEquals(this.wait.until(ExpectedConditions.visibilityOfElementLocated(toc_warning_popup)).getText(), "You must agree to the terms of service before continuing.");
    }

    public void closeTOCPopup() throws Exception {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(toc_warning_popup_close)).click();
    }

    public void assertPaymentModule() throws Exception {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(payment_modules));
    }

    public void assertTotalProductPrice(String price) throws Exception {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(total_products_price));
        System.out.println(this.wait.until(ExpectedConditions.visibilityOfElementLocated(total_products_price)).getText());
        Assert.assertTrue(this.wait.until(ExpectedConditions.visibilityOfElementLocated(total_products_price)).getText().contains(price));
    }
}
