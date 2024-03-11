package tests.testng;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BasicGoogleTests extends Tests{
    /**
     * Breakout task: 40 minutes
     * 1. recreate the base test class for junit with testng
     * 2. copy the actionsbot to your project under `src/main/java/engine`
     * 3. create a new tests.testng package
     * 4. create a new class
     * 5. do a quick google search and assert that result stats is not empty using testng
     */
    @Test
    public void quickGoogleSearch(){
        bot.navigate("https://www.google.com/");
        By searchInput = By.id("APjFqb");
        bot.type(searchInput, "Selenium WebDriver" + Keys.RETURN);
        By resultStatsLabel = By.id("result-stats");
//        assert !"".equals(driver.findElement(resultStatsLabel).getText()) : "Expected resultStats to be empty";
        Assert.assertNotEquals(driver.findElement(resultStatsLabel).getText(), "");
    }
}
