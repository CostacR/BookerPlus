package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.nio.file.WatchEvent;
import java.util.List;

public class BookerPlusScheduleForTaskPage extends BookerPlusBasePage{

    @FindAll({
            @FindBy (xpath = "//button[@class='btn btn-primary btn-sm']"),
            @FindBy (xpath = "//button[@class='btn btn-warning btn-sm']"),
            @FindBy (xpath = "//button[@class='btn btn-docs btn-sm']")
    })
    private List <WebElement> menuButtons;

    @FindBy (xpath = "(//tr//td[@class='leftPositionRows cutLink']/span/button[@type='button'])[3]")
    private WebElement roleSecondButtons;

    @FindBy (xpath = "//tr//td//span//button")
    private List<WebElement> roleButtons;

    @FindBy (xpath = "//tr//td/span[@title]")
    private List<WebElement> roleButtonNameFields;

    @FindBy (xpath = "//td/div[@class='text-center']/div[@class='planTotalZero']")//столбец Total строка Demand
    private List<WebElement> totalDemandFields;

    @FindBy (xpath = "//td/div[@class='text-center']/div[2]")//столбец Total строка Plan
    private List<WebElement> totalPlanFields;

    @FindBy (xpath = "//tr[@class='demandSuccess']//td[@class='leftPositionRows']/div")//ячейка Demand/Planned
    private WatchEvent totalPlannedDemandField;

    @FindBy(xpath = "//*[@id='fixTable']/tbody/tr[14]/td[@class='timeEachOfTd']")
    private List<WebElement> kopkaHoursTableElements;

    @FindBy (xpath = "//tr[@class='demandSuccess']/td/div/a/ancestor-or-self::tr)[1]//td/div[2]")//строка Planned и
    //(//tr[@class='demandSuccess']/td/div/a/ancestor-or-self::tr)[1]//td/div[2]
    private List<WebElement> stringDataHours;

    @FindBy (xpath = "//tbody/tr/td[@rowspan]/span/ancestor-or-self::td")
    private List<WebElement>rowspanElements;



    public BookerPlusScheduleForTaskPage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    String [] roleNameFields ;



    public void roleArray(){
        int indexArray = 0;
        String roleNameFields [] =  new String[roleButtonNameFields.size()];
        for (WebElement roleButtonNameField : roleButtonNameFields){
            roleNameFields[indexArray] = roleButtonNameField.getText();
            System.out.println(indexArray+" "+roleButtonNameField.getText());
            indexArray++;
        }
        System.out.println(roleNameFields);
    }
    public void sumHoursString(){
        int sumHours=0;
        for (WebElement stringDataHour : stringDataHours){
            sumHours=sumHours+new Integer(stringDataHour.getText());
        }
        System.out.println("sum hours: "+sumHours);
    }
    public void buttonList(){
        for (WebElement menuButton : menuButtons) {
//            System.out.println(menuButton.getText());//
        }}
    public void buttonRoleList() throws InterruptedException {
        Thread.sleep(2000);
        int index = 0;
        System.out.println("Pause 2000");
        for (WebElement roleButton : roleButtons){
            System.out.println(index);
            index++;
            roleButton.click();
            Thread.sleep(500);
        }

    }
    public void buttonSecondClick() throws InterruptedException {
        Thread.sleep(500);
        roleSecondButtons.click();
    }
    public void kopka(){
        int kopkaSum=0;

        System.out.println(kopkaHoursTableElements.size());
        for (WebElement kopkaHoursTableElement : kopkaHoursTableElements){
            kopkaSum=kopkaSum+new Integer(kopkaHoursTableElement.getText());

        }
        System.out.println("Sum kopko = "+kopkaSum);
    }
    public void rowspanSum(){//подсчитывает число строк в открытых группах
        int rsSum=0;
        for (WebElement rowspanElement : rowspanElements){
            String attribute = rowspanElement.getAttribute("rowspan");
            System.out.println(attribute);
            rsSum = rsSum + new Integer(attribute);
            }
        System.out.println(rsSum);
    }


}
