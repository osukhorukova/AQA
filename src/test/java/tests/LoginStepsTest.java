package tests;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import models.Project;
import models.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;
import steps.NavigationSteps;
import steps.ProjectSteps;

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
    public void successfulLoginTest1() {
        NavigationSteps navigationSteps = new NavigationSteps(driver);
        User admin = new User();
        admin.setEmail(ReadProperties.username());
        admin.setPassword(ReadProperties.password());

        Project expectedProject = new Project();
        expectedProject.setName("project1");
        expectedProject.setAnnouncement("This is project number 1");
        expectedProject.setProjectType(1);

        navigationSteps
                        .successfulLogin(admin);
        ProjectSteps projectSteps = new ProjectSteps(driver);
        projectSteps.addProject(expectedProject);
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
