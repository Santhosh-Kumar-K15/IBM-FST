import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class seleniumActivity8 {

    public static void main(String[] args) {
        // Setup the Firefox driver(GeckoDriver)
        WebDriverManager.firefoxdriver().setup();

        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();

        // Open the browser
        driver.get("https://v1.training-support.net/selenium/dynamic-controls");

        // getting page's title and print it in console
        String title = driver.getTitle();
        System.out.println(title);

        //Actions builder = new Actions(driver);
        // create wait object
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement toogleBox = driver.findElement(By.id("toggleCheckbox"));
        toogleBox.click();

        WebElement checkBox = driver.findElement(By.id("dynamicCheckbox"));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("dynamicCheckbox")));
        System.out.println(checkBox.isDisplayed());

        toogleBox.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("dynamicCheckbox")));
        System.out.println(checkBox.isDisplayed());

        //close the browser
        driver.quit();

    }
}
