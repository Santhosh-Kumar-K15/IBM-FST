import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class seleniumActivity9 {
    public static void main(String[] args) {
        // Setup the Firefox driver(GeckoDriver)
        WebDriverManager.firefoxdriver().setup();

        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();

        // Open the browser
        driver.get("https://v1.training-support.net/selenium/ajax");

        // getting page's title and print it in console
        String title = driver.getTitle();
        System.out.println(title);

        //Actions builder = new Actions(driver);
        // create wait object
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement contentButton = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/button"));
        contentButton.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ajax-content")));
        WebElement helloText = driver.findElement(By.id("ajax-content"));
        System.out.println(helloText.getText());

        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//*[@id=\"ajax-content\"]"),"I'm late!"));
        WebElement iamLateText = driver.findElement(By.cssSelector("#ajax-content > h3:nth-child(2)"));
        System.out.println(iamLateText.getText());


        //close the browser
        driver.quit();

    }

}
