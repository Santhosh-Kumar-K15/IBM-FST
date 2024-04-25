import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class seleniumActivity7 {
    public static void main(String[] args) {
        // Setup the Firefox driver(GeckoDriver)
        WebDriverManager.firefoxdriver().setup();

        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();

        // Open the browser
        driver.get("https://v1.training-support.net/selenium/drag-drop");

        // getting page's title and print it in console
        String title = driver.getTitle();
        System.out.println(title);

        Actions builder = new Actions(driver);

        //Find the ball and simulate a click and drag to move it into "DropZone 1"
        WebElement dragSource = driver.findElement(By.id("draggable"));
        WebElement dragDest = driver.findElement(By.id("droppable"));
        builder.dragAndDrop(dragSource,dragDest).perform();

        // validation
        String response = dragDest.getText();
        System.out.println(response);

        // drag and drop on dropzone 2
        WebElement dragSource1 = driver.findElement(By.id("draggable"));
        WebElement dragDest1 = driver.findElement(By.id("dropzone2"));
        builder.dragAndDrop(dragSource1,dragDest1).perform();

        // validation
        String response1 = dragDest1.getText();
        System.out.println(response1);

        //close the browser
        driver.quit();

    }
}
