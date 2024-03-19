package pages.expandTesting;

import engine.ActionsBot;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.SplittableRandom;

public class Secure extends Pages{
    private final By flashMessageLabel = By.id("flash-message");

    public Secure(WebDriver driver, ActionsBot bot) {
        super(driver, bot);
    }

    public String readFlashMessage(){
        return bot.getText(flashMessageLabel);
    }
}
