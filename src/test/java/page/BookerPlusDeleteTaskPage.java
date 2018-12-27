package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookerPlusDeleteTaskPage extends BookerPlusBasePage {
    @FindBy (xpath = "(//div[@class='col-sm-offset-2 col-sm-10']//button[@class='btn btn-success'])[10]")
    private WebElement deliteTaskYesButton;

    @FindBy (xpath = "(//button[@class='btn btn-danger'])[10]")//краткая форма Xpath
    private WebElement deliteTaskNoButton;




    public BookerPlusDeleteTaskPage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    public BookerPlusNewTaskEditPage deleteTaskYesButton() {
        System.out.printf("\nButton ["+deliteTaskYesButton.getText()+"]\n is enabled: "
                +deliteTaskYesButton.isEnabled()+"\n is displyed: "+deliteTaskYesButton.isDisplayed());
        System.out.printf("\nButton ["+deliteTaskNoButton.getText()+"]\n is enabled: "
                +deliteTaskNoButton.isEnabled()+"\n is displyed: "+deliteTaskNoButton.isDisplayed());

        deliteTaskYesButton.click();
        System.out.println("\nDelete task. ok");
        return new BookerPlusNewTaskEditPage(driver);
    }
}
