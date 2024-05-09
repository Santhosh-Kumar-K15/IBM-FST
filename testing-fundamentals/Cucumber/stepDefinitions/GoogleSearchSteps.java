package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.logging.LogManager;

public class GoogleSearchSteps {
    WebDriver driver;
    WebDriverWait wait;

    @Given("^User is on Google Home Page$")
    public void googlePage() throws Throwable{
        // Setup the Firefox driver(GeckoDriver)
        WebDriverManager.firefoxdriver().setup();
        // Create a new instance of the Firefox driver
        driver = new FirefoxDriver();
        // Create wait object
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Open the browser
        driver.get("https://www.google.com");


    }
    @When("^User types in Cheese and hits ENTER$")
    public void userEntersCheese() throws Throwable{
        WebElement searchBox = driver.findElement(By.id("APjFqb"));
        searchBox.sendKeys("cheese");
        searchBox.sendKeys(Keys.ENTER);

//        driver.findElement(By.name("q")).sendKeys("Cheese", Keys.RETURN);
    }
    @Then("^Show how many search results were shown$")
    public void searchResults() throws Throwable{
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("result-stats")));
        WebElement resultCount = driver.findElement(By.id("result-stats"));
        String count = resultCount.getText();
        System.out.println(count);
    }
    @And("^Close the browser$")
    public void closeBrowser() throws Throwable {
        driver.close();

    }
}

