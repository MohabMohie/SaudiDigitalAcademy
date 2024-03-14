package tests.junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;

import java.util.Set;

public class WindowTests extends Tests{

    @Test
    public void windowTest(){
        driver.navigate().to("https://www.selenium.dev/");
        var originalWindowHandle = driver.getWindowHandle();

        driver.switchTo().newWindow(WindowType.TAB);

        Set<String > handles = driver.getWindowHandles();
        handles.remove(originalWindowHandle);
        String newWindowHandle = (String) handles.toArray()[0];

        driver.switchTo().window(originalWindowHandle);
        driver.switchTo().window(newWindowHandle);

        driver.navigate().to("https://www.saucedemo.com/v1/index.html");
        driver.navigate().back();
        driver.navigate().forward();

        driver.switchTo().newWindow(WindowType.WINDOW);

        handles = driver.getWindowHandles();
        handles.remove(originalWindowHandle);
        handles.remove(newWindowHandle);
        String thirdWindowHandle = (String) handles.toArray()[0];

        driver.switchTo().window(originalWindowHandle);
        driver.switchTo().window(thirdWindowHandle);
        driver.switchTo().window(newWindowHandle);
        driver.switchTo().window(originalWindowHandle);

        Assertions.assertEquals("https://www.selenium.dev/", driver.getCurrentUrl());
    }
}
