package tests.testng;

import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertionsTests extends Tests{
    /**
     * Breakout session: 30 minutes
     * navigate to https://practicetestautomation.com/practice-test-login/
     * login using "Username": "student" + "Password": "Password123" (using testdata.json is optional)
     * check that the url is correct "https://practicetestautomation.com/logged-in-successfully/"
     * check the successful login, congratulations message, and logout button are displayed
     */
    @Test(testName = "Basic Soft Assertions Test", description = "Given I am on the practice login page, When I input valid credentials, Then I am logged in successfully.")
    public void softAssertionsTest() {
        bot.navigate("https://practicetestautomation.com/practice-test-login/");
        By usernameInput = By.id("username");
        By passwordInput = By.id("password");
        By submitButton = By.id("submit");

        JSONObject testCaseData = (JSONObject) testData.get("SoftAssertionsTestData");
        bot.type(usernameInput, (String) testCaseData.get("Username"));
        bot.type(passwordInput, (String) testCaseData.get("Password"));
        bot.click(submitButton);

        By successfulLoginLabel = By.className("post-title");
        By congratulationsLabel = By.tagName("strong");
        By logOutButton = By.xpath("//a[contains(@href,'practice-test-login')]");


        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(driver.getCurrentUrl(), "https://practicetestautomation.com/logged-in-successfully/", "Not redirected correctly!");
        softAssert.assertTrue(driver.findElement(successfulLoginLabel).isDisplayed(), "Successful Login label is not displayed!");
        softAssert.assertTrue(driver.findElement(congratulationsLabel).isDisplayed(), "Congratulations label is not displayed!");
        softAssert.assertTrue(driver.findElement(logOutButton).isDisplayed(), "Login button is not displayed!");
        softAssert.assertAll();
    }
}
