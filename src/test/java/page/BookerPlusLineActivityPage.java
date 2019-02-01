package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookerPlusLineActivityPage extends BookerPlusBasePage{

    @FindBy (xpath = "//tr/td/a")
    private WebElement lineActivityProjectField;

    public BookerPlusLineActivityPage(WebDriver driver) {

        this.driver=driver;
        PageFactory.initElements(driver, this);
    }
    public boolean isPageLoaded() {
        return getCurrentUrl().toLowerCase().contains("/lineactivity")
                &&
                getCurrentTitle().toLowerCase().contains("booker")
                ;}
    public BookerPlusLineActivityTaskPage clickTask() throws InterruptedException {
        Thread.sleep(1500);
        System.out.println("+1500");
        lineActivityProjectField.click();
        return new BookerPlusLineActivityTaskPage(driver);
    }
}
