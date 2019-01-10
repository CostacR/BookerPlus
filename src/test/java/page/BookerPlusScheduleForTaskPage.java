package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class BookerPlusScheduleForTaskPage extends BookerPlusBasePage{

    @FindAll({
            @FindBy (xpath = "//button[@class='btn btn-primary btn-sm']"),
            @FindBy (xpath = "//button[@class='btn btn-warning btn-sm']"),
            @FindBy (xpath = "//button[@class='btn btn-docs btn-sm']")
    })
    private List <WebElement> menuButtons;

    @FindBy (xpath = "//tr//td[@class='leftPositionRows cutLink']/span/button[@type='button']/span")
    private List<WebElement> roleButtons;

    @FindBy (xpath = "//tr//td/span[@title]")
    private List<WebElement> roleButtonNameFields;


    public BookerPlusScheduleForTaskPage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public void buttonList(){
        for (WebElement menuButton : menuButtons) {
//            System.out.println(menuButton.getText());//
        }}

    public void buttonRoleList() throws InterruptedException {
        int indexP = 1;
        int num=1;
        Thread.sleep(500);
        for (WebElement roleButtonNameField : roleButtonNameFields){
            if (roleButtonNameField.getText().toLowerCase().contains("FrontEnd Developer ")==true){
                System.out.println("true"+indexP+" "+roleButtonNameField.getText());
                System.out.println(roleButtonNameField.getText().toLowerCase().contains("frontend developer"));
                num=indexP;
                }
            System.out.println(roleButtonNameField.getText()+indexP);
            indexP++;
        }
        System.out.println("P = "+indexP);
        int indexR=1;
        for (WebElement roleButton : roleButtons) {
        if (indexR==indexP){
            System.out.println("num - "+num);
            roleButton.click();
        }
            Thread.sleep(500);
            indexR++;
        }



    }
}
