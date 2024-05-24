import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity2 {

    public static void main(String[] args) {
        // Setup the Firefox driver(GeckoDriver)
        WebDriverManager.firefoxdriver().setup();

        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();

        // Open the browser
        driver.get("https://alchemy.hguy.co/crm/");

        WebElement headerUrl = driver.findElement(By.xpath("/html/body/div[1]/div[1]/a"));
        // Getting the url of the header image
        String url = headerUrl.getAttribute("href");
        // Printing the url to the console
        System.out.println(url);

        // close browser
        driver.quit();

    }
}
