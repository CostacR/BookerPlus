package test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.*;

public class BookerPlusScenarioDeletePlansWithoutHoursTest extends BookerPlusBaseTest {
    @DataProvider
    public Object[][] validForSearchTestDataProvider() {
        return new Object[][]{
//              {"email", "password", "Task code", "Task name", "Task description"}
                { "IUAD3102", "test" , "001RT", "testTask01", "test task discription. Automation test 001"
                },
        };
    }
    @Test(dataProvider ="validForSearchTestDataProvider")
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
//            Assert.assertTrue(bookerPlusLineActivityTaskPage.isPageLoaded(), "Lineactivity page not loaded");
            //edit new schedule
            BookerPlusNewTaskEditPage bookerPlusNewTaskEditPage
                    =  bookerPlusLineActivityTaskPage.ScheduleButtonClick();
            bookerPlusNewTaskEditPage.setYearSelectDropMenuClickable();
            BookerPlusTaskEditPage bookerPlusTaskEditPage = bookerPlusNewTaskEditPage.add2019AndEditTask();
            //delete plans without hours
            bookerPlusTaskEditPage.addOneResources();
            bookerPlusTaskEditPage.addAllResources();
            bookerPlusTaskEditPage.addSomeResourcesWithPlans();
    }
}
