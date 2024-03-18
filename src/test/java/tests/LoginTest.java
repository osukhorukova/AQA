package tests;

import baseEntities.BaseTest;
import com.fasterxml.jackson.databind.ser.Serializers;
import configuration.ReadProperties;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest {
    @Test
    public void successfulLoginTest(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.getEmailInput().sendKeys(ReadProperties.username());
        loginPage.getPasswordInput().sendKeys(ReadProperties.password());
        loginPage.clickLoginButton();
    }
}
