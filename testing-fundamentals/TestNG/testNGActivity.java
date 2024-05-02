import org.testng.annotations.*;

public class testNGActivity {


    @BeforeClass (alwaysRun=true)
    public void beforeClass() {
        System.out.println("Executed before class function");
    }
    @AfterClass
    public void afterClass(){
        System.out.println("Executed after class function");

    }
    @Test (groups={"group"})
    public void test(){
        System.out.println("Executed group1");

    }
    @Test
    public void test2(){
        System.out.println("Executed test function");

    }
    @Test (groups={"group"})
    public void test3(){
        System.out.println("Executed group2");

    }
    @BeforeSuite
    public void beforeSuite(){
        System.out.println("Executed before suite function");

    }
    @AfterSuite
    public void afterSuite(){
        System.out.println("Executed after suite function");

    }
    @BeforeMethod
    public void beforeMethod(){
        System.out.println("Executed before method function");

    }
    @AfterMethod
    public void afterMethod(){
        System.out.println("Executed after method function");

    }
    @BeforeTest
    public void beforeTest(){
        System.out.println("Executed before test function");

    }
    @AfterTest
    public void afterTest(){
        System.out.println("Executed after test function");

    }
//    @BeforeGroups
//    public void beforeGroup(){
//        System.out.println("Executed before group function");
//
//    }
//    @AfterGroups
//    public void afterGroup() {
//        System.out.println("Executed after group function");
//    }

}
