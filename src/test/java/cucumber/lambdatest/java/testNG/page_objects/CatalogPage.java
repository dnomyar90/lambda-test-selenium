package cucumber.lambdatest.java.testNG.page_objects;

import java.text.DecimalFormat;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class CatalogPage {

    private By first_product = By.xpath("(//div[@class='product-container']//a[@class='product_img_link'])[1]");
    private By first_add_to_cart = By.xpath("(//a[@class='button ajax_add_to_cart_button btn btn-default'])[1]");
    private By first_product_price = By.xpath("(//span[@itemprop='price'])[1]");
    private By second_product_price = By.xpath("(//span[@itemprop='price'])[3]");
    private By second_product = By.xpath("(//div[@class='product-container']//a[@class='product_img_link'])[2]");
    private By second_add_to_cart = By.xpath("(//a[@class='button ajax_add_to_cart_button btn btn-default'])[2]");
    private By continue_shopping_button = By.cssSelector("span[class='continue btn btn-default button exclusive-medium']");
    private By continue_checkout_button = By.cssSelector("a[class='btn btn-default button button-medium']");

    private WebDriver driver;
    private WebDriverWait wait;

    public CatalogPage(WebDriver driver) throws Exception {
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, 30);
    }

    public String addProductsToCart() throws Exception {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(first_product));
        WebElement ele = driver.findElement(first_product);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ele);
        Actions action = new Actions(driver);
        action.moveToElement(ele).perform();
        String firstProductPrice = this.wait.until(ExpectedConditions.visibilityOfElementLocated(first_product_price)).getText().replace("$", "");
        float y1 = Float.parseFloat(firstProductPrice);
        DecimalFormat df = new DecimalFormat("#.00");  
        y1 = Float.valueOf(df.format(y1));
        System.out.println(y1);
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(first_add_to_cart)).click();
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(continue_shopping_button)).click();
        WebElement ele2 = driver.findElement(second_product);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ele2);
        action.moveToElement(ele2).perform();
        String secondProductPrice = this.wait.until(ExpectedConditions.visibilityOfElementLocated(second_product_price)).getText().replace("$", "");
        float y2 = Float.parseFloat(secondProductPrice);
        y2 = Float.valueOf(df.format(y2));
        System.out.println(y2);
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(second_add_to_cart)).click();
        // this.wait.until(ExpectedConditions.visibilityOfElementLocated(continue_shopping_button)).click();
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(continue_checkout_button)).click();
        float y3 = y1+y2;
        y3 = Float.valueOf(df.format(y3));
        return String.valueOf(y3);
    }
}
