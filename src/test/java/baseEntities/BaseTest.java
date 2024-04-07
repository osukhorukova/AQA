package baseEntities;

import configuration.ReadProperties;
import core.BrowserService;
import core.WaitsService;
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
    @BeforeTest
    public void setupData(){
        admin = new User();
        mainProject = new Project();
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
