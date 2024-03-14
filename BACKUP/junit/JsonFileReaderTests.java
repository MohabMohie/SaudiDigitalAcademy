//package testPackage;
//
//import org.json.simple.JSONObject;
//import org.json.simple.parser.JSONParser;
//import org.json.simple.parser.ParseException;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.Test;
//import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
//
//import java.io.FileReader;
//import java.io.IOException;
//import java.nio.charset.StandardCharsets;
//
//public class JsonFileReaderTests extends Tests{
//    static JSONObject testData;
//
//    @BeforeAll
//    public static void beforeAll() {
//        testData =  (JSONObject) new JSONParser().parse( new FileReader("src/test/resources/testData/sample.json", StandardCharsets.UTF_8) );
//    }
//
//    @Test
//    public void jsonDataTest(){
//        String searchQuery = (String) testData.get("searchQuery");
//
//        driver.get("https://www.google.com/");
//        driver.findElement(By.id("APjFqb")).sendKeys(searchQuery + Keys.RETURN);
//
//        By resultStats = By.id("result-stats");
//        wait.until(d -> !driver.findElement(resultStats).getText().isEmpty());
//        String actualText = driver.findElement(resultStats).getText();
//        Assertions.assertNotEquals("", actualText);
//
//    }
//}
