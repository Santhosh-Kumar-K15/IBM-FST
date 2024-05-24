import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity3 {

    public static void main(String[] args) {
        // Setup the Firefox driver(GeckoDriver)
        WebDriverManager.firefoxdriver().setup();

        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();

        // Open the browser
        driver.get("https://alchemy.hguy.co/crm/");

        // Getting the first copyright text in the footer
        WebElement firstCopyRightText = driver.findElement(By.xpath("//*[@id=\"admin_options\"]"));

        // Printing the text to the console
        System.out.println(firstCopyRightText.getText());

        // close browser
        driver.quit();

    }
}
