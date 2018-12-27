package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookerPlusHomePage extends BookerPlusBasePage{

    @FindBy (xpath = "//*[@id='navbar-ex-collapse']/ul[2]/li[1]/a/b")
    private WebElement userIdField;
    @FindBy (xpath = "//*[@id='navbar-ex-collapse']/ul[2]/li[2]/a")
    private WebElement logoutLink;
    @FindBy (xpath = "//*[@id='navbar-ex-collapse']/ul[1]/li[1]/a")
    private WebElement menuItemHome;
    @FindBy (xpath = "//*[@id='navbar-ex-collapse']/ul[1]/li[2]/a")
    private WebElement menuItemMyProjects;
    @FindBy (xpath = "//*[@id='navbar-ex-collapse']/ul[1]/li[3]/a")
    private WebElement menuItemLineActivity;
    @FindBy (xpath = "//*[@id='navbar-ex-collapse']/ul[1]/li[5]/a")
    private WebElement menuItemMyTasks;
    @FindBy (xpath = "//*[@id='navbar-ex-collapse']/ul[1]/li[6]/a")
    private WebElement menuItemRequests;
    @FindBy (xpath = "//*[@id='navbar-ex-collapse']/ul[1]/li[9]/a")
    private WebElement menuItemHelp;

    public BookerPlusHomePage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver,this);
            }

    public BookerPlusLineActivityPage clickAllMenu() {
        menuItemLineActivity.click();
        System.out.println("Button LineActivity clicked");
        return new BookerPlusLineActivityPage(driver);
    }
    public boolean correctUserID(String userName) {
        return userIdField.getText().toLowerCase().contains(userName.toLowerCase());
    }
    public boolean logoutLinkAble() {
        System.out.println("LogOut button "+"\n is displayed "+logoutLink.isDisplayed()
                +"\n is enablad "+logoutLink.isEnabled());
        return logoutLink.isDisplayed() &&
                logoutLink.isEnabled();
    }
    public boolean homePageMenuTest(){
        System.out.println("Button "+ menuItemHome.getText()+"\n is displayed: "+ menuItemHome.isDisplayed()+
                "\n is enadled: "+menuItemHome.isEnabled());
        System.out.println("Button "+ menuItemMyProjects.getText()+"\n is displayed: "+ menuItemMyProjects.isDisplayed()+
                "\n is enadled: "+menuItemMyProjects.isEnabled());
        System.out.println("Button "+ menuItemLineActivity.getText()+"\n is displayed: "+ menuItemLineActivity.isDisplayed()+
                "\n is enadled: "+menuItemLineActivity.isEnabled());
        System.out.println("Button "+ menuItemMyTasks.getText()+"\n is displayed: "+ menuItemMyTasks.isDisplayed()+
                "\n is enadled: "+menuItemMyTasks.isEnabled());
        System.out.println("Button "+ menuItemRequests.getText()+"\n is displayed: "+ menuItemRequests.isDisplayed()+
                "\n is enadled: "+menuItemRequests.isEnabled());
        System.out.println("Button "+ menuItemHelp.getText()+"\n is displayed: "+ menuItemHelp.isDisplayed()+
                "\n is enadled: "+menuItemHelp.isEnabled());

        return menuItemHome.isDisplayed() && menuItemHome.isEnabled() &&
                menuItemMyProjects.isDisplayed() && menuItemMyProjects.isEnabled() &&
                menuItemLineActivity.isDisplayed() && menuItemLineActivity.isEnabled() &&
                menuItemMyTasks.isDisplayed() && menuItemMyTasks.isEnabled() &&
                menuItemRequests.isDisplayed() && menuItemRequests.isEnabled() &&
                menuItemHelp.isDisplayed() && menuItemHelp.isEnabled();
    }
}
