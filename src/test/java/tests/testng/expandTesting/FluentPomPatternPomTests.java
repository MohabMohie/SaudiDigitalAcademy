package tests.testng.expandTesting;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.expandTesting.Login;
import tests.testng.Tests;

public class FluentPomPatternPomTests extends Tests {
    /**
     * breakout task: 40 minutes
     * - implement fluent POM design, using abstract page class
     * - add a new failed login test
     * - read data from json
     * - generate single allure html file
     */
    @Test(description = "Successful Login")
    public void loginTest1(){
        JSONObject testCaseData = (JSONObject) testData.get("expandTesting");
        String actualText = new Login(driver,bot)
                .goTo()
                .successfulLogin((String) testCaseData.get("Username"), (String) testCaseData.get("Password"))
                .readSuccessMessage();
        Assert.assertEquals(actualText, (String) testCaseData.get("ExpectedSuccessMessage"));
    }

    @Test(description = "Failed Login")
    public void loginTest2(){
        JSONObject testCaseData = (JSONObject) testData.get("expandTesting");
        String actualText = new Login(driver,bot)
                .goTo()
                .failedLogin((String) testCaseData.get("Username"), (String) testCaseData.get("WrongPassword"))
                .readFailureMessage();
        Assert.assertEquals(actualText, (String) testCaseData.get("ExpectedFailureMessage"));
    }
}
