package page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import java.util.List;

public class BookerPlusTaskEditPage extends BookerPlusBasePage{
    @FindBy (xpath = "//tbody//tr[3]//td[3]")
    private WebElement startWeek2018SelectButton;

    @FindBy (xpath = "//tbody//tr[3]//td[4]")
    private WebElement finishWeek2018SelectButton;

    @FindBy (xpath = "//tbody//tr[3]//td[4]")
    private WebElement startWeek2019SelectButton;

    @FindBy (xpath = "//tbody//tr[3]//td[7]")
    private WebElement finishWeek2019SelectButton;

    @FindBy (xpath = "//*[@id='schedule']/tbody/tr[2]/td[1]/div/button[1]")
    private WebElement editResourceButton;

    @FindBy (xpath = "//input[@id='scheduleHour']")
    private WebElement setHourInputField;

    @FindBy (xpath = "//button[contains(text(),'Add')]")
    private WebElement addButton;

    @FindBy (xpath = "//span[@class='btn btn-warning btn-sm']")
    private WebElement clearHoursButton;

    @FindBy (xpath = "//span[@class='btn btn-danger btn-sm']")
    private WebElement cancelButton;

    @FindBy(xpath = "//button[contains(text(),'all changes')]")
    private WebElement saveAllChanges2018Button;

    @FindBy(xpath = "//button[contains(text(),'all changes')]")
    private WebElement saveAllChanges2019Button;

    @FindBy(xpath = "//tr[@class='total']//td[5]")
    private WebElement startWeekSelectSumField;

    @FindBy (xpath = "//*[@id='schedule']/thead/tr/th[6]/text()")
    private WebElement startRangeWeek2019Year;

    @FindBy (xpath = "//*[@id='schedule']/thead/tr/th[16]/text()")
    private WebElement endRangeWeek2019Year;

    @FindBy(xpath = "//tr//th[5]")
    private WebElement startWeekField;

    @FindBy(xpath = "//*[@id='schedule']/tbody/tr[2]/td[6]")
    private WebElement startWeekAvailableHours;

    @FindBy(xpath = "//tr[@class='total']//td[15]")
    private WebElement finishWeekSelectField;

    @FindBy (xpath = "//*[@id='schedule']/tbody/tr[3]/td[1]")
    private WebElement lastWeekPreviousYearField;

    @FindBy(xpath = "//tr//th[16]")
    private WebElement finishWeekField;

    @FindBy(xpath = "//tr[@class='firstline']//td[11]")
    private WebElement finishWeekAvailableHours;

    @FindBy (xpath = "//a[@routerlink='/lineactivity']")
    private WebElement lineActivityUpperMenuButton;

    @FindBy (xpath = "(//div[@class='col-sm-offset-2 col-sm-10']//button[@class='btn btn-success'])[10]")
    private WebElement scheduleDeliteTaskButtons;

    @FindBy (xpath = "//div[contains(@class,'modal fade in')]//button[contains(@type,'button')][contains(text(),\"Yes, I'm sure\")]")
    private WebElement yesImSureButton;

    @FindBy (xpath = "//*[@id='schedule']/tbody/tr[3]/td/div/div")
    private List<WebElement> sumHoursResults;

    @FindBy (xpath = "//*[@id='schedule']/tbody/tr[3]/td[3]")
    private WebElement totalHours;

    @FindBy (xpath = "//*[@id='navbar-ex-collapse']/ul[1]/li[3]/a")
    private WebElement lineActivityMenuButton;

    @FindBy (xpath = "//*[@id='scheduleHour']")
    private WebElement setHoursMenuHourTextField;

    @FindBy (xpath = "//*[@id='startWeek']")
    private WebElement setHoursMenuStartTextField;
    @FindBy (xpath = "(//button[@class='btn btn-default']//i[@class='glyphicon glyphicon-calendar'])[1]")
    private WebElement setHoursMenuStartCalendarField;
    @FindBy (xpath = "//*[@id='endWeek']")
    private WebElement setHoursMenuFinishTextField;
    @FindBy (xpath = "(//button[@class='btn btn-default']//i[@class='glyphicon glyphicon-calendar'])[2]")
    private WebElement setHoursMenuFinishCalendarField;
    @FindBy(xpath = "(//*[@type='radio'])[1]")
    private WebElement newResourcesRadioButton;
    @FindBy(xpath = "(//*[@type='radio'])[1]")
    private WebElement emptyHoursRadioButton;
    @FindBy(xpath = "(//*[@type='radio'])[2]")
    private WebElement updateResourcesRadioButton;
    @FindBy (xpath = "(//div[@class='form-group']/button[@class='btn btn-success btn-sm' and contains(text(), 'Add')])[1]")
    private WebElement addButtonSetHoursMenu;
    @FindBy (xpath = "(//div[@class='form-group']/button[@class='btn btn-danger btn-sm' and contains(text(), 'Cancel')])[1]")
    private WebElement cancelButtonSetHoursMenu;
    @FindBy (xpath = "//div[@class='form-group']/button[@class='btn btn-primary btn-sm' and contains(text(), 'Clean')]")
    private WebElement cleanHoursButtonSetHoursMenu;
    @FindBy(xpath = "//div[@class='btn-group']//button[contains(text(), 'Set hours')]")
    private WebElement setHourButton;
    @FindBy (xpath = "//div[@class='btn-group']//button[contains(text(), 'Delete plans without hours')]")
    private WebElement deletePlansWithoutPlansButton;

    @FindBy(xpath = "//select[@id='selectedResource']")
    private WebElement selectResourceDropMenu;
    @FindBy(xpath = "//option[@value='1: Object']")
    private WebElement selectResourceDropMenuFirstObject;
    @FindBy(xpath = "//option[@value='2: Object']")
    private WebElement selectResourceDropMenuSecondObject;
    @FindBy(xpath = "//option[@value='0: Object']")
    private WebElement selectResourceDropAllObjects;
//    @FindBy (xpath = "//div[@class='form-group']")
//    private WebElement yesImSureButton;

    //*[@id="schedule"]/tbody/tr[1]/td[6] //для проверок суммы часов выделенных на ресурсы
    //*[@id="schedule"]/tbody/tr[2]/td[7]
    //*[@id="schedule"]/tbody/tr[3]/td[5]/div[1]/div

    public BookerPlusTaskEditPage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }
    int availableHours2018;

    public void set2018HoursWeeks(){

        startWeek2018SelectButton.click();
        finishWeek2018SelectButton.click();
        setHourInputField.sendKeys("10");
        addButton.click();
        System.out.println("hours added");
    }
    public void set2019HoursWeeks() throws InterruptedException {
//        editResourceButton.click(); //удаляет ресурс из первой строки
        Thread.sleep(500);
        startWeek2019SelectButton.click();
        finishWeek2019SelectButton.click();
        setHourInputField.sendKeys("15");
        addButton.click();
        System.out.println("hours added");
      }
    public void saveAllChanges2018Click() throws InterruptedException {
        Thread.sleep(2000);
        saveAllChanges2018Button.click();
    }
    public void saveAllChanges2019Click() throws InterruptedException {
        Thread.sleep(2000);
        saveAllChanges2019Button.click();
    }
    public void backPage() throws InterruptedException {
        Thread.sleep(500);
        lineActivityUpperMenuButton.click();
    }
    public void delitTaskButtonClick() throws InterruptedException {
    scheduleDeliteTaskButtons.click();
    Thread.sleep(2000);

    }
    public void testLastPreviousWeekYear(int previousWeekYear, int lastWeekYear) {
        System.out.println("Previus week hour previous Week "+previousWeekYear+". \n "+lastWeekYear);
    }
    public boolean correctSumHoursTest(){
        int startNumHours = new Integer(startWeekSelectSumField.getText());
        int availableNumHours = new Integer(startWeekAvailableHours.getText());
        availableHours2018 = availableNumHours;
        System.out.println("Last week hour: "+ new Integer(lastWeekPreviousYearField.getText()));
        System.out.println(startNumHours - availableNumHours);
        if (startNumHours - availableNumHours==10){
            System.out.println("true");
            return true;
        } else {
            System.out.println("false");
            return false;
        }
    }
    public boolean sumHoursAddTest() {//проверка суммы часов выделенной на ресурс
        int sumIntegerHoursResult=0;
        for (WebElement setHoursResult : sumHoursResults) {
            sumIntegerHoursResult = sumIntegerHoursResult+new Integer(setHoursResult.getText());

        }
        if (new Integer(totalHours.getText().substring(0, totalHours.getText().length()-1)) == sumIntegerHoursResult){
            return true;
        }else {
            return false;
        }
    }
    public void setNewResourcesButtonClick() throws InterruptedException {
        setHourButton.click();
        setHoursMenuHourTextField.sendKeys("10");
        setHoursMenuStartTextField.sendKeys("28.01.2019");
        setHoursMenuFinishTextField.sendKeys("24.02.2019");
        System.out.println("Add button: \nis enabled: "+addButtonSetHoursMenu.isEnabled()
                +"\n is displayed:"+addButtonSetHoursMenu.isDisplayed());
        Assert.assertTrue(addButtonSetHoursMenu.isEnabled() && addButtonSetHoursMenu.isDisplayed());
        newResourcesRadioButton.click();
        Thread.sleep(1500);
        addButtonSetHoursMenu.click();
    }
    public void setEmptyHoursButtonClick() throws InterruptedException {
        setHourButton.click();
        setHoursMenuHourTextField.sendKeys("8");
        setHoursMenuStartTextField.sendKeys("28.01.2019");
        setHoursMenuFinishTextField.sendKeys("28.03.2019");
        System.out.println("Add button: \nis enabled: "+addButtonSetHoursMenu.isEnabled()
                +"\n is displayed:"+addButtonSetHoursMenu.isDisplayed());
        Assert.assertTrue(addButtonSetHoursMenu.isEnabled() && addButtonSetHoursMenu.isDisplayed());
        emptyHoursRadioButton.click();
        Thread.sleep(2000);
        addButtonSetHoursMenu.click();
    }
    public void setUpdateResourcesButtonClick() throws InterruptedException {
        setHourButton.click();
        setHoursMenuHourTextField.sendKeys("7");
        setHoursMenuStartTextField.sendKeys("05.02.2019");
        setHoursMenuFinishTextField.sendKeys("25.02.2019");
        System.out.println("Add button: \nis enabled: "+addButtonSetHoursMenu.isEnabled()
                +"\n is displayed:"+addButtonSetHoursMenu.isDisplayed());
        Assert.assertTrue(addButtonSetHoursMenu.isEnabled() && addButtonSetHoursMenu.isDisplayed());
        updateResourcesRadioButton.click();
        Thread.sleep(1500);
        addButtonSetHoursMenu.click();
    }
    public void setCleanHoursButtonClick() throws InterruptedException {
        setHourButton.click();
        Thread.sleep(300);
        setHoursMenuHourTextField.sendKeys("7");
        setHoursMenuStartTextField.sendKeys("29.01.2019");
        setHoursMenuFinishTextField.sendKeys("15.02.2019");
        System.out.println("Add button: \nis enabled: "+addButtonSetHoursMenu.isEnabled()
                +"\n is displayed:"+addButtonSetHoursMenu.isDisplayed());
        Assert.assertTrue(addButtonSetHoursMenu.isEnabled() && addButtonSetHoursMenu.isDisplayed());
        cleanHoursButtonSetHoursMenu.click();
        Thread.sleep(1500);
    }
    public void setCancelButtonClick() throws InterruptedException {
        setHourButton.click();
        Thread.sleep(1500);
        cancelButtonSetHoursMenu.click();
        Thread.sleep(500);
        deletePlansWithoutPlansButton.click();
    }

    public void deleteTaskWithoutPlans (){
        deletePlansWithoutPlansButton.click();
    }
    public void addOneResources() throws InterruptedException {
        selectResourceDropMenu.click();
        selectResourceDropMenuFirstObject.click();
        System.out.println("One resource add & delete");
        Thread.sleep(1000);
        deleteTaskWithoutPlans();
    }
    public void addAllResources() throws InterruptedException {
        selectResourceDropMenu.click();
        selectResourceDropAllObjects.click();
        System.out.println("All resources add & delete");
        Thread.sleep(1000);
        deleteTaskWithoutPlans();
    }

    public void addSomeResourcesWithPlans() throws InterruptedException {
        selectResourceDropMenu.click();
        selectResourceDropMenuFirstObject.click();
        selectResourceDropMenuSecondObject.click();
        set2019HoursWeeks();
        System.out.println("Some resources add & delete");
        Thread.sleep(500);
        deleteTaskWithoutPlans();
        saveAllChanges2019Click();
    }

    public void sumTimeTesting() {
    }
}
