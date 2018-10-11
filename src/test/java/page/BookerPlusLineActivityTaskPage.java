package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookerPlusLineActivityTaskPage extends BookerPlusBasePage{
    @FindBy (xpath = "//button[@class='btn btn-primary btn-sm']")
    private WebElement createNewTastButton;
    @FindBy (xpath = "//input[@id='taskCode']")
    private WebElement taskCodeField;
    @FindBy (xpath = "//input[@id='taskName']")
    private WebElement taskNameField;
    @FindBy (xpath = "//input[@id='taskDescription']")
    private WebElement taskDescriptionField;
    @FindBy (xpath = "//input[@id='startWeek']")
    private WebElement startDateField;
    @FindBy (xpath = "//input[@id='endWeek']")
    private WebElement finishDateField;
    @FindBy (xpath = "//button[contains(text(), 'Save')]")
    private WebElement saveButton;
    @FindBy (xpath = "//button[@class='btn btn-default']")
    private WebElement resetButton;
    @FindBy (xpath = "//button[@class='btn btn-primary btn-sm']")
    //div[contains(@class,'col-md-12')]//router-outlet
    //button[@class='btn btn-primary btn-sm']
    private WebElement scheduleTaskButton;

    public BookerPlusLineActivityTaskPage(WebDriver driver)    {
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isPageLoaded() {
        return
                getCurrentUrl().toLowerCase().contains("/linetask")
                &&
                getCurrentTitle().toLowerCase().contains("booker")
                ;}
    public BookerPlusNewTaskPage createTask(String taskCode, String taskName, String taskDescription) throws InterruptedException {
        createNewTastButton.click();
        Thread.sleep(3000);
        taskCodeField.click();
        taskCodeField.sendKeys(taskCode);
        taskNameField.click();
        taskNameField.sendKeys(taskName);
        taskDescriptionField.click();
        taskDescriptionField.sendKeys(taskDescription);

        saveButton.click();
        return new BookerPlusNewTaskPage(driver);
    }

    public void editScheduleTask() {
        System.out.println(scheduleTaskButton.getText());
    }
}
