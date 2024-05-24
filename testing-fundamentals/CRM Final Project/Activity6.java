import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Activity6 {
    public static void main(String[] args) {
        // Setup the Firefox driver(GeckoDriver)
        WebDriverManager.firefoxdriver().setup();

        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Open the browser
        driver.get("https://alchemy.hguy.co/crm/");

        // Enter login credentials into the respective fields
        WebElement userName = driver.findElement(By.id("user_name"));
        userName.sendKeys("admin");

        WebElement password = driver.findElement(By.id("username_password"));
        password.sendKeys("pa$$w0rd");

        // Click login
        driver.findElement(By.id("bigbutton")).click();

        // Ensuring that the “Activities” menu item exists.
        WebElement activitiesMenu = driver.findElement(By.xpath("//*[@id=\"grouptab_3\"]"));
        activitiesMenu.click();

        // close browser
        driver.quit();

    }
}
