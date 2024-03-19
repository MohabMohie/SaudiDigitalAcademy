package pages.expandTesting;

import engine.ActionsBot;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Secure extends Pages{
    private final By flashMessageLabel = By.id("flash-message");

    public Secure(WebDriver driver, ActionsBot bot) {
        super(driver, bot);
    }

    @Step ("Then I will be logged in successfully")
    public String readSuccessMessage(){
        return bot.getText(flashMessageLabel);
    }
}
