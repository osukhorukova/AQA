package pages.projects;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.TopMenuPage;

public class AddProjectPage extends ProjectBasePage {

    //Блок описания локаторов
    private final By addProjectButtonLocator = By.id("accept");
    private final static String pagePath = "/index.php?/admin/projects/add/1";
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

    public WebElement getAddProjectButton() {
        return waitsService.waitForVisibilityLocatedBy(addProjectButtonLocator);
    }

}
