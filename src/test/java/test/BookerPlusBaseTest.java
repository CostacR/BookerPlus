package test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import page.BookerPlusLoginPage;

public class BookerPlusBaseTest {
    WebDriver driver;
    BookerPlusLoginPage bookerPlusLoginPage;

    @BeforeMethod
    public void beforeMethod() {
        driver = new FirefoxDriver();
        driver.get("http://localhost:8090/erp/");
        driver.manage().window().maximize();
        bookerPlusLoginPage = new BookerPlusLoginPage(driver);
    }

    @AfterMethod (alwaysRun = true)
    public void afterMethod()
            throws InterruptedException
    {
//      Thread.sleep(5000);
//      driver.quit();
    }
}

