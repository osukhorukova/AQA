package tests;

import baseEntities.BaseTest;
import com.fasterxml.jackson.databind.ser.Serializers;
import configuration.ReadProperties;
import net.bytebuddy.asm.MemberSubstitution;
import org.checkerframework.checker.units.qual.N;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;
import pages.projects.AddProjectPage;
import pages.projects.EditProjectPage;
import pages.projects.ProjectBasePage;
import steps.NavigationSteps;

public class LoginTest extends BaseTest {

    @Test
    public void successfulLoginTest2() {
        LoginPage loginPage = new LoginPage(driver);

        Assert.assertTrue(loginPage.successfulLogin(ReadProperties.username(), ReadProperties.password())
                .isPageOpened()
        );
    }

    @Test
    public void wrongPasswordTest2() {
        LoginPage loginPage = new LoginPage(driver);

        Assert.assertEquals(loginPage.incorrectLogin("fefefefdfd", ReadProperties.password())
                .getErrorText(), "Email/Login or Password is incorrect. Please try again."
        );
    }
}
