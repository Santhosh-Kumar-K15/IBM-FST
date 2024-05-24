import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class Activity1 {

    public static void main(String[] args) {
        // Setup the Firefox driver(GeckoDriver)
        WebDriverManager.firefoxdriver().setup();

        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();

        // Open the browser
        driver.get("https://alchemy.hguy.co/crm/");

        // getting page's title
        String title = driver.getTitle();
        System.out.println(title);

        // Making sure it matches “SuiteCRM” exactly.
        Assert.assertEquals("SuiteCRM", title);

        driver.quit();

    }
}
