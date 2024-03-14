package tests.junit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestClassStructured {
    // 1. class level

    // 2. BeforeAll

    // 3. BeforeEach
    // 4. testMethod1
    // 5. AfterEach

    // 6. BeforeEach
    // 7. testMethod2
    // 8. AfterEach

    // 9. AfterAll
    WebDriver driver;

    @Test
    public void checkPageTitle(){
        // test steps
        driver.navigate().to("https://duckduckgo.com/"); // Google.com
        //checkpoint
        var title = driver.getTitle();
        Assertions.assertEquals("DuckDuckGo — Privacy, simplified.", title);
//        Assertions.assertTrue(title.equals("DuckDuckGo"));
//        Assertions.assertEquals("DuckDuckGo", title);
    }

    @Test
    public void checkPageUrl(){
        // test steps
        driver.navigate().to("https://duckduckgo.com/"); // Google.com
        //checkpoint
        var currentUrl = driver.getCurrentUrl();
        Assertions.assertEquals("https://duckduckgo.com/", currentUrl);
    }

    @Test
    public void webFormManipulation(){
        // writing text
        By textInput = By.id("my-text-id");
        driver.findElement(textInput).sendKeys("Selenium is Great!");

        // reading text
        By pageHeader = By.tagName("h1");
        var textValue = driver.findElement(pageHeader).getText();
        Assertions.assertEquals("Web form", textValue);
    }

    @BeforeEach
    public void beforeEach(){
        // initializing the session
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        // initial navigation
        driver.navigate().to("https://www.selenium.dev/selenium/web/web-form.html");
    }

    @AfterEach
    public void afterEach(){
        //terminating the session
        driver.quit();
    }
}
