package tests.junit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileManipulationTests extends Tests {
    static Path downloadedFilePath = Paths.get(System.getProperty("user.home") + "/Downloads/importData.csv");

    @Test
    public void fileDownloadTest() throws InterruptedException {
        driver.get("https://opensource-demo.orangehrmlive.com/");
        By usernameInput = By.name("username");
        By passwordInput = By.name("password");
        By loginButton = By.tagName("button");

        bot.type(usernameInput, "Admin");
        bot.type(passwordInput, "admin123");
        bot.click(loginButton);

        By pimButton = By.xpath("//a[contains(@href,'viewPimModule')]");
        bot.click(pimButton);

        By configurationButton = By.xpath("//li[contains(.,'Configuration')]");
        By dataImportButton = By.xpath("//a[text()='Data Import']");
        bot.click(configurationButton);
        bot.click(dataImportButton);

        By downloadSampleCSVfileButton = By.xpath("//a[text()='Download']");
        bot.click(downloadSampleCSVfileButton);

        Thread.sleep(5000);
        Assertions.assertTrue(Files.exists(downloadedFilePath));
    }

    @AfterAll
    public static void afterAll() throws IOException {
        Files.delete(downloadedFilePath);
    }
}
