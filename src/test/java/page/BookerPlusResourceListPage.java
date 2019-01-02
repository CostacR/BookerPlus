package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static org.apache.commons.lang3.BooleanUtils.or;

public class BookerPlusResourceListPage extends BookerPlusBasePage {

    @FindBy(xpath = "//div[@class='modal-header panel-heading']/b[contains(text(), 'Resource list')]")
    private WebElement resourceListNameField;
    @FindBy(xpath = "(//div[@class='modal-header panel-heading']//button[@class='close pull-right'])[2]")
    private WebElement closeResourceListPage;
    @FindBy(xpath = "(//div[@class='btn-block btn-group margin-bottom']//button['Select all'])[1]")
    private WebElement selectAllButton;
    @FindBy(xpath = "(//div[@class='btn-block btn-group margin-bottom']//button['Select all'])[2]")
    private WebElement unSelectAllButton;
    @FindBy(xpath = "(//div[@class='text-right']//button)[1]")
    private WebElement applyButton;
    @FindBy(xpath = "//button[@class='btn btn-success btn-sm' and contains(text(), 'Select')]")
    private List<WebElement> selectButtons;
    @FindBy(xpath = "//button[@class='btn btn-default btn-sm' and contains(text(), 'Unselect')]")
    private List<WebElement> unSelectButtons;

    @FindBy(xpath = "//tr[@class='total']/td[@class='total']")//55
    private List<WebElement> workingTimeFields;
    @FindBy(xpath = "//tr[@class='firstline']/td[@class='text-center time']")//53
    private List<WebElement> availableTimeFields;
    @FindAll({
            @FindBy(xpath = "//tr/td[@class='text-center time cursor cursorNone selectedPlan']"), //7
            @FindBy(xpath = "//tr/td[@class='text-center time cursor cursorNone']")//46
    })
    private List<WebElement> planningTimeFields;
    @FindBy(xpath = "(//tr//td[@class='col-xs-3'])[1]")
    private WebElement resourceNameFirstObjectInList;
    @FindAll({
            @FindBy(xpath = "//tr//td[@class='col-xs-2']//*[@class='glyphicon glyphicon-ok']"),
            @FindBy(xpath = "//tr//td[@class='col-xs-2'][not(div[@class='glyphicon glyphicon-ok'])]")
    })
    private List <WebElement> existedInSchedulerObjects;

    public BookerPlusResourceListPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void unSelectButtonsTest() {
        int index = 1;
        System.out.println("UnSelect buttons test");
        for (WebElement unselectButtonsResult : unSelectButtons) {
            if
            (((unselectButtonsResult.isDisplayed() && unselectButtonsResult.isEnabled())) == true) {
                System.out.println("Button# " + index + " is enabled");
                index++;
            } else {
                System.out.println("Button# " + index + " is disabled");
                index++;
            }
        }
    }
    public void selectButtonsTest() {
       int index = 1;
        System.out.println("Select buttons test");
        for (WebElement selectButtonsResult : selectButtons) {
            if
            (((selectButtonsResult.isDisplayed() && selectButtonsResult.isEnabled())) == true) {
                System.out.println("Button# " + index + " is enabled");
                index++;
            } else {
                System.out.println("Button# " + index + " is disabled");
                index++;
            }
        }
    }

    public void oneResourceSelect() {
        int index = 1;
        for (WebElement existedInSchedulerObject : existedInSchedulerObjects) {
            if (existedInSchedulerObject.toString().contains("not(div")==true){
                System.out.println("Element #"+index+" is NOT selected");
            }
            else{
                System.out.println("Element #"+index+" is selected");
            }
            index++;


        }}
}

