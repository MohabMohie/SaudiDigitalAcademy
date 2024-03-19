package pages.expandTesting;

import engine.ActionsBot;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login extends Pages{
    private final String url = "https://practice.expandtesting.com/login";
    private final By usernameInput = By.id("username"); //practice
    private final By passwordInput = By.id("password"); //SuperSecretPassword!
    private final By submitButton = By.cssSelector("button[type='submit']");
    public Login(WebDriver driver, ActionsBot bot) {
        super(driver, bot);
    }
    public void goTo(){
        bot.navigate(url);
    }

    public void login(String username, String password){
        bot.type(usernameInput, username);
        bot.type(passwordInput, password);
        bot.click(submitButton);

    }

}
