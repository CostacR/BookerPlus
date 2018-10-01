package test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class BookerPlusLoginTest extends BookerPlusBaseTest{
    @DataProvider
    public Object[][] validDataProvider() {
        return new Object[][]{
//              {"email", "password"}
                { "IUAD3102", "test"},
        };
    }

    @Test(dataProvider ="validDataProvider")
    public void scenarioTest(String userEmail, String userPassword)  {


    }

}
