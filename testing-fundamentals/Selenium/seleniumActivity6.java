import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class seleniumActivity6 {
    public static void main(String[] args) {
        // Setup the Firefox driver(GeckoDriver)
        WebDriverManager.firefoxdriver().setup();

        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();

        // Open the browser
        driver.get("https://v1.training-support.net/selenium/input-events");

        // getting page's title and print it in console
        String title = driver.getTitle();
        System.out.println(title);

        // Press the kay of first letter of your name in caps
        Actions action = new Actions(driver);
        action.sendKeys("S").perform();

        // Press CTRL+a and CTRL+c to copy all the text on the page
        driver.findElement(By.tagName("body")).sendKeys(Keys.CONTROL,"a");
        driver.findElement(By.tagName("body")).sendKeys(Keys.CONTROL,"c");


        //close the browser
        driver.quit();

    }
}
