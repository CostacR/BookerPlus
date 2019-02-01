package test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.BookerPlusHomePage;
import page.BookerPlusScheduleForTaskPage;

public class BookerPlusCheckSumHoursTest  extends BookerPlusBaseTest {

    @DataProvider
    public Object[][] validDataProvider() {
        return new Object[][]{
//              {"email", "password", "Task name"}
                {"IUAD3102", "test", "Implementation"
                },
        };
    }

    @Test(dataProvider = "validDataProvider", alwaysRun = true)
    public void scenarioHomePageReviewTest(String userName, String userPassword, String taskName) throws InterruptedException {
        //login
        BookerPlusHomePage bookerPlusHomePage = bookerPlusLoginPage.login(userName, userPassword);
        Assert.assertTrue(bookerPlusHomePage.correctUserID(userName), "User ID does not match");
        Assert.assertTrue(bookerPlusHomePage.logoutLinkAble(), "Logout Button not work");
        //homePage test
        //проверка загрузки корректной страницы пока не работает,
        // ввиду того что url содержит пробел.
        // Удалить в проверяемом тексте пробелы!!!!

        //проверка кнопок-закладок главного меню
//        Assert.assertTrue(bookerPlusHomePage.homePageMenuReview(), "Home page menu not working");

        bookerPlusHomePage.homePageMenuClick();//переход на страницу HomePage
        Assert.assertTrue(bookerPlusHomePage.correctActivePageReview(), "Active page NOT valid");
//        bookerPlusHomePage.myTasksPageClick();
//        Assert.assertTrue(bookerPlusHomePage.correctActivePageReview(), "Active page NOT valid");
//        bookerPlusHomePage.myProjectsClick();//КАКОГО!!!!!????? линк My project = projectInit???????/
        bookerPlusHomePage.openRequestMenuReview();
        //проверка активной страницы
//        Assert.assertTrue(bookerPlusHomePage.openRequestMenuReview(), "menu NOT work");
//        //select Project by name from HomePage
//        BookerPlusProjectPage bookerPlusProjectPage = bookerPlusHomePage.selectProject();
        /*Сценарий поиска таски по имени в закладках.
         вход в нужную таску.
         проверка сум часов запланированых по всем строкам
        * */
        BookerPlusScheduleForTaskPage bookerPlusScheduleForTaskPage = bookerPlusHomePage.searchButtonsMenu();
        bookerPlusScheduleForTaskPage.buttonList();
        bookerPlusScheduleForTaskPage.buttonRoleList();
        bookerPlusScheduleForTaskPage.sumHoursString();
        bookerPlusScheduleForTaskPage.hoursArray();


    }
}