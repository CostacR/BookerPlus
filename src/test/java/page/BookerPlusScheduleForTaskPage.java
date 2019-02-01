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
    @FindBy (xpath = "//td/div[@class='text-center']/div[@class='planTotalZero']")//ячейка на пересечении столбец Total строка Demand
    private List<WebElement> planTotalZeroFields;
    @FindBy (xpath = "//td/div[@class='text-center']/div[2]")//столбец Total строка Plan
    private List<WebElement> totalPlanFields;
    @FindBy (xpath = "//td/div[@class='text-center']/div[1]")//столбец Total строка Demand
    private List<WebElement> totalDemandFields;
    @FindBy (xpath = "//tr[@class='demandSuccess']//td[@class='leftPositionRows']/div")//ячейка Demand/Planned
    private WatchEvent totalPlannedDemandField;
    @FindBy(xpath = "//*[@id='fixTable']/tbody/tr[14]/td[@class='timeEachOfTd']")
    private List<WebElement> kopkaHoursTableElements;
    @FindBy (xpath = "(//tr[@class='']/td/div/a/ancestor-or-self::tr)[1]//td/div[2]")
//    @FindBy (xpath = "(//tr[@class='demandSuccess']/td/div/a/ancestor-or-self::tr)[1]//td/div[2]")  //строка Planned и
    private List<WebElement> stringDataHours;                                                       //строки с данными по часам
    @FindAll({
            @FindBy (xpath = "//*[contains(text(), 'Approving')]/ancestor-or-self::tr//td/div[@class='selectedPlan']"),//28
            @FindBy (xpath = "//*[contains(text(), 'Approving')]/ancestor-or-self::tr//td/div[@class='zero']"),//26
            @FindBy (xpath = "//tr[@class='demandSuccess']/td/div/a/ancestor-or-self::tr//td/div[2]")//все строки с часами

    })
    private List<WebElement> allStringsDataHours;
    @FindBy (xpath = "//td/div/div[@class='underline text-nowrap cursor planTotalRef']")//первая строка Total Planned
    private WebElement planHoursField;
    @FindBy (xpath = "//td/div/div[@class='underline text-nowrap cursor planTotalRef']")
    private List<WebElement> planHoursFields;
    @FindBy (xpath = "//tbody/tr/td[@rowspan]/span/ancestor-or-self::td")
    private List<WebElement>rowspanElements;//блоки Рабочих Ролей
    @FindBy (xpath = "//td/div/div[@class='underline text-nowrap cursor planTotalRef']/span")
    private List<WebElement> columnTotalHours;

    public BookerPlusScheduleForTaskPage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public int residueWeeksYeaer (){
        return stringDataHours.size();
    }
    public void sumHoursRows() throws InterruptedException {
        Thread.sleep(500);
        int residueWeeks = residueWeeksYeaer();//число недель до конца года
        System.out.println("weeks in year: "+residueWeeks);
        int indexWeek = 0;
        int indexRow=0;
        int sumHoursWeek = 0;

                for (WebElement allStringsDataHour : allStringsDataHours){

                    sumHoursWeek = sumHoursWeek + new Integer(allStringsDataHour.getText());
                    if (indexWeek == residueWeeks){
                        System.out.println("Row"+indexRow+" sum: "+sumHoursWeek);
                        if (columnTotalHoursSum(indexRow)==sumHoursWeek){
                            System.out.println("sum correct :"+indexRow+" row. "+columnTotalHoursSum(indexRow)
                                    +" = "+sumHoursWeek);
                        }
                        System.out.println("indexRow "+indexRow);
                        indexRow++;
                        System.out.println("indexWeek"+indexWeek);
                        indexWeek=0;
                        sumHoursWeek=0;
                    }
                    indexWeek++;
                }
    }
    public int columnTotalHoursSum(int indexRow){
      int indexC=0;
      int columnSum = 0;
//        for (int i=1; i<indexRow; i++){
            for (WebElement columnTotalHour : columnTotalHours){

//                System.out.println(columnTotalHour.getText());
                    if (indexRow == indexC){
                        columnSum = new Integer(Integer.parseInt(columnTotalHour.getText().replaceAll("[^0-9]", "")));
//                        System.out.println("columnSum "+columnSum);
                        }
                indexC++;
            }return columnSum;
    }
    public void hoursArray() throws InterruptedException {
        Thread.sleep(500);
        int indexHoursArray=0;
        int sumHoursArray [] = new int[columnTotalHours.size()];
        for (WebElement columnTotalHour : columnTotalHours){
            sumHoursArray[indexHoursArray] = new Integer(columnTotalHour.getText().replaceAll("[^0-9]", ""));
            System.out.println(indexHoursArray+" row total: "+ sumHoursArray[indexHoursArray]+" = sum: "
                    +sumHoursRow(indexHoursArray));
                    indexHoursArray++;
        }
    }
    public int sumHoursRow(int indexRow){
        int startElement = indexRow * stringDataHours.size();
        int finishElement = (indexRow+1) * stringDataHours.size();
        int indexHours = 0;
        int sumHours=0;

//        for (int indexElement = startElement; indexElement < finishElement; indexElement++){
//            sumHours = sumHours +
//        }
        for (WebElement allStringsDataHour : allStringsDataHours){
            if (indexHours >= startElement ==true && indexHours < finishElement == true) {
                sumHours = sumHours + new Integer(allStringsDataHour.getText());
            }
            indexHours++;
        }
//        System.out.println("\nsum hours ("+indexRow+" row): "+sumHours);
        return sumHours;
    }
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
//        System.out.println("sum hours: "+sumHours);
    }
    public void buttonList(){
        for (WebElement menuButton : menuButtons) {
            System.out.println("menu buttons: "+menuButton.getText());
        }}
    public void buttonRoleList() throws InterruptedException {//клик на кнопке "+" раздела "Role"
        Thread.sleep(1000);
        int index = 0;
        for (WebElement roleButton : roleButtons){
            index++;
            roleButton.click();
            Thread.sleep(100);
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
    public void rowSumHours(){
        int rowSum=0;
        int indexRowSum=0;
        int indexRowElements =0;
        int value;

        for (WebElement stringDataHour : stringDataHours){
            rowSum = rowSum + new Integer(stringDataHour.getText());
                indexRowSum++;
                for (WebElement rowspanElement : rowspanElements){
                    indexRowElements++;
                    if (indexRowElements==indexRowSum){
                        value = Integer.parseInt(rowspanElement.getText().replaceAll("[^0-9]", ""));//проработать цикл!!!
                        System.out.println(indexRowElements+"\n"+indexRowSum+"\n"+value);

                    }

                }


//            System.out.println(indexSum+" "+stringDataHour.getText());
//            System.out.println("Current Sum: "+rowSum);
        }
        System.out.println(rowSum);
        if (rowSum == assertSumHours()){
            System.out.println("Sum correct");
        }
    }
    public int assertSumHours(){
        int value;
        return value = Integer.parseInt(planHoursField.getText().replaceAll("[^0-9]", ""));
    }



}
