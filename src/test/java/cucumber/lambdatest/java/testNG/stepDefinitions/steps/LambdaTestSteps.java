package cucumber.lambdatest.java.testNG.stepDefinitions.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.lambdatest.java.testNG.DriverManager;
import cucumber.lambdatest.java.testNG.page_objects.CatalogPage;
import cucumber.lambdatest.java.testNG.page_objects.CheckoutPage;
import cucumber.lambdatest.java.testNG.page_objects.Homepage;
import cucumber.lambdatest.java.testNG.page_objects.LoginPage;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.openqa.selenium.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class LambdaTestSteps {

    WebDriver driver = DriverManager.getDriver();
    private Homepage homepage;
    private LoginPage loginPage;
    private CatalogPage catalogPage;
    private CheckoutPage checkoutPage;

    String price;

    @Given("^I go to Homepage")
    public void givenIGoToHomepage() throws Exception {
        homepage = new Homepage(this.driver);
        homepage.go();
    }

    @Then("^I should see correct title page for Homepage")
    public void assertPageTitleHomepage() throws Exception {
        homepage = new Homepage(this.driver);
        homepage.assertTitle();
    }

    @And("^I login with valid credential")
    public void loginValidCred() throws Exception{
        homepage = new Homepage(this.driver);
        homepage.clickLoginButton();
        loginPage = new LoginPage(this.driver);
        
        File file = new File("users.xml");  
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();  
        Document doc = db.parse(file);   
        doc.getDocumentElement().normalize();
        NodeList nodeList = doc.getElementsByTagName("user");
        Node node = nodeList.item(0);
        Element eElement = (Element) node; 
        String validEmail = eElement.getElementsByTagName("email").item(0).getTextContent();
        String validPassword = eElement.getElementsByTagName("password").item(0).getTextContent();     
        loginPage.enterEmail(validEmail).enterPassword(validPassword).clickLogin();
        homepage.assertUserLoggedIn();
    }

    @And("^I login with invalid credential")
    public void loginInvalidCred() throws Exception{
        homepage = new Homepage(this.driver);
        homepage.clickLoginButton();
        loginPage = new LoginPage(this.driver);

        File file = new File("users.xml");  
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();  
        Document doc = db.parse(file);   
        doc.getDocumentElement().normalize();
        NodeList nodeList = doc.getElementsByTagName("user");
        Node node = nodeList.item(1);
        Element eElement = (Element) node; 
        String invalidEmail = eElement.getElementsByTagName("email").item(0).getTextContent();
        String invalidPassword = eElement.getElementsByTagName("password").item(0).getTextContent();     
        loginPage.enterEmail(invalidEmail).enterPassword(invalidPassword).clickLogin();
        homepage.assertAuthenticationError();
    }

    @And("^I add products to cart")
    public void addProductsToCart() throws Exception{
        homepage = new Homepage(this.driver);
        checkoutPage = new CheckoutPage(this.driver);
        homepage.clickWomenSection();
        catalogPage = new CatalogPage(this.driver);
        price = catalogPage.addProductsToCart();
        checkoutPage.assertTotalProductPrice(price);
    }

    @And("^I proceed to checkout without checking TOC")
    public void checkoutWithoutTOC() throws Exception {
        checkoutPage = new CheckoutPage(this.driver);
        checkoutPage.clickProceedCheckout();
        checkoutPage.clickProceedCheckoutAddress();
        checkoutPage.clickProceedCheckoutShipping();
    }
    @Then("^I should see TOC warning")
    public void checkTOCWarning() throws Exception {
        checkoutPage = new CheckoutPage(this.driver);
        checkoutPage.assertTOCPopup();
        checkoutPage.closeTOCPopup();
    }

    @Then("^I proceed to checkout after checking TOC")
    public void checkoutWithTOC() throws Exception {
        checkoutPage = new CheckoutPage(this.driver);
        checkoutPage.checkTOC();
        checkoutPage.clickProceedCheckoutShipping();
    }

    @Then("^I should be at payment section")
    public void checkPaymentModules() throws Exception {
        checkoutPage = new CheckoutPage(this.driver);
        checkoutPage.assertPaymentModule();
    }

    @And("^I logout from website")
    public void logoutFromSite() throws Exception {
        homepage = new Homepage(this.driver);
        homepage.clickLogoutButton();
    }
}