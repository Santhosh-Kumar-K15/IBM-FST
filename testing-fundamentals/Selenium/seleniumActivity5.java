import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class seleniumActivity5 {

    public static void main(String[] args) {
        // Setup the Firefox driver(GeckoDriver)
        WebDriverManager.firefoxdriver().setup();

        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();

        // Open the browser
        driver.get("https://v1.training-support.net/selenium/input-events");

        // getting page's title and print it in console
        String title = driver.getTitle();
        System.out.println(title);


        WebElement cube = driver.findElement(By.xpath("//*[@id=\"D3Cube\"]"));
        cube.click();
        WebElement click = driver.findElement(By.className("active"));
        System.out.println(click.getText());

        Actions actions = new Actions(driver);
        WebElement cube1 = driver.findElement(By.xpath("//*[@id=\"D3Cube\"]"));
        actions.doubleClick(cube1).perform();
        WebElement click1 = driver.findElement(By.className("active"));
        System.out.println(click1.getText());

        WebElement cube2 = driver.findElement(By.xpath("//*[@id=\"D3Cube\"]"));
        actions.contextClick(cube2).perform();
        WebElement click2 = driver.findElement(By.className("active"));
        System.out.println(click2.getText());

        //close the browser
        //driver.quit();

    }

}
