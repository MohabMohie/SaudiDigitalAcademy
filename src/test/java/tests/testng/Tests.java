package tests.testng;

import engine.ActionsBot;
import engine.CustomListener;
import engine.PropertiesReader;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;

public abstract class Tests {
    protected WebDriver driver;
    protected Wait<WebDriver> wait;
    protected static Logger logger;
    protected ActionsBot bot;
    protected static JSONObject testData;
    protected JSONObject testCaseData;

    @Step("Initializing test data and properties")
    @BeforeClass
    public static void globalSetup() throws IOException, ParseException {
        Configurator.initialize(null, "src/main/resources/properties/log4j2.properties");
        logger = LogManager.getLogger(Tests.class.getName());
        testData =  (JSONObject) new JSONParser().parse( new FileReader("src/test/resources/testData/sample.json", StandardCharsets.UTF_8) );
        PropertiesReader.readPropertyFile("src/main/resources/properties/configuration.properties");
    }

    @Step("Initializing target browser")
    @Parameters({ "target-browser" })
    @BeforeMethod
    public void browserInitialization(@Optional("chrome") String targetBrowser){
        targetBrowser = PropertiesReader.props.getProperty("targetBrowser");
        logger.info("Launching "+targetBrowser+" browser");

        switch (targetBrowser){
            case "chrome" -> driver = new ChromeDriver();
            case "firefox" -> driver = new FirefoxDriver();
            case "safari" -> driver = new SafariDriver();
            case "edge" -> driver = new EdgeDriver();
        }

        driver = new EventFiringDecorator(new CustomListener()).decorate(driver);

        driver.manage().window().maximize();

        logger.info("Configuring 5 second explicit wait");
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        bot = new ActionsBot(driver, wait, logger);
    }

    @Step("Terminating target browser")
    @AfterMethod
    public void browserTermination(){
        logger.info("Quitting Browser");
        driver.quit();
    }
}
