import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class seleniumActivity22 {

    public static void main(String[] args) {
        // Setup the Firefox driver(GeckoDriver)
        WebDriverManager.firefoxdriver().setup();

        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();

        // Open the browser
        driver.get("https://v1.training-support.net/selenium/popups");

        // getting page's title and print it in console
        String title = driver.getTitle();
        System.out.println(title);

        // Create wait object
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Actions action = new Actions(driver);

        WebElement signInButton = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/button"));
        action.moveToElement(signInButton).perform();

        String hoverMessage = signInButton.getText();
        System.out.println(hoverMessage);

        signInButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
        WebElement userName = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("password"));

        userName.sendKeys("admin");
        password.sendKeys("password");

        WebElement login = driver.findElement(By.xpath("/html/body/div[4]/div/div[2]/div/div/button"));
        login.click();

        WebElement loginMessage = driver.findElement(By.xpath("//*[@id=\"action-confirmation\"]"));
        System.out.println(loginMessage.getText());

        //close the browser
        //driver.quit();

    }

}
