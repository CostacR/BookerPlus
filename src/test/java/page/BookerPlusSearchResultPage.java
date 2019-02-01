package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class BookerPlusSearchResultPage extends BookerPlusBasePage {

    @FindBy(xpath = "//tr/td[not(@class='text-nowrap')]/a/span")//столбцы для поиска имена Projects
    //tr/td[3] //альтернативный xPath
    private List<WebElement> projectNameElements;

    @FindBy (xpath = "//tr/td[2]")//столбцы для поиска имена LineActivity
    private List<WebElement> lineActivityNameElements;

    @FindBy(xpath = "//div[@class='form-group']/input[@placeholder]")//поля для поиска
    private WebElement searchTextField;

    public BookerPlusSearchResultPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void searchResult(String findText) throws InterruptedException {//передача в поисковую строку текста для поиска
        Thread.sleep(500);
        searchTextField.click();
        searchTextField.sendKeys(findText);
        Thread.sleep(500);

        System.out.println("Search Project name is: "+searchProjectNameCounter(findText));
        System.out.println("Search LineActivity is: "+searchLineActivityNameCounter(findText));
    }
    public boolean searchLineActivityNameCounter(String findText) { //счетчик строк результатов
        int index = 0;
        for (WebElement lineActivityNameElement : lineActivityNameElements) {
            if (lineActivityNameElement.getText().toLowerCase().contains(findText) == true) {
                System.out.println("Text " + findText + " is contains in "
                        + lineActivityNameElement.getText());
                index++;
            }
        }
        System.out.println(index);
        return (projectNameElements.size() == index);
    }
    public boolean searchProjectNameCounter(String findText) { //счетчик строк результатов
        int index = 0;
        for (WebElement projectNameElement : projectNameElements) {
            if (projectNameElement.getText().toLowerCase().contains(findText) == true) {
                System.out.println("Text " + findText + " is contains in "
                        + projectNameElement.getText());
                index++;
            }
        }
        System.out.println(index);
        return (projectNameElements.size() == index);
        }
}
