package pages.sauceDemo;

import engine.ActionsBot;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Inventory {
    private final WebDriver driver;
    private final ActionsBot bot;
    private final String url = "https://www.saucedemo.com/v1/inventory.html";
    private final By productsLabel = By.className("product_label");
    public Inventory(WebDriver driver, ActionsBot bot){
        this.driver = driver;
        this.bot = bot;
    }

    @Step("Navigate to the SauceDemo inventory page")
    public void goTo(){
        bot.navigate(url);
    }

    @Step("Reading inventory page header")
    public String readHeader(){
        return bot.getText(productsLabel);
    }
}
