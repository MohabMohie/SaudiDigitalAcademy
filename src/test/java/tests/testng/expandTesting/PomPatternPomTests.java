package tests.testng.expandTesting;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.expandTesting.Login;
import pages.expandTesting.Secure;
import tests.testng.Tests;

public class PomPatternPomTests extends Tests {
    @Test
    public void loginTest(){
        Login loginPage = new Login(driver,bot);
        loginPage.goTo();
        loginPage.login("practice", "SuperSecretPassword!");

        // redirected to second page
        Secure securePage = new Secure(driver,bot);
        String actualText = securePage.readFlashMessage();
        Assert.assertEquals(actualText, "You logged into a secure area!");
    }
}
