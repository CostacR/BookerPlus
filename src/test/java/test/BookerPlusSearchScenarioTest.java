package test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.BookerPlusHomePage;
import page.BookerPlusSearchResultPage;

public class BookerPlusSearchScenarioTest extends BookerPlusBaseTest{
    @DataProvider
    public Object[][] validForPMSearchTestDataProvider() {
        return new Object[][]{
//              {"login",       "password", "searchText"}//Project Manager Search
                {"IUAD3102",    "test" ,    "c"
                },
        };
    }
    @DataProvider
    public Object [][] validForLMSearchTestDataProvider(){
        return new Object[][]{
//                {"login",     "password", "searchText"}//Line Manager Search
                  {"IUAD1810",  "test",     "c"},
        };
    }
    @DataProvider
    public Object [][] validForAdminSearchTestDataProvider(){
        return new Object[][]{
//                {"login",     "password", "searchText"}//Admin Search
                {"IUAB0HPL",  "test",     "h"},
        };
    }

    @Test (dataProvider = "validForPMSearchTestDataProvider")
    public void scenarioSearchPMPageTest(String userName, String userPassword, String findText)
            throws InterruptedException {
        //login
        BookerPlusHomePage bookerPlusHomePage = bookerPlusLoginPage.login(userName, userPassword);
        Assert.assertTrue(bookerPlusHomePage.correctUserID(userName), "User ID does not match");
        Assert.assertTrue(bookerPlusHomePage.logoutLinkAble(), "Logout Button not work");

        //запуск поиска
        BookerPlusSearchResultPage bookerPlusSearchResultPage
                = bookerPlusHomePage.myProjectsClick();
        bookerPlusSearchResultPage.searchResult(findText);//тест всех поисковых фильтров под пользователем (Zhukova Valeriya (IUAD3102)
    }

    @Test (dataProvider = "validForLMSearchTestDataProvider")
    public void scenarioSearchLMPageTest(String userName, String userPassword, String findText)
            throws InterruptedException {
        //login
        BookerPlusHomePage bookerPlusHomePage = bookerPlusLoginPage.login(userName, userPassword);
        Assert.assertTrue(bookerPlusHomePage.correctUserID(userName), "User ID does not match");
        Assert.assertTrue(bookerPlusHomePage.logoutLinkAble(), "Logout Button not work");

        //запуск поиска
        BookerPlusSearchResultPage bookerPlusSearchResultPage
                = bookerPlusHomePage.myProjectsClick();
        bookerPlusSearchResultPage.searchResult(findText);//тест всех поисковых фильтров под пользователем (Zhukova Valeriya (IUAD3102)
    }

    @Test (dataProvider = "validForLMSearchTestDataProvider")
    public void scenarioSearchAdminPageTest(String userName, String userPassword, String findText)
            throws InterruptedException {
        //login
        BookerPlusHomePage bookerPlusHomePage = bookerPlusLoginPage.login(userName, userPassword);
        Assert.assertTrue(bookerPlusHomePage.correctUserID(userName), "User ID does not match");
        Assert.assertTrue(bookerPlusHomePage.logoutLinkAble(), "Logout Button not work");

        //запуск поиска
        BookerPlusSearchResultPage bookerPlusSearchResultPage
                = bookerPlusHomePage.myProjectsClick();
        bookerPlusSearchResultPage.searchResult(findText);//тест всех поисковых фильтров под пользователем (Zhukova Valeriya (IUAD3102)
    }
}
