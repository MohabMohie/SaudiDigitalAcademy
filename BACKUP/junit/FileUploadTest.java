package tests.junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class FileUploadTest extends Tests{
    /**
     * Breakout Activity: 20 minute
     * navigate to <a href="https://the-internet.herokuapp.com/upload">Upload Test</a>
     * uploading any file from your machine (make it small please)
     * checking to see that the file was successfully uploaded
     */
    @Test
    public void uploadFile(){
//        String url = "https://the-internet.herokuapp.com/upload";
//        logger.info("Navigating to: "+url);
//        driver.get(url);
        bot.navigate("https://the-internet.herokuapp.com/upload");

        By fileUploadInput = By.xpath("(//input[@type='file'])[1]");

        String fileUploadPath = "C:\\Users\\Mohab\\IdeaProjects\\testProject\\src\\test\\resources\\testData\\sample.json";
        logger.info("Uploading file: "+fileUploadPath);
        driver.findElement(fileUploadInput).sendKeys(fileUploadPath);
        driver.findElement(fileUploadInput).submit();

        By uploadSuccessfullyLabel = By.tagName("h3");
        logger.info("Confirming that the file has been uploaded successfully");
        Assertions.assertEquals("File Uploaded!", driver.findElement(uploadSuccessfullyLabel).getText());
    }
}
