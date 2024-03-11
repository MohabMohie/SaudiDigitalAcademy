package tests.testng;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class BasicGoogleTests extends Tests{
    /**
     * Breakout task: 40 minutes
     * 1. recreate the base test class for junit with testng
     * 2. copy the actionsbot to your project under `src/main/java/engine`
     * 3. create a new tests.testng package
     * 4. create a new class
     * 5. do a quick google search and assert that result stats is not empty using testng
     */
    @Test(groups = {"sanityCheck", "guiTests"})
    public void quickGoogleSearch(){
        bot.navigate("https://www.google.com/");
        By searchInput = By.id("APjFqb");
        bot.type(searchInput, "Selenium WebDriver" + Keys.RETURN);
        By resultStatsLabel = By.id("result-stats");
        Assert.assertNotEquals(driver.findElement(resultStatsLabel).getText(), "");
    }

    @Test(testName = "Check Google Logo Exists", description = "Given I am on the Google homepage, Then the Google logo should be displayed")
    public void assertGoogleLogoExists(){
        bot.navigate("https://www.google.com/");
        By googleLogoImage = By.cssSelector("img[alt='Google']");
//        Assert.assertTrue(driver.findElement(googleLogoImage).isDisplayed());

//        Assert.assertFalse(driver.findElement(googleLogoImage).isDisplayed(), "first check failed");
//        Assert.assertTrue(driver.findElement(googleLogoImage).isDisplayed(), "second check failed");
//        Assert.assertFalse(driver.findElement(googleLogoImage).isDisplayed(), "third check failed");

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertFalse(driver.findElement(googleLogoImage).isDisplayed(), "first check failed");
        softAssert.assertTrue(driver.findElement(googleLogoImage).isDisplayed(), "second check failed");
        softAssert.assertFalse(driver.findElement(googleLogoImage).isDisplayed(), "third check failed");
        softAssert.assertAll();

    }
}
