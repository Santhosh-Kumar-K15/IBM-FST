package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginSteps {
    WebDriver driver;
    WebDriverWait wait;

    @Given("^User is on Login page2a$")
    public void googlePage() throws Throwable{
        // Setup the Firefox driver(GeckoDriver)
        WebDriverManager.firefoxdriver().setup();
        // Create a new instance of the Firefox driver
        driver = new FirefoxDriver();
        // Create wait object
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Open the browser
        driver.get("https://v1.training-support.net/selenium/login-form");


    }
    @When("User enters usernames {string} and passwords {string}")
//    @When("^User enters username and password$")
    public void userEntersUsernamePassword(String username,String password) throws Throwable{
        WebElement userName = driver.findElement(By.id("username"));
        userName.sendKeys(username);
        WebElement Password = driver.findElement(By.id("password"));
        Password.sendKeys(password);

        driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div/div/button")).click();
    }
    @Then("^Read the page title and confirmation messages2$")
    public void searchResults() throws Throwable{
        String title = driver.getTitle();
        System.out.println(title);
        WebElement message = driver.findElement(By.xpath("//*[@id=\"action-confirmation\"]"));
        System.out.println(message.getText());
    }
    @And("^Close the Browsers2a$")
    public void closeBrowser() throws Throwable {
        driver.quit();

    }
}
