import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.*;

public class testNGActivity9 {
    WebDriver driver;

    @BeforeTest
    public void beforeTest() {
        // Setup the Firefox driver(GeckoDriver)
        WebDriverManager.firefoxdriver().setup();

        // Create a new instance of the Firefox driver
        driver = new FirefoxDriver();

        // Open the browser
        driver.get("https://v1.training-support.net/selenium/javascript-alerts");

    }
    @BeforeMethod
    public void beforeMethod(){
        driver.switchTo().defaultContent();
    }
    @Test
    public void simpleAlertTestCase(){
        driver.findElement(By.id("simple")).click();
        Alert alert = driver.switchTo().alert();
        String message = alert.getText();
        System.out.println(message);
        alert.accept();
        Assert.assertEquals(message, "This is a JavaScript Alert!");

        Reporter.log("Simple Alert done");
    }
    @Test
    public void confirmAlertTestCase(){
        driver.findElement(By.id("confirm")).click();
        Alert alert = driver.switchTo().alert();
        String message = alert.getText();
        System.out.println(message);
        alert.accept();
        Assert.assertEquals(message, "This is a JavaScript Confirmation!");

        Reporter.log("Confirmation Alert done");

    }
    @Test
    public void promptAlertTestCase(){
        driver.findElement(By.id("prompt")).click();
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("prompt alert");
        String message = alert.getText();
        System.out.println(message);
        alert.accept();
        Assert.assertEquals(message, "This is a JavaScript Prompt!");


        Reporter.log("Prompt Alert done");
    }
    @AfterTest
    public void afterTest(){
        driver.quit();
    }
}
