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
    @Test (dataProvider = "validDataProvider")
    public void scenarioResourceListTest (String userName, String userPassword, String taskCode, String taskName,
                                          String taskDescription) throws InterruptedException {
        //login
        BookerPlusHomePage bookerPlusHomePage = bookerPlusLoginPage.login(userName, userPassword);
        Assert.assertTrue(bookerPlusHomePage.correctUserID(userName), "User ID does not match");
        Assert.assertTrue(bookerPlusHomePage.logoutLinkAble(), "Logout Button not work");
        //homePage test
        Assert.assertTrue(bookerPlusHomePage.homePageMenuTest(), "Home page menu not working");
        BookerPlusLineActivityPage bookerPlusLineActivityPage = bookerPlusHomePage.clickAllMenu();
        Assert.assertTrue(bookerPlusLineActivityPage.isPageLoaded(), "Line activity page not loaded");
        //lineActivity Page
        BookerPlusLineActivityTaskPage bookerPlusLineActivityTaskPage = bookerPlusLineActivityPage.clickTask();
        Assert.assertTrue(bookerPlusLineActivityTaskPage.isPageLoaded(), "Lineactivity page not loaded");
        //edit new schedule
        BookerPlusNewTaskEditPage bookerPlusNewTaskEditPage
                = bookerPlusLineActivityTaskPage.ScheduleButtonClick();
        bookerPlusNewTaskEditPage.setYearSelectDropMenuClickable();

        //ResourceList test
        BookerPlusResourceListPage bookerPlusResourceListPage
                = bookerPlusNewTaskEditPage.selectResourceButtonClick();
        bookerPlusResourceListPage.selectButtonsTest();
        bookerPlusResourceListPage.unSelectButtonsTest();
//        bookerPlusResourceListPage.noOneResourceSelect();
//        bookerPlusResourceListPage.oneResourceSelect();


    }

    @Test(dataProvider ="validDataProvider")
    public void scenarioSetHoursTest(String userName, String userPassword, String taskCode, String taskName,
                                     String taskDescription) throws InterruptedException {

        //login
        BookerPlusHomePage bookerPlusHomePage = bookerPlusLoginPage.login(userName, userPassword);
        Assert.assertTrue(bookerPlusHomePage.correctUserID(userName), "User ID does not match");
        Assert.assertTrue(bookerPlusHomePage.logoutLinkAble(), "Logout Button not work");
        //homePage test
        Assert.assertTrue(bookerPlusHomePage.homePageMenuTest(), "Home page menu not working");
        BookerPlusLineActivityPage bookerPlusLineActivityPage = bookerPlusHomePage.clickAllMenu();
        Assert.assertTrue(bookerPlusLineActivityPage.isPageLoaded(), "Line activity page not loaded");
        //lineActivity Page
        BookerPlusLineActivityTaskPage bookerPlusLineActivityTaskPage = bookerPlusLineActivityPage.clickTask();
        Assert.assertTrue(bookerPlusLineActivityTaskPage.isPageLoaded(), "Lineactivity page not loaded");
        //edit new schedule
        BookerPlusNewTaskEditPage bookerPlusNewTaskEditPage
                = bookerPlusLineActivityTaskPage.ScheduleButtonClick();
        bookerPlusNewTaskEditPage.setYearSelectDropMenuClickable();
        BookerPlusTaskEditPage bookerPlusTaskEditPage = bookerPlusNewTaskEditPage.addAndEditTask();

        //setHours test
        bookerPlusTaskEditPage.setNewResourcesButtonClick();
        bookerPlusTaskEditPage.saveAllChanges2019Click();
        bookerPlusTaskEditPage.setEmptyHoursButtonClick();
        bookerPlusTaskEditPage.saveAllChanges2019Click();
        bookerPlusTaskEditPage.setUpdateResourcesButtonClick();
        bookerPlusTaskEditPage.saveAllChanges2019Click();
        bookerPlusTaskEditPage.setCleanHoursButtonClick();
        bookerPlusTaskEditPage.saveAllChanges2019Click();
        bookerPlusTaskEditPage.setCancelButtonClick();
        bookerPlusTaskEditPage.sumTimeTesting();

    }

        @Test(dataProvider ="validDataProvider")
        public void scenarioDeletePlansWithoutHoursTest(String userName, String userPassword, String taskCode, String taskName,
                String taskDescription) throws InterruptedException {

            //login
            BookerPlusHomePage bookerPlusHomePage = bookerPlusLoginPage.login(userName, userPassword);
            Assert.assertTrue(bookerPlusHomePage.correctUserID(userName), "User ID does not match");
            Assert.assertTrue(bookerPlusHomePage.logoutLinkAble(), "Logout Button not work");
            //homePage test
            Assert.assertTrue(bookerPlusHomePage.homePageMenuTest(), "Home page menu not working");
            BookerPlusLineActivityPage bookerPlusLineActivityPage = bookerPlusHomePage.clickAllMenu();
            Assert.assertTrue(bookerPlusLineActivityPage.isPageLoaded(), "Line activity page not loaded");
            //lineActivity Page
            BookerPlusLineActivityTaskPage bookerPlusLineActivityTaskPage = bookerPlusLineActivityPage.clickTask();
            Assert.assertTrue(bookerPlusLineActivityTaskPage.isPageLoaded(), "Lineactivity page not loaded");
            //edit new schedule
            BookerPlusNewTaskEditPage bookerPlusNewTaskEditPage
                    =  bookerPlusLineActivityTaskPage.ScheduleButtonClick();
            bookerPlusNewTaskEditPage.setYearSelectDropMenuClickable();
            BookerPlusTaskEditPage bookerPlusTaskEditPage = bookerPlusNewTaskEditPage.addAndEditTask();
        //delete plans without hours
        bookerPlusTaskEditPage.addOneResources();
        bookerPlusTaskEditPage.addAllResources();
        bookerPlusTaskEditPage.addSomeResourcesWithPlans();

    }

    @Test(dataProvider ="validDataProvider")
    public void scenarioSetYearsTest(String userName, String userPassword, String taskCode, String taskName,
                                     String taskDescription) throws InterruptedException {

        //login
        BookerPlusHomePage bookerPlusHomePage = bookerPlusLoginPage.login(userName, userPassword);
        Assert.assertTrue(bookerPlusHomePage.correctUserID(userName), "User ID does not match");
        Assert.assertTrue(bookerPlusHomePage.logoutLinkAble(), "Logout Button not work");
        //homePage test
        Assert.assertTrue(bookerPlusHomePage.homePageMenuTest(), "Home page menu not working");
        BookerPlusLineActivityPage bookerPlusLineActivityPage = bookerPlusHomePage.clickAllMenu();
        Assert.assertTrue(bookerPlusLineActivityPage.isPageLoaded(), "Line activity page not loaded");
        //lineActivity Page
        BookerPlusLineActivityTaskPage bookerPlusLineActivityTaskPage = bookerPlusLineActivityPage.clickTask();
        Assert.assertTrue(bookerPlusLineActivityTaskPage.isPageLoaded(), "Lineactivity page not loaded");
        //create new task
        bookerPlusLineActivityTaskPage.createTask(taskCode, taskName, taskDescription);
        bookerPlusLineActivityTaskPage.editScheduleTask(taskName);

        //edit new schedule
        BookerPlusNewTaskEditPage bookerPlusNewTaskEditPage
                =  bookerPlusLineActivityTaskPage.ScheduleButtonClick();
        BookerPlusTaskEditPage bookerPlusTaskEditPage
                = bookerPlusNewTaskEditPage.addAndEditTask();//2018
        bookerPlusTaskEditPage.set2018HoursWeeks();
        bookerPlusTaskEditPage.saveAllChanges2018Click();//
        bookerPlusNewTaskEditPage.setYearSelectDropMenuClickable();
        bookerPlusTaskEditPage.set2019HoursWeeks();
        bookerPlusTaskEditPage.correctSumHoursTest();
        bookerPlusTaskEditPage.saveAllChanges2019Click();
        bookerPlusTaskEditPage.sumHoursAddTest();

        bookerPlusTaskEditPage.backPage(); //return on stage LineActivityMenu

    }

    @Test (dataProvider ="validDataProvider")
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
        Assert.assertTrue(bookerPlusLineActivityTaskPage.isPageLoaded(),"Lineactivity page not loaded");
        bookerPlusLineActivityTaskPage.createTask(taskCode, taskName, taskDescription);
        bookerPlusLineActivityTaskPage.editScheduleTask(taskName);
        BookerPlusNewTaskEditPage bookerPlusNewTaskEditPage
                = bookerPlusLineActivityTaskPage.ScheduleButtonClick();
        BookerPlusTaskEditPage bookerPlusTaskEditPage
                = bookerPlusNewTaskEditPage.addAndEditTask();
        Assert.assertTrue(bookerPlusNewTaskEditPage.isMenuButtonAble(), "button work wrong");
        //добавить проверки кнопок
        bookerPlusTaskEditPage.set2018HoursWeeks();
        bookerPlusTaskEditPage.saveAllChanges2018Click();//
//        Assert.assertTrue(bookerPlusNewTaskEditPage.isMenuButtonAble(), "button work wrong");
        bookerPlusTaskEditPage.correctSumHoursTest();
//        bookerPlusTaskEditPage.backPage();

        bookerPlusHomePage.clickAllMenu();
        bookerPlusLineActivityPage.clickTask();

        BookerPlusDeleteTaskPage bookerPlusDeliteTaskPage = bookerPlusLineActivityTaskPage.delitTaskButtonClick();
        bookerPlusDeliteTaskPage.deleteTaskYesButton();
    }

}
