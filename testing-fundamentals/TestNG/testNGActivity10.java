import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.*;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class testNGActivity10 {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void beforeClass() {
        // Setup the Firefox driver(GeckoDriver)
        WebDriverManager.firefoxdriver().setup();
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "NULL");

        // Create a new instance of the Firefox driver
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        // Open the browser
        driver.get("https://v1.training-support.net/selenium/simple-form");

    }
    public  static List<List<Object>> readExcel(String filePath){
        List<List<Object>> data = new ArrayList<>();
        try{
            // Read the file as a stream
            FileInputStream file = new FileInputStream(filePath);

            // Create the workbook
            XSSFWorkbook workbook = new XSSFWorkbook(file);

            // Get first sheet from that workbook
            XSSFSheet sheet = workbook.getSheetAt(0);

            // Iterate through all the rows one by one
            for(Row row: sheet) {
                List<Object> rowData = new ArrayList<>();
                // Iterate over all the cells one by one
                for(Cell cell: row){
                    if(cell != null){
                        switch (cell.getCellType()){
                            case STRING -> rowData.add(cell.getStringCellValue());
                            case NUMERIC -> rowData.add(cell.getNumericCellValue());
                            case BOOLEAN -> rowData.add(cell.getBooleanCellValue());

                        }
                    }
                }
                data.add(rowData);
            }
            file.close();
            workbook.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }

    @DataProvider(name="Registration")
    public static Object[][] signUpInfo(){
        String filePath = "C:\\Users\\SanthoshKumarK\\IdeaProjects\\selenium\\src\\test\\java\\excelData.xlsx";
        List<List<Object>> data = readExcel(filePath);
        return new Object[][] {
                {data.get(1)},
                {data.get(2)},
                {data.get(3)}
        };
    }
    @Test(dataProvider = "Registration")
    public void registrationTest(List<Object> rows){
        WebElement firstNameField = driver.findElement(By.id("firstName"));
        WebElement lastNameField = driver.findElement(By.id("lastName"));
        WebElement emailField = driver.findElement(By.id("email"));
        WebElement phoneNumberField = driver.findElement(By.id("number"));

        // Clear the fields
        firstNameField.clear();
        lastNameField.clear();
        emailField.clear();
        phoneNumberField.clear();

        // Enter the data
        firstNameField.sendKeys(rows.get(1).toString());
        lastNameField.sendKeys(rows.get(2).toString());
        emailField.sendKeys(rows.get(3).toString());
        phoneNumberField.sendKeys(rows.get(4).toString());

        driver.findElement(By.cssSelector("input.green")).click();

        wait.until(ExpectedConditions.alertIsPresent());

        Alert message = driver.switchTo().alert();

        System.out.println("Alert Message: "+ message.getText());
        Reporter.log("Alert Message: "+ message.getText());
        message.accept();

        driver.navigate().refresh();
    }


    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}
