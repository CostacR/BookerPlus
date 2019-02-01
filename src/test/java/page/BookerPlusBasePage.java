package page;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.logging.SocketHandler;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;

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

    protected void logWrire(String text)  {
        Date date = new Date();
         String stringLog = text+" "+date.toString();
         try (FileOutputStream fos
                      = new FileOutputStream("C://tmct//notes.txt", true)){
            byte[]buffer = stringLog.getBytes();
            fos.write(buffer, 0 , buffer.length );
            stringLog = "\n";
         }
         catch (IOException ex){
             System.out.println(ex.getMessage());
         }

        System.out.println("File has been writen.");
    }
}
