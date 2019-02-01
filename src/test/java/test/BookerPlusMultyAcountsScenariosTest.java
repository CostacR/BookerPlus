package test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.*;

public class BookerPlusMultyAcountsScenariosTest extends BookerPlusBaseTest{
    @DataProvider
    public Object[][] validDataProvider() {
        return new Object[][]{
//              {"loginPM", "passwordPM", "loginLM", "passwordLM","loginAdmin", "passwordAdmin",}
                { "IUAD3102", "testP", "IUAD1842", "testL", "IUAb0hpl", "testA",
                },
        };
    }
    @Test (dataProvider = "validDataProvider", alwaysRun = true)
        public void scenarioMultyAcountEnterTest(String loginPM, String passwordPM,
                                                 String loginLM, String passwordLM,
                                                 String loginAdmin, String passwordAdmin)
            throws InterruptedException {
        /*
        * Последовательный заход в аккаунты и выход из них через кнопку LogOut
        * */

        //login
        BookerPlusHomePage bookerPlusHomePage = bookerPlusLoginPage.login(loginPM, passwordPM);
        Assert.assertTrue(bookerPlusHomePage.logoutLinkAble(), "Logout Button not work");
        bookerPlusHomePage.loginsList();

        bookerPlusHomePage.logOut();

        bookerPlusLoginPage.login(loginLM, passwordLM);
        Assert.assertTrue(bookerPlusHomePage.logoutLinkAble(), "Logout Button not work");
        bookerPlusHomePage.loginsList();
        bookerPlusHomePage.logOut();

        bookerPlusLoginPage.login(loginAdmin, passwordAdmin);
        Assert.assertTrue(bookerPlusHomePage.logoutLinkAble(), "Logout Button not work");
        bookerPlusHomePage.loginsList();
        bookerPlusHomePage.logOut();
    }

}
