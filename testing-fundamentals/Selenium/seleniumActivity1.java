import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class seleniumActivity1 {

    public static void main(String[] args) {
        // Setup the Firefox driver(GeckoDriver)
        WebDriverManager.firefoxdriver().setup();

        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();

        // Open the browser
        driver.get("https://v1.training-support.net");


        // getting page's title
        String title = driver.getTitle();
        System.out.println(title);

        // Find the "About us" button on the page using It's id
        WebElement aboutUs = driver.findElement(By.id("about-link"));

        //click on that button
        aboutUs.click();

        //get the title of the new page and print it to the console
        String title2 = driver.getTitle();
        System.out.println(title2);

        driver.quit();

    }

}
