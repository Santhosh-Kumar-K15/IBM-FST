import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

public class testNGActivity7 {
    WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {
        // Setup the Firefox driver(GeckoDriver)
        WebDriverManager.firefoxdriver().setup();

        // Create a new instance of the Firefox driver
        driver = new FirefoxDriver();

        // Open the browser
        driver.get("https://v1.training-support.net/selenium/login-form");

    }
    @DataProvider(name="Authentication")
    public static Object[][] credentials() {
        return new Object[][] {
                {"admin","password"},

        };
    }
    @Test(dataProvider = "Authentication")
    public void testCase(String username,String password) {

        WebElement userName = driver.findElement(By.id("username"));
        WebElement password1 = driver.findElement(By.id("password"));
        userName.sendKeys(username);
        password1.sendKeys(password);

        driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div/div/button")).click();

    }

    @AfterMethod
    public void afterMethod(){
        driver.quit();
    }
}
