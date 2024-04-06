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
    public void successfulLoginTest() {
        NavigationSteps navigationSteps = new NavigationSteps(driver);
        navigationSteps.login(ReadProperties.username(), ReadProperties.password());

        Assert.assertTrue(new DashboardPage(driver).isPageOpened());
    }

//    @Test
//    public void successfulLoginTest1() {
//        NavigationSteps navigationSteps = new NavigationSteps(driver);
//        navigationSteps.login(ReadProperties.username(),ReadProperties.password());
//
//        driver.get("https://aqa2504.testrail.io/index.php?/projects/overview/29");
//        DashboardPage dashboardPage = new DashboardPage(driver, true);
//
//        Assert.assertTrue(dashboardPage.isPageOpened());
//
//        AddProjectPage addProjectPage = new AddProjectPage(driver, true);
//        addProjectPage.getNameInput().sendKeys("gfdgfds");
//    }

    @Test
    public void wrongPasswordTest() {
        NavigationSteps navigationSteps = new NavigationSteps(driver);
        navigationSteps.login(ReadProperties.username(),"fkdfjkowdf");

        LoginPage loginPage = new LoginPage(driver);
        Assert.assertEquals(loginPage.getErrorText(),"Email/Login or Password is incorrect. Please try again.");
    }
}
