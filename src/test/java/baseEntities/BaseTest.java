package baseEntities;

import configuration.ReadProperties;
import core.BrowserService;
import core.WaitsService;
import models.Milestone;
import models.Project;
import models.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class BaseTest {

    protected WebDriver driver;
    protected WaitsService waitsService;
    protected User admin;
    protected Project mainProject;
    protected Milestone testMilestone;

    @BeforeTest
    public void setUpUser() {
        admin = new User();
        admin.setEmail(ReadProperties.username());
        admin.setPassword(ReadProperties.password());
    }
    @BeforeTest
    public void setUpProject() {
        mainProject = new Project();
        mainProject.setName("Test Project");
        mainProject.setAnnouncement("This is an empty project for my \"patterns\" homework :)");
        mainProject.setShowAnnouncement(true);
        mainProject.setProjectType(1);
        mainProject.setEnableTCApproval(false);
    }

    @BeforeTest
    public void setUpMilestone() {
        testMilestone = new Milestone.Builder()
                .withName("Test Milestone")
                .withReference("WEB-025")
                .withDescription("This is an empty milestone for my \"patterns\" homework :)")
                .isCompleted(false)
                .build();
    }

    @BeforeMethod
    public void setup() {
        driver = new BrowserService().getDriver();
        waitsService = new WaitsService(driver);
        driver.get(ReadProperties.getUrl());
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
