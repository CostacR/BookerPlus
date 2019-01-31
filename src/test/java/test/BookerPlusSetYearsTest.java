package test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.*;

public class BookerPlusSetYearsTest extends BookerPlusBaseTest {
    @DataProvider
    public Object[][] validForSearchTestDataProvider() {
        return new Object[][]{
//              {"email", "password", "Task code", "Task name", "Task description"}
                { "IUAD3102", "test" , "001RT", "testTask01", "test task discription. Automation test 001"
                },
        };
    }

    @Test(dataProvider ="validForSearchTestDataProvider")
    public void scenarioSetYearsTest(String userName, String userPassword, String taskCode, String taskName,
                                     String taskDescription) throws InterruptedException {

        //login
        BookerPlusHomePage bookerPlusHomePage = bookerPlusLoginPage.login(userName, userPassword);
        Assert.assertTrue(bookerPlusHomePage.correctUserID(userName), "User ID does not match");
        Assert.assertTrue(bookerPlusHomePage.logoutLinkAble(), "Logout Button not work");
        //homePage test
//        Assert.assertTrue(bookerPlusHomePage.homePageMenuTest(), "Home page menu not working");
        BookerPlusLineActivityPage bookerPlusLineActivityPage = bookerPlusHomePage.clickAllMenu();
//        Assert.assertTrue(bookerPlusLineActivityPage.isPageLoaded(), "Line activity page not loaded");
        //lineActivity Page
        BookerPlusLineActivityTaskPage bookerPlusLineActivityTaskPage = bookerPlusLineActivityPage.clickTask();
//        Assert.assertTrue(bookerPlusLineActivityTaskPage.isPageLoaded(), "Lineactivity page not loaded");
        //create new task
        bookerPlusLineActivityTaskPage.createTask(taskCode, taskName, taskDescription);
        bookerPlusLineActivityTaskPage.editScheduleTask(taskName);

        //edit new schedule
        BookerPlusNewTaskEditPage bookerPlusNewTaskEditPage
                =  bookerPlusLineActivityTaskPage.ScheduleButtonClick();
        BookerPlusTaskEditPage bookerPlusTaskEditPage
                = bookerPlusNewTaskEditPage.add2019AndEditTask();//2019
        bookerPlusTaskEditPage.set2019HoursWeeks();
        bookerPlusTaskEditPage.saveAllChanges2019Click();//
        bookerPlusNewTaskEditPage.setYearSelectDropMenuClickable();
        bookerPlusTaskEditPage.add2020AndEditTask();
        bookerPlusTaskEditPage.set2020HoursWeeks();
        bookerPlusTaskEditPage.correctSumHoursTest();
        bookerPlusTaskEditPage.saveAllChanges2020Click();
        bookerPlusTaskEditPage.sumHoursAddTest();

        bookerPlusTaskEditPage.backPage(); //return on stage LineActivityMenu

    }
}
