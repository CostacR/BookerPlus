package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookerPlusCreateNewLineActivityTaskPage extends BookerPlusBasePage{



    public BookerPlusCreateNewLineActivityTaskPage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver, this);

    }


}
