package page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BookerPlusLoginPage extends BookerPlusBasePage {

    @FindBy (xpath = "//input[@name='username']")
    private WebElement userNameField;

    @FindBy (xpath = "//input[@name='password']")
    private WebElement userPasswordField;

    @FindBy(xpath = "//button[contains(@class,'btn btn-primary')]")
    private WebElement loginButton;

    @FindBy (xpath = "//a[@routerlinkactive='active']")
    private WebElement loginLink;

    public BookerPlusLoginPage (WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public void loginLinkClick() {
        loginLink.click();
    }

    public boolean isElementsVisible() {
        System.out.println("test 1");
        return
                loginButton.isDisplayed()
//                        &&
//                loginLink.isDisplayed()
                ;
    }
    public boolean isElementsEnabled() {
        System.out.println("test 2");
        return
                loginButton.isEnabled()
//                        &&loginLink.isEnabled()
                ;
    }

    public <T> T login (String userName, String userPassword){
        userNameField.sendKeys(userName);
        userPasswordField.sendKeys(userPassword);
        loginButton.click();

        if (isUrlContains("/home", 5)) {
            return (T) new BookerPlusHomePage(driver);
        }
      else {
            return (T) new BookerPlusLoginPage(driver);
        }
    }

    private boolean isUrlContains(String partUrl, int timeOutInSec) {
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSec);
        try {
            return wait.until(ExpectedConditions.urlContains(partUrl));
        }catch (TimeoutException e){
            return false;
        }}

    public boolean isPageLoaded() {
        return getCurrentUrl().toLowerCase().contains("localhost:8080/erp/")
                &&
                        getCurrentTitle().toLowerCase().contains("booker")
                ;}


}
