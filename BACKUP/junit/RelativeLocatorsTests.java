package tests.junit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

/**
 * Navigate to <a href="https://www.saucedemo.com/v1/index.html">SauceDemo</a>
 * login as standard_user
 * use Selenium Relative Locators to identify the login button
 */
public class RelativeLocatorsTests {
    WebDriver driver;
    String loginPageUrl = "https://www.saucedemo.com/v1/index.html";
    String landingPageUrl = "https://www.saucedemo.com/v1/inventory.html";
    String standardUser = "standard_user";
    String unifiedPassword = "secret_sauce";

    @Test
    public void successfulLogin(){
        login (standardUser,unifiedPassword);
        var currentUrl = driver.getCurrentUrl();
        Assertions.assertEquals(landingPageUrl, currentUrl);
    }

    private void login(String username, String password){
        By usernameTextArea = By.id("user-name");
        By passwordTextArea = By.id("password");
        By loginButton = RelativeLocator.with(By.tagName("input")).below(passwordTextArea);

        driver.findElement(usernameTextArea).sendKeys(username);
        driver.findElement(passwordTextArea).sendKeys(password);
        driver.findElement(loginButton).click();
    }

    @BeforeEach
    public void beforeEach(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to(loginPageUrl);
    }
    @AfterEach
    public void afterEach(){
        driver.quit();
    }
}
