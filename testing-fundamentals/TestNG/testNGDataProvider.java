import org.testng.annotations.DataProvider;


public class testNGDataProvider {
    @DataProvider(name="Authentication")
    public static Object[][] credentials() {
        return new Object[][] {
                {"Santhosh","Kumar","sandy@ibm.com","9876543210","Hi i'am sandy"},
                {"Maddy","Kumar","maddy@ibm.com","9876543211","Hi i'am Maddy"},
                {"Arul","Kumar","arul@ibm.com","9876543212","Hi i'am Arul"}
        };
    }
}
