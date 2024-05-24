import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity7 {
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

        // Navigate to Sales -> Leads
        driver.findElement(By.id("grouptab_0")).click();
        driver.findElement(By.id("moduleTab_9_Leads")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[4]/div/div[1]/h2")));

        // In the table, find the Additional information icon at the end of the row of your newly created lead. Click it
        driver.findElement(By.xpath("/html/body/div[4]/div/div[3]/form[2]/div[3]/table/tbody/tr[1]/td[10]/span/span")).click();

        // Read the popup and print the phone number displayed in it.
        WebElement phNum = driver.findElement(By.className("phone"));
        String num = phNum.getText();
        System.out.println(phNum);

        // close browser
        driver.quit();

    }
}
