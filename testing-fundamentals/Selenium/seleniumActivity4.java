import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.awt.*;

public class seleniumActivity4 {

    public static void main(String[] args) {
        // Setup the Firefox driver(GeckoDriver)
        WebDriverManager.firefoxdriver().setup();

        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();

        // Open the browser
        driver.get("https://v1.training-support.net/selenium/target-practice");

        // getting page's title and print it in console
        String title = driver.getTitle();
        System.out.println(title);

        WebElement thirdHeader = driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div/div/div/div[1]/h3"));
        System.out.println(thirdHeader.getText());

        WebElement fifthHeader = driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div/div/div/div[1]/h5"));
        String Color=fifthHeader.getCssValue("color");
        System.out.println(Color);

//        String red = Color.substring(4,5);
//        String green = Color.substring(8,10);
//        String blue = Color.substring(8,10);
//
//        Color color = new Color(red,green,blue);

        WebElement violetButton = driver.findElement(By.cssSelector(".violet"));
        System.out.println(violetButton.getAttribute("class"));

        WebElement greyButton = driver.findElement(By.cssSelector(".grey"));
        System.out.println(greyButton.getText());

        //close the browser
        driver.quit();

    }
}
