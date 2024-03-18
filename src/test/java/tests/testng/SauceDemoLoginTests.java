package tests.testng;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.login.Login;

public class SauceDemoLoginTests extends Tests{
    /**
     * Breakout task: 40 minute
     * - login page object model class
     * - one test method that uses this class
     * - optional: read data from json file
     * - optional: create two more test methods
     */
    @Test(testName = "Successful Login Test", description = "Given I am on the login page, When I input valid credentials, Then I am redirected to the Products page.")
    public void successfulLoginTest(){
        Login loginPage = new Login(driver, bot);
        loginPage.goTo();
        loginPage.login("standard_user", "secret_sauce");
        // redirect to another page and hence I should handle synchronization
        By productsLabel = By.className("product_label");
        Assert.assertEquals(driver.findElement(productsLabel).getText(), "Products");
    }
}
