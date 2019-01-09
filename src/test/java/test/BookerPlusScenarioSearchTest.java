package test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.BookerPlusHomePage;
import page.BookerPlusSearchResultPage;

public class BookerPlusScenarioSearchTest extends BookerPlusBaseTest{
    @DataProvider
    public Object[][] validForUserAcountSearchTestDataProvider() {
        return new Object[][]{
//              {"login",       "password", "searchText"}
                {"IUAD3102",    "test" ,    "c"
                },
        };
    }
    @DataProvider
    public Object [][] validForAdminAcountSearchTestDataProvider(){
        return new Object[][]{
//                {"login",     "password", "searchText"}
                  {"IUAB0HPL",  "test",     "a"},
        };
    }
    @Test (dataProvider = "validForUserAcountSearchTestDataProvider")
    public void scenarioSearchPageTest(String userName, String userPassword, String findText)
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
    @Test (dataProvider = "validForAdminAcountSearchTestDataProvider")
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
