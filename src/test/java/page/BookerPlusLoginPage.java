package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookerPlusLoginPage extends BookerPlusBasePage {

    @FindBy (xpath = "//input[@name='username']")
    private WebElement userName;

    @FindBy (xpath = "//input[@name='password']")
    private WebElement userPasswiord;

    @FindBy (xpath = "//button[@class='btn btn-primary'")
    private WebElement loginButton;

    @FindBy (xpath = "//a[@class='active']")
    private WebElement loginLink;

    public BookerPlusLoginPage (WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }


    public boolean isPageLoaded() {
        return getCurrentUrl().toLowerCase().contains("localhost:8080/erp/")
                && getCurrentTitle().toLowerCase().contains("booker")
                ;}


}
