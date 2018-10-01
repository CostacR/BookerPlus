package page;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BookerPlusBasePage {
    protected WebDriver driver;

    protected WebElement waitUntilElementVisible (WebElement webElement, int timeOutInSec){ //ожидает когда вебэлемент будет видимым, после этого возвращает элемент
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSec);
        return wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    protected void assertElementIsVisible (WebElement webElement, int timeOutInSec, String message){
        try {
            waitUntilElementVisible(webElement, timeOutInSec);
        }catch (TimeoutException e){
            throw new AssertionError(message);
        }
    }

    protected String getCurrentTitle() {
        return driver.getTitle();
    }

    protected String getCurrentUrl (){
        return driver.getCurrentUrl();
    }


}
