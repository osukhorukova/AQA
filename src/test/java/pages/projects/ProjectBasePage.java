package pages.projects;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.TopMenuPage;

public abstract class ProjectBasePage extends BasePage {
    public TopMenuPage topMenuPage;

    //Блок описания локаторов
    private final By nameInputLocator = By.id("name");
    private final By announcementTestAreaLocator = By.id("announcement_display");
    private final By showAnnouncementCheckboxLocator = By.id("show_announcement");
    private final By suiteModeSingleTypeLocator = By.id("suite_mode_single");

    public ProjectBasePage(WebDriver driver) {
        this(driver, false);
    }

    public ProjectBasePage(WebDriver driver, boolean openPageUrl) {
        super(driver, openPageUrl);
        topMenuPage = new TopMenuPage(driver);
    }

    public WebElement getNameInput() {
        return waitsService.waitForVisibilityLocatedBy(nameInputLocator);
    }

    public WebElement getAnnouncementTestArea() {
        return waitsService.waitForVisibilityLocatedBy(announcementTestAreaLocator);
    }

    public WebElement getShowAnnouncementCheckbox() {
        return waitsService.waitForVisibilityLocatedBy(showAnnouncementCheckboxLocator);
    }

    public WebElement getSuiteModeSingleType() {
        return waitsService.waitForVisibilityLocatedBy(suiteModeSingleTypeLocator);
    }
}
