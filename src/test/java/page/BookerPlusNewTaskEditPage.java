package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookerPlusNewTaskEditPage extends BookerPlusBasePage{

    @FindBy(xpath = "//span[contains(text(),'plans)')]")
    private WebElement numberPlansTask;
    @FindBy(xpath = "//button[@class='btn btn-success btn-sm dropdown-toggle']")
    private WebElement yearSelectDropMenu;
    @FindBy(xpath = "//button[@title='Tasks']")
    private WebElement taskListButton;
    @FindBy(xpath = "//button[@type='button'][contains(text(),'Cancel')]")
    private WebElement cancelButton;
    @FindBy(xpath = "//i[@class='glyphicon glyphicon-plus']/ancestor-or-self::button")
    private WebElement selectResourceButton;
    @FindBy(xpath = "//div[@class='btn-group']//*[contains(text(),'Set hours')]")
    private WebElement setHourButton;
    @FindBy(xpath = "//button[contains(text(),'Delete plans without hours')][@class='btn btn-default btn-sm']")
    private WebElement delitePlansWithoutHoursButton;
    @FindBy(xpath = "//button[contains(text(), 'Options')]")
    private WebElement optionsButton;
    @FindBy(xpath = "//select[@id='selectedResource']")
    private WebElement selectResourceDropMenu;
    @FindBy(xpath = "//tr[@class='total']//td[4]")
    private WebElement startWeekSelectField;
    @FindBy(xpath = "//tr[@class='total']//td[15]")
    private WebElement finishWeekSelectField;
    @FindBy(xpath = "//tr//th[5]")
    private WebElement startWeekField;
    @FindBy(xpath = "//tr//th[16]")
    private WebElement finishWeekField;
    @FindBy(xpath = "//option[@value='1: Object']")
    private WebElement selectResourceDropMenuFirstObject;
    @FindBy(xpath = "(//div[@class='btn-group']//a[contains(text(), '')])[1]")
    private WebElement years2019SetDropMenu;
    @FindBy(xpath = "(//div[@class='btn-group']//a[contains(text(), '')])[2]")
    private WebElement years2020SetDropMenu;

    public BookerPlusNewTaskEditPage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }
    public BookerPlusTaskEditPage add2019AndEditTask() throws InterruptedException {
        Thread.sleep(300);
        selectResourceDropMenu.click();
        selectResourceDropMenuFirstObject.click();
        System.out.println("Selected resources: "+selectResourceDropMenuFirstObject.getText());
        return new BookerPlusTaskEditPage(driver);
    }
    public void setYearSelectDropMenuClickable() throws InterruptedException {
        yearSelectDropMenu.click();
        System.out.println("DropMenu Year. Ok");
        Thread.sleep(500);
        years2020SetDropMenu.click();
    }
    public boolean isMenuButtonAble() {
        System.out.println("button menu test");
        System.out.println("Button ["+yearSelectDropMenu.getText()+"] \n is enabled "+ yearSelectDropMenu.isEnabled()
                +"\n is displaeyd "+yearSelectDropMenu.isDisplayed());

        System.out.println("Button ["+taskListButton.getText()+"] \n is enabled "+ taskListButton.isEnabled()
                +"\n is displaeyd "+taskListButton.isDisplayed());
        System.out.println("Button ["+cancelButton.getText()+"] \n is enabled "+ cancelButton.isEnabled()
                +"\n is displaeyd "+cancelButton.isDisplayed());
        System.out.println("Button ["+selectResourceButton.getText()+"] \n is enabled "+ selectResourceButton.isEnabled()
                +"\n is displaeyd "+selectResourceButton.isDisplayed());
        System.out.println("Button ["+setHourButton.getText()+"] \n is enabled "+ setHourButton.isEnabled()
                +"\n is displaeyd "+setHourButton.isDisplayed());
        System.out.println("Button ["+delitePlansWithoutHoursButton.getText()+"] \n is enabled "+ delitePlansWithoutHoursButton.isEnabled()
                +"\n is displaeyd "+delitePlansWithoutHoursButton.isDisplayed());

        System.out.println("Button ["+optionsButton.getText()
                +"] \n is enabled "
                + optionsButton.isEnabled()
                +"\n is displaeyd "
                +optionsButton.isDisplayed());

        return yearSelectDropMenu.isEnabled() && yearSelectDropMenu.isDisplayed() &&
                taskListButton.isEnabled() && taskListButton.isDisplayed() &&
                cancelButton.isDisplayed() && cancelButton.isEnabled() &&
                selectResourceButton.isEnabled() && selectResourceButton.isDisplayed() &&
                setHourButton.isDisplayed() && setHourButton.isEnabled() // !false = true
                &&
                delitePlansWithoutHoursButton.isDisplayed() && delitePlansWithoutHoursButton.isEnabled()
                &&
                optionsButton.isEnabled()
                && optionsButton.isDisplayed()
                ;
    }
    public BookerPlusResourceListPage selectResourceButtonClick() {
        selectResourceButton.click();
        return new BookerPlusResourceListPage(driver);
    }
    }
