package tests.junit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SauceDemoTests {
    WebDriver driver;

    @Test
    public void checkNameOfFirstElement() {
        // get the locator of the first element => get the text of the first element, it should be "Sauce Labs Backpack"

        // common way
        var inventoryItemName = By.xpath("//div[@class='inventory_item_name']");
        var actualResult = driver.findElements(inventoryItemName).getFirst().getText();
        Assertions.assertEquals("Sauce Labs Backpack", actualResult);

        // optimal way
        var firstInventoryItem = By.xpath("(//div[@class='inventory_item_name'])[1]");
        var actualResult2 = driver.findElement(firstInventoryItem).getText();
        Assertions.assertEquals("Sauce Labs Backpack", actualResult2);

        // very bad way
        var inventoryItem = By.xpath("//div[@class='inventory_item']");
        var actualResult3 = driver.findElements(inventoryItem).getFirst().findElement(inventoryItemName).getText();
        Assertions.assertEquals("Sauce Labs Backpack", actualResult3);
    }

    @BeforeEach
    public void beforeEach(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.saucedemo.com/v1/inventory.html");
    }

    @AfterEach
    public void afterEach(){
        driver.quit();
    }
}
