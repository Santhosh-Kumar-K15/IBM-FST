import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class seleniumActivity13 {

    public static void main(String[] args) {
        // Setup the Firefox driver(GeckoDriver)
        WebDriverManager.firefoxdriver().setup();

        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();

        // Open the browser
        driver.get("https://v1.training-support.net/selenium/tables");

        // getting page's title and print it in console
        String title = driver.getTitle();
        System.out.println(title);

        WebElement table = driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div[2]/table"));

        System.out.println("No. of Rows: "+table.findElements(By.xpath("/html/body/div/div[2]/div/div[2]/div[2]/table/tbody/tr")).size());
        System.out.println("No. of Columns: "+table.findElements(By.xpath(".//tr[1]/td")).size());

        //Find and print all the cell values in the third row of the table
        System.out.println(table.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div[2]/table/tbody/tr[3]")).getText());

        //Find and print all the cell value in the second row and second column of the table
        System.out.println(table.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div[2]/table/tbody/tr[2]/td[2]")).getText());

        //close the browser
        driver.quit();

    }

}
