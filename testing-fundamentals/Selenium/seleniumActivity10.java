import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class seleniumActivity10 {
    public static void main(String[] args) {
        // Setup the Firefox driver(GeckoDriver)
        WebDriverManager.firefoxdriver().setup();

        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();

        // Open the browser
        driver.get("https://v1.training-support.net/selenium/dynamic-controls");

        // getting page's title and print it in console
        String title = driver.getTitle();
        System.out.println(title);

        // check if the "check box" input element is visible or not
        WebElement textBox = driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/div[1]/input"));
        System.out.println("Is the element visible "+textBox.isDisplayed());

        // click the "remove button" check if it is visible or not
        WebElement removeButton = driver.findElement(By.xpath("//*[@id=\"toggleCheckbox\"]"));
        removeButton.click();
        System.out.println("Is the element visible "+textBox.isDisplayed());

        //close the browser
        driver.quit();

    }
}
