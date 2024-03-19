package tests.testng.expandTesting;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.testng.Tests;

public class FlatPatternPomTests extends Tests {
    @Test
    public void loginTest(){
        bot.navigate("https://practice.expandtesting.com/login");
        By usernameInput = By.id("username"); //practice
        By passwordInput = By.id("password"); //SuperSecretPassword!
        By submitButton = By.cssSelector("button[type='submit']");

        bot.type(usernameInput, "practice");
        bot.type(passwordInput, "SuperSecretPassword!");
        bot.click(submitButton);

        // redirected to second page

        By flashMessageLabel = By.id("flash-message");
        String actualText = bot.getText(flashMessageLabel);
        Assert.assertEquals(actualText, "You logged into a secure area!");
    }
}
