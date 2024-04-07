package pages.projects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.TopMenuPage;

public class EditProjectPage extends ProjectBasePage {
    private final static String pagePath = "/index.php?/admin/projects/add/1";
    public EditProjectPage(WebDriver driver) {
        this(driver, false);
    }

    public EditProjectPage(WebDriver driver, boolean openPageUrl) {
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

}