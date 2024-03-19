package tests.testng;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.sauceDemo.Inventory;
import pages.sauceDemo.Login;

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
        Inventory inventoryPage = new Inventory(driver, bot);
        Assert.assertEquals(inventoryPage.readHeader(), "Products");
    }
}
