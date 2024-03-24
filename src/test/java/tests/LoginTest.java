package tests;

import baseEntities.BaseTest;
import com.fasterxml.jackson.databind.ser.Serializers;
import configuration.ReadProperties;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;

public class LoginTest extends BaseTest {
    @Test
    public void successfulLoginTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(ReadProperties.username(), ReadProperties.password());
        DashboardPage dashboardPage = new DashboardPage(driver);
        dashboardPage.topMenuPage.getTopPanel();

        Assert.assertTrue(dashboardPage.isPageOpened());
    }

    @Test
    public void successfulLoginTest1() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(ReadProperties.username(), ReadProperties.password());

        driver.get("https://aqa2504.testrail.io/index.php?/projects/overview/29");
        DashboardPage dashboardPage = new DashboardPage(driver, true);

        Assert.assertTrue(dashboardPage.isPageOpened());
    }
}
