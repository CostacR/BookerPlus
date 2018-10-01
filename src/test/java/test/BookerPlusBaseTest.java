package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BookerPlusBaseTest {
    WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {
        driver = new FirefoxDriver();
        driver.get("http://localhost:8080/erp/");
    }

    @AfterMethod (alwaysRun = true)
    public void afterMethod(){
        driver.quit();
    }
}

