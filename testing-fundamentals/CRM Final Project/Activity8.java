import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity8 {
    public static void main(String[] args) {
        // Setup the Firefox driver(GeckoDriver)
        WebDriverManager.firefoxdriver().setup();

        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Open the browser
        driver.get("https://alchemy.hguy.co/crm/");

        // Enter login credentials into the respective fields
        WebElement userName = driver.findElement(By.id("user_name"));
        userName.sendKeys("admin");

        WebElement password = driver.findElement(By.id("username_password"));
        password.sendKeys("pa$$w0rd");

        // Click login
        driver.findElement(By.id("bigbutton")).click();
        wait.until(ExpectedConditions.urlContains("index.php?module=Home&action=index"));

        // Navigate to the Sales -> Accounts page.
        driver.findElement(By.id("grouptab_0")).click();
        driver.findElement(By.id("moduleTab_9_Accounts")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[4]/div/div[1]/h2")));

        // Find the table on the page and print the names of the first 5 odd-numbered rows of the table to the console.
        WebElement table = driver.findElement(By.xpath("/html/body/div[4]/div/div[3]/form[2]/div[3]/table"));
        System.out.println(table.findElement(By.xpath("/html/body/div[4]/div/div[3]/form[2]/div[3]/table/tbody/tr[1]/td[3]/b/a")).getText());
        System.out.println(table.findElement(By.xpath("/html/body/div[4]/div/div[3]/form[2]/div[3]/table/tbody/tr[3]/td[3]/b/a")).getText());
        System.out.println(table.findElement(By.xpath("/html/body/div[4]/div/div[3]/form[2]/div[3]/table/tbody/tr[5]/td[3]/b/a")).getText());
        System.out.println(table.findElement(By.xpath("/html/body/div[4]/div/div[3]/form[2]/div[3]/table/tbody/tr[7]/td[3]/b/a")).getText());
        System.out.println(table.findElement(By.xpath("/html/body/div[4]/div/div[3]/form[2]/div[3]/table/tbody/tr[9]/td[3]/b/a")).getText());

        // close browser
        driver.quit();

    }
}
