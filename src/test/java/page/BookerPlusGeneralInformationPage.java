package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class BookerPlusGeneralInformationPage extends BookerPlusBasePage{
    @FindBy(xpath = "(//div/div/button)[6]")
    private WebElement historyFirstButton;

    @FindBy(xpath = "(//div/p/button)[2]")
    private WebElement historySecondButton;

    @FindBy(xpath = "(//div/p/button)[1]")
    private WebElement historyTherdButton;

    @FindBy(xpath = "//div/div/div/div/button[@class='close pull-right']")
    private List<WebElement> closeModalPageButtons;

    public BookerPlusGeneralInformationPage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }


    public void allButtonsTest() {//проверка статуса кнопки Закрытие Модального Окна + закрытие окна кликом по кнопке
        int indexM = 1;
        for (WebElement closeModalPageButton : closeModalPageButtons){
            System.out.println(indexM +
                    "\n is enabled: "+closeModalPageButton.isEnabled()
                    +"\n is displayed: "+closeModalPageButton.isDisplayed());
            if (closeModalPageButton.isDisplayed() && closeModalPageButton.isEnabled()==true){
                closeModalPageButton.click();
            }
        }
    }
    public void historyButtonClick() throws InterruptedException {//метод выборочного клика по кнопка с вызовом модальных окон
        Thread.sleep(1000);
        historyFirstButton.click();
        Thread.sleep(500);
        allButtonsTest();
        Thread.sleep(500);
        historySecondButton.click();
        Thread.sleep(500);
        allButtonsTest();
        Thread.sleep(500);
        historyTherdButton.click();
    }


}
