package test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.BookerPlusHomePage;
import page.BookerPlusScheduleForTaskPage;

public class BookerPlusMyProjectTest extends BookerPlusBaseTest {
    @DataProvider
    public Object[][] validDataProvider() {
        return new Object[][]{
//              {"email", "password", "Task code", "Task name", "Task description"}
                { "IUAD3102", "test" , "001RT", "testTask01", "test task discription. Automation test 001"
                },
        };
    }
    @Test(dataProvider = "validDataProvider", alwaysRun = true)
    public void scenarioMyProjectTest (String userName, String userPassword, String taskCode, String taskName,
                                      String taskDescription) throws InterruptedException {
        //login
        BookerPlusHomePage bookerPlusHomePage = bookerPlusLoginPage.login(userName, userPassword);
        Assert.assertTrue(bookerPlusHomePage.correctUserID(userName), "User ID does not match");
        Assert.assertTrue(bookerPlusHomePage.logoutLinkAble(), "Logout Button not work");

        //переход на страницу HomePage
        bookerPlusHomePage.homePageMenuClick();
        Assert.assertTrue(bookerPlusHomePage.correctActivePageReview(), "Active page NOT valid");

        bookerPlusHomePage.openRequestMenuReview();
        //проверка активной страницы
//        Assert.assertTrue(bookerPlusHomePage.openRequestMenuReview(), "menu NOT work");
////        //select Project by name from HomePage
//        BookerPlusProjectPage bookerPlusProjectPage = bookerPlusHomePage.selectProject();
//        bookerPlusProjectPage.generalInformationReview();
//        bookerPlusProjectPage.generalInformationTaskListReview();
//        BookerPlusScheduleForTaskPage bookerPlusScheduleForTaskPage
//                = bookerPlusHomePage.searchButtonsMenu();
//                = bookerPlusHomePage.openProjectByTaskName();
//        bookerPlusScheduleForTaskPage.buttonList();
////        bookerPlusScheduleForTaskPage.buttonSecondClick();
//        bookerPlusScheduleForTaskPage.buttonRoleList();
////        bookerPlusScheduleForTaskPage.kopka();
//        bookerPlusScheduleForTaskPage.rowspanSum();
//        bookerPlusScheduleForTaskPage.roleArray();

    }

}
