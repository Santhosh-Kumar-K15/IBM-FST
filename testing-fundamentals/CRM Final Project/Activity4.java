import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class Activity4 {
    public static void main(String[] args) {
        // Setup the Firefox driver(GeckoDriver)
        WebDriverManager.firefoxdriver().setup();

        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();

        // Open the browser
        driver.get("https://alchemy.hguy.co/crm/");

        // Enter login credentials into the respective fields
        WebElement userName = driver.findElement(By.id("user_name"));
        userName.sendKeys("admin");

        WebElement password = driver.findElement(By.id("username_password"));
        password.sendKeys("pa$$w0rd");

        // Click login
        driver.findElement(By.id("bigbutton")).click();

        // Verify that the homepage has opened
        String title = driver.getCurrentUrl();
        Assert.assertEquals("https://alchemy.hguy.co/crm/index.php?module=Home&action=index", title);

        // close browser
        driver.quit();

    }

}
