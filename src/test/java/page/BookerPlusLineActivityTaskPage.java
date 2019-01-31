package page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class BookerPlusLineActivityTaskPage extends BookerPlusBasePage{
    @FindBy (xpath = "//button[@class='btn btn-primary btn-sm']")
    private WebElement createNewTastButton;
    @FindBy (xpath = "//input[@id='taskCode']")
    private WebElement taskCodeTextField;
    @FindBy (xpath = "//input[@id='taskName']")
    private WebElement taskNameTextField;
    @FindBy (xpath = "//input[@id='taskDescription']")
    private WebElement taskDescriptionTextField;
    @FindBy (xpath = "//input[@id='startWeek']")
    private WebElement startDateField;
    @FindBy (xpath = "//input[@id='endWeek']")
    private WebElement finishDateField;
    @FindBy (xpath = "//button[contains(text(), 'Save')]")
    private WebElement saveButton;
    @FindBy (xpath = "//button[@class='btn btn-default']")
    private WebElement resetButton;
    @FindBy (xpath = "//*[@class='table  table-striped table-condensed table-responsive']/tbody/tr[10]/descendant::button[@title = 'testTask01']")
    private WebElement taskNameField;
    @FindBy (xpath = "//*[@class='table  table-striped table-condensed table-responsive']/tbody/tr[10]/descendant::button[@title = 'Calendar']/span")
    private WebElement scheduleTaskButtons;
    @FindBy (xpath = "//*[@class='table  table-striped table-condensed table-responsive']/tbody/tr[10]/descendant::button[@title = 'Delete task']")
    private WebElement scheduleDeliteTaskButtons;
    @FindBy (xpath = "//button[@class='btn btn-primary btn-sm']")
    private List<WebElement> scheduleButtons;
    @FindBy (xpath = "//b[contains(text(),'Training Preparation')]")
    private WebElement fieldforStartClick;

    public BookerPlusLineActivityTaskPage(WebDriver driver)    {
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isTaskNameCorect (String taskName){
        System.out.println(taskNameField.getText());
        return true;

    }
    public boolean isPageLoaded() {
        return
                getCurrentUrl().toLowerCase().contains("/linetask")
                &&
                getCurrentTitle().toLowerCase().contains("booker")
                ;}
    public BookerPlusNewTaskPage createTask(String taskCode, String taskName, String taskDescription) throws InterruptedException {
        Thread.sleep(300);
        createNewTastButton.click();
        Thread.sleep(3000);
        taskCodeTextField.click();
        taskCodeTextField.sendKeys(taskCode);
        taskNameTextField.click();
        taskNameTextField.sendKeys(taskName);
        taskDescriptionTextField.click();
        taskDescriptionTextField.sendKeys(taskDescription);
        saveButton.click();
        return new BookerPlusNewTaskPage(driver);
    }
    public BookerPlusNewTaskEditPage ScheduleButtonClick() throws InterruptedException {
        Thread.sleep(1000);
        //new task click
        scheduleTaskButtons.click();
        return new BookerPlusNewTaskEditPage(driver);
    }
    public void editScheduleTask(String taskName) {
        String s = "";
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].scrollIntoView(true);",scheduleTaskButtons);
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public BookerPlusDeleteTaskPage delitTaskButtonClick() throws InterruptedException {
        String s = "";
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].scrollIntoView(true);",scheduleDeliteTaskButtons);
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        scheduleDeliteTaskButtons.click();
        Thread.sleep(2000);
        return new BookerPlusDeleteTaskPage(driver);
    }
}
