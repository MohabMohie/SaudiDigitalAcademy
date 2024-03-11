package tests.junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ActionTests extends Tests {

    @Test
    public void alertTest(){
        driver.navigate().to("https://demo.automationtesting.in/Alerts.html");
        By button = By.cssSelector("button[onclick='alertbox()']");
        driver.findElement(button).click();
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        String text = alert.getText();
        alert.accept();
        Assertions.assertEquals("I am an alert box!", text);
    }

    @Test
    public void basicAuthTest(){
        driver.navigate().to("https://admin:admin@the-internet.herokuapp.com/basic_auth");
        By message = By.tagName("p");
        var actualMessage = driver.findElement(message).getText();
        Assertions.assertEquals("Congratulations! You must have the proper credentials.", actualMessage);
    }

    @Test
    public void iFrame(){
        driver.navigate().to("https://www.selenium.dev/selenium/web/click_frames.html");
        WebElement iframe = driver.findElement(By.xpath("//frame[@name='source']"));
        driver.switchTo().frame(iframe);
        var headerText = driver.findElement(By.tagName("h1")).getText();
        driver.switchTo().defaultContent();
        Assertions.assertEquals("Testing Clicks", headerText);
    }
}
