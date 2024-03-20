package pages.expandTesting;

import engine.ActionsBot;
import engine.PropertiesReader;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login extends Pages{
    private final String url = PropertiesReader.props.getProperty("baseUrl") + "login";
    private final By usernameInput = By.id("username"); //practice
    private final By passwordInput = By.id("password"); //SuperSecretPassword!
    private final By submitButton = By.cssSelector("button[type='submit']");
    private final By flashMessageLabel = By.id("flash-message");

    public Login(WebDriver driver, ActionsBot bot) {
        super(driver, bot);
    }

    @Step ("Given I am on the login page")
    public Login goTo(){
        bot.navigate(url);
        return this;
    }

    @Step ("When I successfully perform the login action")
    public Secure successfulLogin(String username, String password){
        login(username, password);
        return new Secure(driver,bot);
    }

    @Step ("When I fail to perform the login action")
    public Login failedLogin(String username, String password){
        login(username, password);
        return this;
    }

    private void login(String username, String password){
        bot.type(usernameInput, username);
        bot.type(passwordInput, password);
        bot.click(submitButton);
    }

    @Step ("Then I will be see an error message")
    public String readFailureMessage(){
        return bot.getText(flashMessageLabel);
    }

}
