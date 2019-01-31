package test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.BookerPlusHomePage;
import page.*;


public class BookerPlusScenarioAddAndDeleteTaskTest extends BookerPlusBaseTest {
    @DataProvider
    public Object[][] validForSearchTestDataProvider() {
        return new Object[][]{
//              {"email", "password", "Task code", "Task name", "Task description"}
                { "IUAD3102", "test" , "001RT", "testTask01", "test task discription. Automation test 001"
                },
        };
    }
        @Test (dataProvider ="validForSearchTestDataProvider")
    public void scenarioBasicTest(String userName, String userPassword, String taskCode, String taskName, String taskDescription) throws InterruptedException {
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
//        Assert.assertTrue(bookerPlusLineActivityTaskPage.isPageLoaded(),"Lineactivity page not loaded");
        bookerPlusLineActivityTaskPage.createTask(taskCode, taskName, taskDescription);
        bookerPlusLineActivityTaskPage.editScheduleTask(taskName);
        BookerPlusNewTaskEditPage bookerPlusNewTaskEditPage
                = bookerPlusLineActivityTaskPage.ScheduleButtonClick();
        BookerPlusTaskEditPage bookerPlusTaskEditPage
                = bookerPlusNewTaskEditPage.add2019AndEditTask();
        Assert.assertTrue(bookerPlusNewTaskEditPage.isMenuButtonAble(), "button work wrong");
        //добавить проверки кнопок
        bookerPlusTaskEditPage.set2019HoursWeeks();
        bookerPlusTaskEditPage.saveAllChanges2019Click();//
//        Assert.assertTrue(bookerPlusNewTaskEditPage.isMenuButtonAble(), "button work wrong");
        bookerPlusTaskEditPage.correctSumHoursTest();
//        bookerPlusTaskEditPage.backPage();

        bookerPlusHomePage.clickAllMenu();
        bookerPlusLineActivityPage.clickTask();

        BookerPlusDeleteTaskPage bookerPlusDeliteTaskPage = bookerPlusLineActivityTaskPage.delitTaskButtonClick();
        bookerPlusDeliteTaskPage.deleteTaskYesButton();
    }
}
