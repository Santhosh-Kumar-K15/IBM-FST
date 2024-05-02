import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class testNGActivity2 {
    WebDriver driver;

    @BeforeClass
    public void beforeMethod() {
        // Setup the Firefox driver(GeckoDriver)
        WebDriverManager.firefoxdriver().setup();

        // Create a new instance of the Firefox driver
        driver = new FirefoxDriver();

        // Open the browser
        driver.get("https://v1.training-support.net/selenium/target-practice");

    }

    @Test
    public void testCase1() {
        // Check the title of the page
        String title = driver.getTitle();

        //Print the title of the page
        System.out.println("Page title is: " + title);

        //Assertion for page title
        Assert.assertEquals("Target Practice", title);
    }
    @Test
    public void testCase2(){
        WebElement blackButton = driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div/div/div/div[2]/div[3]/button[3]"));

        Assert.assertEquals("green",blackButton.getText());

    }
    @Test(enabled = false)
    public  void testCase3(){
        System.out.println("this method is skipped");
    }
    @Test
    public void testCase4() throws SkipException{
        throw new SkipException("This method is skipped using Skip Exception");

    }

    @AfterClass
    public void afterMethod(){
        driver.quit();
    }
}
