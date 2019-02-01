package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class BookerPlusProjectPage  extends BookerPlusBasePage{

    @FindBy (xpath = "//tr/td//h5")
    private List<WebElement> taskListElements;

    public BookerPlusProjectPage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    public void generalInformationTaskListReview() {
        for (WebElement taskListElement : taskListElements) {
            System.out.println(taskListElement.getText());
        }
    }
    public void generalInformationReview() {

    }


}
