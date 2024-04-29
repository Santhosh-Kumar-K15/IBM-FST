import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class seleniumActivity16 {

    public static void main(String[] args) {
        // Setup the Firefox driver(GeckoDriver)
        WebDriverManager.firefoxdriver().setup();

        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();

        // Open the browser
        driver.get("https://v1.training-support.net/selenium/dynamic-attributes");

        // getting page's title and print it in console
        String title = driver.getTitle();
        System.out.println(title);

        // Create wait object
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Find username, password, confirm password & email and type in credentials
        WebElement userName = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div/div[3]/div/div/div[1]/input"));
        userName.sendKeys("admin");

        WebElement password = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div/div[3]/div/div/div[2]/input"));
        password.sendKeys("password");

        WebElement confirmPassword = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div/div[3]/div/div/div[3]/input"));
        confirmPassword.sendKeys("password");

        WebElement email = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div/div[3]/div/div/div[4]/input"));
        email.sendKeys("sandy@ibm.com");

        // click sign up button
        WebElement signUpButton = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div/div[3]/div/div/button"));
        signUpButton.click();

        // wait and print the message appeared
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"action-confirmation\"]")));
        WebElement loginMessage = driver.findElement(By.xpath("//*[@id=\"action-confirmation\"]"));
        System.out.println(loginMessage.getText());

        //close the browser
        driver.quit();

    }

}
