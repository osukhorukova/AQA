package pages.projects;

import baseEntities.BasePage;
import com.github.dockerjava.core.dockerfile.DockerfileStatement;
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
    public AddProjectPage setName(String value){
        return this;
    }
    public AddProjectPage setAnnouncement(String value){
        return this;
    }
    public AddProjectPage setShowAnnouncement(){
        return this;
    }
    public AddProjectPage removeShowAnnouncement(){
        return this;
    }
    public AddProjectPage setProjectType(int value){
        return this;
    }
    public AddProjectPage setEnableTCApproval(){
        return this;
    }
    public AddProjectPage removeEnableTCApproval(){
        return this;
    }
}
