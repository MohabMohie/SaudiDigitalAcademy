package tests.junit;

import engine.ActionsBot;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class Tests {
    protected WebDriver driver;
    protected Wait<WebDriver> wait;
    public static Logger logger;
    public ActionsBot bot;

    @BeforeAll
    public static void beforeAll(){
        Configurator.initialize(null, "src/main/resources/properties/log4j2.properties");
        logger = LogManager.getLogger(Tests.class.getName());
    }

    @BeforeEach
    public void beforeEach(){
        logger.info("Opening Chrome Browser");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized");
        driver = new ChromeDriver(chromeOptions);

        logger.info("Configuring 5 second explicit wait");
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        bot = new ActionsBot(driver, wait, logger);
    }

    @AfterEach
    public void afterEach(){
        logger.info("Quitting Browser");
        driver.quit();
    }

}
