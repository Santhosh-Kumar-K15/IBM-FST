import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class seleniumActivity19 {

    public static void main(String[] args) {
        // Setup the Firefox driver(GeckoDriver)
        WebDriverManager.firefoxdriver().setup();

        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();

        // Open the browser
        driver.get("https://v1.training-support.net/selenium/javascript-alerts");

        // getting page's title and print it in console
        String title = driver.getTitle();
        System.out.println(title);

        // Create wait object
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement confirmButton = driver.findElement(By.xpath("//*[@id=\"confirm\"]"));
        confirmButton.click();

        wait.until(ExpectedConditions.alertIsPresent());

        //Switch the focus from the main window to the alert box and get the text in it and print it
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());

        // Close the alert once with OK and again with CANCEL
        alert.accept();
        confirmButton.click();
        alert.dismiss();

        //close the browser
        driver.quit();

    }

}
