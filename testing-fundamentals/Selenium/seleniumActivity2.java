import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class seleniumActivity2 {

    public static void main(String[] args) {
        // Setup the Firefox driver(GeckoDriver)
        WebDriverManager.firefoxdriver().setup();

        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();

        // Open the browser
        driver.get("https://v1.training-support.net/selenium/login-form");

        // getting page's title and print it in console
        String title = driver.getTitle();
        System.out.println(title);

        // Find the username field using any locator and enter "admin" into it.
        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys("admin");

        // Find the password field using any locator and enter "password" into it.
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("password");

        // Find login button using any locator and click it.
        WebElement loginButton = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div/div/button"));
        loginButton.click();

        //close the browser
        //driver.quit();

    }
}
