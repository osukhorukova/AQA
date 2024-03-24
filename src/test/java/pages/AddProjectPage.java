package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddProjectPage extends BasePage {
    private final static String pagePath = "/index.php?/admin/projects/add/1";

    //Блок описания локаторов
    private final By nameInputLocator = By.id("name");
    private final By announcementTestAreaLocator = By.id("announcement_display");
    private final By showAnnouncementCheckboxLocator = By.id("show_announcement");
    private final By suiteModeSingleTypeLocator = By.id("suite_mode_single");
    public TopMenuPage topMenuPage;

    public AddProjectPage(WebDriver driver) {
        this(driver, false);
    }

    public AddProjectPage(WebDriver driver, boolean openPageUrl) {
        super(driver, openPageUrl);
        topMenuPage = new TopMenuPage(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return null;
    }

    @Override
    protected String getPagePath() {
        return pagePath;
    }


    // Блок атомарных методов
    public WebElement getNameInput() {
        return driver.findElement(nameInputLocator);
    }

    public WebElement getAnnouncementTestArea() {
        return driver.findElement(announcementTestAreaLocator);
    }

    public WebElement getShowAnnouncementCheckbox() {
        return driver.findElement(showAnnouncementCheckboxLocator);
    }

    public WebElement getSuiteModeSingleType() {
        return driver.findElement(suiteModeSingleTypeLocator);
    }
}
