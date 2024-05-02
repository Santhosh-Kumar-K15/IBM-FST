import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class testNGActivity5 {
    WebDriver driver;

    @BeforeClass(alwaysRun = true)
    public void beforeMethod() {
        // Setup the Firefox driver(GeckoDriver)
        WebDriverManager.firefoxdriver().setup();

        // Create a new instance of the Firefox driver
        driver = new FirefoxDriver();

        // Open the browser
        driver.get("https://v1.training-support.net/selenium/target-practice");

    }
    @Test
    public void testCase(){
        // Check the title of the page
        String title = driver.getTitle();

        //Print the title of the page
        System.out.println("Page title is: " + title);

        //Assertion for page title
        Assert.assertEquals("Target Practice", title);

    }
    @Test (groups = {"HeaderTests"})
    public void testCase1(){
        WebElement thirdHeader = driver.findElement(By.xpath("//*[@id=\"third-header\"]"));
        String tH = thirdHeader.getText();
        Assert.assertEquals("Third header", tH);
    }
    @Test (groups = {"HeaderTests"})
    public void testCase2(){
        WebElement fifthHeader = driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div/div/div/div[1]/h5"));
        String tH = fifthHeader.getCssValue("color");
        Assert.assertEquals("rgb(33, 186, 69)", tH);
    }
    @Test (groups = {"ButtonTests"})
    public void testCase3(){
        WebElement oliveButton = driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div/div/div/div[2]/div[1]/button[4]"));
        String oB = oliveButton.getText();
        Assert.assertEquals("Olive", oB);
    }
    @Test(groups = {"ButtonTests"})
    public void testCase4(){
        WebElement brownButton = driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div/div/div/div[2]/div[3]/button[1]"));
        String bB = brownButton.getText();
        Assert.assertEquals("Brown", bB);
    }
    @AfterClass
    public void afterMethod(){
        driver.quit();
    }
}
