package tests.junit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 * Navigate to <a href="https://www.saucedemo.com/v1/index.html">SauceDemo</a>
 * login as standard_user
 * assert that there are 6 items on the products list page
 * add the first and last items to the cart
 * navigate to the cart and check that both items are listed
 */
public class SauceDemoItemsListTests {
    WebDriver driver;

    @Test
    public void checkThatProductListHas6Items(){
        login("standard_user", "secret_sauce");
        By productItemComponent = By.className("inventory_item");
        int actualNumberOfProducts = driver.findElements(productItemComponent).size();
        Assertions.assertEquals(6, actualNumberOfProducts);
    }

    @Test
    public void checkThatTheFirstItemIsDisplayedCorrectly(){
        login("standard_user", "secret_sauce");
        addItemToCart(1);
        addItemToCart(6);
        driver.navigate().to("https://www.saucedemo.com/v1/cart.html");
        Assertions.assertEquals("Sauce Labs Backpack", getCartItemName(1));
    }

    @Test
    public void checkThatTheLastItemIsDisplayedCorrectly(){
        login("standard_user", "secret_sauce");
        addItemToCart(1);
        addItemToCart(6);
        driver.navigate().to("https://www.saucedemo.com/v1/cart.html");
        Assertions.assertEquals("Test.allTheThings() T-Shirt (Red)", getCartItemName(2));
    }

    @BeforeEach
    public void beforeEach(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized");
//        chromeOptions.addArguments("--headless=new");
        driver = new ChromeDriver(chromeOptions);
//        driver.manage().window().maximize();
        driver.navigate().to("https://www.saucedemo.com/v1/index.html");
    }

    @AfterEach
    public void afterEach(){
        driver.quit();
    }

    private void login(String username, String password){
        By usernameTextArea = By.id("user-name");
        By passwordTextArea = By.id("password");
        By loginButton = By.id("login-button");

        driver.findElement(usernameTextArea).sendKeys(username);
        driver.findElement(passwordTextArea).sendKeys(password);
        driver.findElement(loginButton).click();
    }

    private void addItemToCart(int itemNumber){
        By AddItemToCartButton = By.xpath("(//button[contains(@class,'btn_inventory')])["+itemNumber+"]");
        driver.findElement(AddItemToCartButton).click();
    }

    private String getCartItemName(int cartItemNumber){
        By cartItemName = By.xpath("(//div[@class='inventory_item_name'])["+cartItemNumber+"]");
        return driver.findElement(cartItemName).getText();
    }
}
