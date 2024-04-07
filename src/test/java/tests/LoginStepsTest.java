package tests;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;
import steps.NavigationSteps;

public class LoginStepsTest extends BaseTest {
    @Test
    public void successfulLoginTest() {
        NavigationSteps navigationSteps = new NavigationSteps(driver);

        Assert.assertTrue(
                navigationSteps
                        .successfulLogin(ReadProperties.username(),ReadProperties.password())
                        .isPageOpened());
    }

    @Test
    public void incorrectLoginTest() {
        NavigationSteps navigationSteps = new NavigationSteps(driver);

        Assert.assertEquals(
                navigationSteps
                        .incorrectLogin("gdgfdgfdgfdg",ReadProperties.password())
                        .getErrorText(),"Email/Login or Password is incorrect. Please try again.");
    }
}
