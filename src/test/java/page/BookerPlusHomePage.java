package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

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
    @FindBy (xpath = "//a[@class='active']")
    private WebElement activePageMarker;
    @FindBy (xpath = "//tr//td/a[contains(text(), 'Implementation')]")//сделать универсальным!!!
    private List<WebElement> taskNameLinks;
    @FindBy (xpath = "(//tr//td/a[contains(text(), 'Implementation')])[3]")
    private WebElement taskNameLink;
    @FindBy (xpath = "//ul/li/a/span[contains(text(), 'Open')]")
    private WebElement openButton;
    @FindBy (xpath = "//ul/li/a/span[contains(text(), 'In process')]")
    private WebElement inProgressButton;
    @FindBy (xpath = "//ul/li/a/span[contains(text(), 'Completed')]")
    private WebElement completedButton;
    @FindBy (xpath = "//ul/li/a/span[contains(text(), 'Conflicts')]")
    private WebElement conflictsButton;
    @FindBy (xpath = "//ul/li/a/span")
    private List<WebElement> menuButtons;



    @FindBy (xpath = "(//tr//td//a[contains(text(), 'Customer Master Data: Unified Front-end')])[17]")
    private WebElement projectNameButton;


    public BookerPlusHomePage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver,this);
            }

    public BookerPlusGeneralInformationPage searchButtonsMenu() throws InterruptedException {
        completedButton.click();
        Thread.sleep(1500);
        projectNameButton.click();
        Thread.sleep(1000);

//        taskNameLink.click();
        return new BookerPlusGeneralInformationPage(driver);
    }

    public BookerPlusLineActivityPage clickAllMenu() {
        menuItemLineActivity.click();
        System.out.println("Button LineActivity clicked");
        return new BookerPlusLineActivityPage(driver);
    }
//    public BookerPlusScheduleForTaskPage searchButtonsMenu() throws InterruptedException {
//        completedButton.click();
//        Thread.sleep(1500);
//        projectNameButton.click();
////        taskNameLink.click();
//        return new BookerPlusScheduleForTaskPage(driver);

    public boolean correctUserID(String userName) {
        return userIdField.getText().toLowerCase().contains(userName.toLowerCase());
    }
    public boolean logoutLinkAble() {
//        System.out.println("LogOut button "+"\n is displayed "+logoutLink.isDisplayed()
//                +"\n is enablad "+logoutLink.isEnabled());
        return logoutLink.isDisplayed() &&
                logoutLink.isEnabled();
    }
    public void homePageMenuClick() {

    }
    public boolean homePageMenuTest() {
        return true;}
    public boolean correctActivePageReview() {
        System.out.println(activePageMarker.getText());//home
        System.out.println(activePageMarker.isEnabled() && activePageMarker.isDisplayed());//true
        System.out.println(getCurrentUrl());//url
        System.out.println(getCurrentUrl().contains(activePageMarker.getText().substring(activePageMarker.getText().lastIndexOf(' ')
            +1).toLowerCase()));
    return  getCurrentUrl().contains(activePageMarker.getText().substring(activePageMarker.getText().lastIndexOf(' ')
            +1).toLowerCase()) && activePageMarker.isEnabled() && activePageMarker.isDisplayed();
    }
    public BookerPlusSearchResultPage myProjectsClick() {
        menuItemMyProjects.click();
        return new BookerPlusSearchResultPage(driver);
    }
    public boolean openRequestMenuReview() {
        return true;
    }
    public BookerPlusProjectPage selectProject() {

        return new BookerPlusProjectPage(driver);
    }
    public void myTasksPageClick() {
        menuItemMyTasks.click();
    }
    public boolean homePageMenuReview(){
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
    public BookerPlusScheduleForTaskPage searchInProjectsButtonsMenu() throws InterruptedException {
        for (WebElement menuButton : menuButtons){
            menuButton.click();
//            openProjectByTaskName();
        }
        return new BookerPlusScheduleForTaskPage(driver);
    }

    public BookerPlusScheduleForTaskPage searchTaskButtonsMenu() {
        return new BookerPlusScheduleForTaskPage(driver);
    }


//    public boolean openProjectByTaskName() throws InterruptedException {
//        Thread.sleep(500);
//        for (WebElement taskNameLink : taskNameLinks) {
//            taskNameLink.click();
//            return taskNameLink.isDisplayed() && taskNameLink.isEnabled();
//    }  return false;
//    }
}
