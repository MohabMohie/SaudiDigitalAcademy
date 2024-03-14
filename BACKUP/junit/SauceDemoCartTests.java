package tests.junit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SauceDemoCartTests {
    WebDriver driver;

    /**
     * breakout task: (in a separate class)
     * <br/> - navigate to this url <a href="https://www.saucedemo.com/v1/inventory.html">SauceDemo</a>
     * <br/> - add the first item you find to your cart
     * <br/> - open your cart*
     * <br/> - assert that the item name is correct inside the cart
     */
    @Test
    public void addItemToCart(){
        driver.navigate().to("https://www.saucedemo.com/v1/inventory.html");
        By addFirstItemToCartButton = By.xpath("(//button[contains(@class,'btn_inventory')])[1]");
        driver.findElement(addFirstItemToCartButton).click();

        // traditional approach
//        By opencartButton = By.xpath("//a[contains(@class,'shopping_cart_link')]");
//        driver.findElement(opencartButton).click();

        // creative approach (SEAMS)
        driver.navigate().to("https://www.saucedemo.com/v1/cart.html");

        By firstCartItemNameLabel = By.xpath("//div[@class='inventory_item_name']");
        var actualFirstItemName = driver.findElement(firstCartItemNameLabel).getText();
        Assertions.assertEquals("Sauce Labs Backpack", actualFirstItemName);
    }

    @BeforeEach
    public void beforeEach(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterEach
    public void afterEach(){
        driver.quit();
    }
}
