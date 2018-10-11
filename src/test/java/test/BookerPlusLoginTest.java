package test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.*;

public class BookerPlusLoginTest extends BookerPlusBaseTest{
    @DataProvider
    public Object[][] validDataProvider() {
        return new Object[][]{
//              {"email", "password", "Task code", "Task name", "Task description"}
                { "IUAD3102", "test" , "001RT", "testTask01", "test task discription. Automation test 001"
                },
        };
    }

    @Test(dataProvider ="validDataProvider")
    public void scenarioTest(String userName, String userPassword, String taskCode, String taskName, String taskDescription) throws InterruptedException {
//        Assert.assertTrue(bookerPlusLoginPage.isPageLoaded(), "Login page is not loaded.");
//        bookerPlusLoginPage.loginLinkClick();
//        bookerPlusLoginPage.isElementsVisible();
//        Assert.assertTrue(bookerPlusLoginPage.isElementsVisible(), "Elements not visible");
//        Assert.assertTrue(bookerPlusLoginPage.isElementsEnabled(),"Elements not enabled");
        BookerPlusHomePage bookerPlusHomePage = bookerPlusLoginPage.login(userName, userPassword);
        Assert.assertTrue(bookerPlusHomePage.correctUserID(userName), "User ID does not match");
        Assert.assertTrue(bookerPlusHomePage.logoutLinkAble(), "Logout Button not work");
        Assert.assertTrue(bookerPlusHomePage.homePageMenuTest(),"Home page menu not working");
        BookerPlusLineActivityPage bookerPlusLineActivityPage = bookerPlusHomePage.clickAllMenu();
        Assert.assertTrue(bookerPlusLineActivityPage.isPageLoaded(),"Line activity page not loaded");
        BookerPlusLineActivityTaskPage bookerPlusLineActivityTaskPage = bookerPlusLineActivityPage.clickTask();
        Assert.assertTrue(bookerPlusLineActivityTaskPage.isPageLoaded(),"Lineactivity page not loaded");
        bookerPlusLineActivityTaskPage.createTask(taskCode, taskName, taskDescription);
        bookerPlusLineActivityTaskPage.editScheduleTask();

//        BookerPlusNewTaskPage bookerPlusNewTaskPage =



    }

}
