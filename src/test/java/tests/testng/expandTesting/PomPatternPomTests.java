package tests.testng.expandTesting;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.expandTesting.Login;
import pages.expandTesting.Secure;
import tests.testng.Tests;

public class PomPatternPomTests extends Tests {
    @Test(description = "Successful Login")
    public void loginTest(){
        Login loginPage = new Login(driver,bot);
        loginPage.goTo();
        loginPage.successfulLogin("practice", "SuperSecretPassword!");

        // redirected to second page
        Secure securePage = new Secure(driver,bot);
        String actualText = securePage.readSuccessMessage();
        Assert.assertEquals(actualText, "You logged into a secure area!");
    }
}
