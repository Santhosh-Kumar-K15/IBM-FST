import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class seleniumActivity21 {

    public static void main(String[] args) {
        // Setup the Firefox driver(GeckoDriver)
        WebDriverManager.firefoxdriver().setup();

        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();

        // Open the browser
        driver.get("https://v1.training-support.net/selenium/tab-opener");

        // getting page's title and print it in console
        String title = driver.getTitle();
        System.out.println(title);

        // Create wait object
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement newTabButton = driver.findElement(By.xpath("//*[@id=\"launcher\"]"));
        newTabButton.click();

        wait.until(ExpectedConditions.numberOfWindowsToBe(2));

        Set<String> handles = driver.getWindowHandles();
        System.out.println(handles);

        for (String handle: driver.getWindowHandles()){
            driver.switchTo().window(handle);
        }
        String newTab = driver.getTitle();
        System.out.println(newTab);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("content")));
        String heading = driver.findElement(By.className("content")).getText();
        System.out.println(heading);

        wait.until(ExpectedConditions.elementToBeClickable(By.id("actionButton")));
        WebElement anotherTabButton = driver.findElement(By.id("actionButton"));
        anotherTabButton.click();

        for (String handle: driver.getWindowHandles()){
            driver.switchTo().window(handle);
        }

        String anotherNewTab = driver.getTitle();
        System.out.println(anotherNewTab);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("content")));
        String anotherTabHeading = driver.findElement(By.className("content")).getText();
        System.out.println(anotherTabHeading);

        //close the browser
        driver.quit();

    }

}
