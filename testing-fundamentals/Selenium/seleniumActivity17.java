import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class seleniumActivity17 {

    public static void main(String[] args) {
        // Setup the Firefox driver(GeckoDriver)
        WebDriverManager.firefoxdriver().setup();

        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();

        // Open the browser
        driver.get("https://v1.training-support.net/selenium/selects");

        // getting page's title and print it in console
        String title = driver.getTitle();
        System.out.println(title);

        WebElement dropDown = driver.findElement(By.xpath("//*[@id=\"single-select\"]"));
        dropDown.click();

        Select select = new Select(dropDown);

        select.selectByVisibleText("Option 2");
        dropDown.click();
        select.selectByIndex(3);
        dropDown.click();
        select.selectByValue("4");

        List<WebElement> options = select.getOptions();

        for(WebElement option : options){
            System.out.println(option.getText());
        }

        //close the browser
        driver.quit();

    }

}
