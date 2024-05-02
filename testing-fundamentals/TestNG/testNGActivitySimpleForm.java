import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import java.util.concurrent.TimeUnit;

public class testNGActivitySimpleForm extends testNGDataProvider{
    WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {
        // Setup the Firefox driver(GeckoDriver)
        WebDriverManager.firefoxdriver().setup();

        // Create a new instance of the Firefox driver
        driver = new FirefoxDriver();

        // Open the browser
        driver.get("https://v1.training-support.net/selenium/simple-form");

    }
//    @DataProvider(name="Authentication")
//    public static Object[][] credentials() {
//        return new Object[][] {
//                {"Santhosh","Kumar","sandy@ibm.com","9876543210","Hi i'am sandy"},
//                {"Maddy","Kumar","maddy@ibm.com","9876543211","Hi i'am Maddy"},
//                {"Arul","Kumar","arul@ibm.com","9876543212","Hi i'am Arul"}
//        };
//    }

//    @Test(dataProviderClass= testNGDataProvider.class, dataProvider = "Authentication")
    @Test(dataProvider = "Authentication")
    public void testCase(String firstname,String lastname,String email,String number,String message) {

        WebElement firstName = driver.findElement(By.id("firstName"));
        WebElement lastName = driver.findElement(By.id("lastName"));
        WebElement emailId = driver.findElement(By.id("email"));
        WebElement phNumber = driver.findElement(By.id("number"));
        WebElement testMessage = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/form/div/div[5]/textarea"));
        firstName.sendKeys(firstname);
        lastName.sendKeys(lastname);
        emailId.sendKeys(email);
        phNumber.sendKeys(number);
        testMessage.sendKeys(message);

        WebElement submitButton = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/form/div/div[6]/div[1]/input"));
        submitButton.click();

        Alert alert = driver.switchTo().alert();
        alert.accept();
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @AfterMethod
    public void afterMethod(){
        driver.close();
    }
}
