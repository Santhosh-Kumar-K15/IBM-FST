import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class seleniumActivity14 {

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

        // Find the number of rows and columns in the second table and print them.
        System.out.println("No. of Rows: "+table.findElements(By.xpath("/html/body/div/div[2]/div/div[3]/div[2]/table/tbody/tr")).size());
        System.out.println("No. of Columns: "+table.findElements(By.xpath("/html/body/div/div[2]/div/div[3]/div[2]/table/tbody/tr[1]/td")).size());

        //Find and print the cell value at the second row second column.
        System.out.println(table.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div[2]/table/tbody/tr[2]/td[2]")).getText());

        // Click the header of the first column to sort by name.
        WebElement header = driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div[2]/table/thead/tr/th[1]"));
        header.click();

        //Find and print the cell value at the second row second column again.
        System.out.println(table.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div[2]/table/tbody/tr[2]/td[2]")).getText());

        // Print the cell values of the footer
        System.out.println(table.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div[2]/table/tfoot/tr")).getText());

        //close the browser
        driver.quit();

    }

}
