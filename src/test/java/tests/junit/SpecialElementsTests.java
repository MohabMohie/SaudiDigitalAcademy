package tests.junit;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

/**
 * initialize the browser in maximized mode (using options)
 * navigate to <a href="https://www.selenium.dev/selenium/web/web-form.html">web form test page</a>
 * check the box and validate that it is checked
 * select the radio and validate that it is selected
 * choose an item (by value) from the select dropdown menu and validate that it is selected (by text)
 */
public class SpecialElementsTests {
    WebDriver driver;

    @Test
    public void checkBoxesTest(){
        By checkbox = By.id("my-check-2");
        driver.findElement(checkbox).click();
        boolean isChecked = driver.findElement(checkbox).isSelected();
        Assertions.assertTrue(isChecked);
    }

    @Test
    public void checkBoxesNegativeTest(){
        By checkbox = By.id("my-check-2");
        driver.findElement(checkbox).click();
        driver.findElement(checkbox).click();
        boolean isChecked = driver.findElement(checkbox).isSelected();
        Assertions.assertFalse(isChecked);
    }

    @Test
    public void radioButtonsTest(){
        By radioButton = By.id("my-radio-2");
        driver.findElement(radioButton).click();
        boolean isSelected = driver.findElement(radioButton).isSelected();
        Assertions.assertTrue(isSelected);
    }

    @Test
    public void selectFromDropDownTest(){
        By selectElement = By.name("my-select");
        Select select = new Select(driver.findElement(selectElement));
        select.selectByValue("2");
        String actualText = select.getAllSelectedOptions().getFirst().getText();
        Assertions.assertEquals("Two", actualText);
    }

    @BeforeEach
    public void beforeEach(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized");
        driver = new ChromeDriver(chromeOptions);
        driver.navigate().to("https://www.selenium.dev/selenium/web/web-form.html");
        Faker faker = new Faker();
        var randomName = faker.name().name();
        var randomName2 = faker.name().name();
        var randomName3 = faker.name().name();
        var randomName4 = faker.name().name();
        var randomName5 = faker.name().name();
        var randomName6 = faker.name().name();

    }

    @AfterEach
    public void afterEach(){
        driver.quit();
    }
}
