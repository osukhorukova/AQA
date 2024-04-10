package pages.milestones;

import baseEntities.BasePage;
import models.Milestone;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.TopMenuPage;

public abstract class MilestoneBasePage extends BasePage {
    public TopMenuPage topMenuPage;

    //Блок описания локаторов
    @FindBy(id = "name")
    public WebElement milestoneNameInput;

    @FindBy(id = "reference")
    public WebElement milestoneReferenceInput;

    @FindBy(id = "description_display")
    public WebElement milestoneDescriptionInput;

    @FindBy(id = "is_completed")
    public WebElement milestoneCompletedCheckbox;

    public MilestoneBasePage(WebDriver driver) {
        this(driver, false);
    }

    public MilestoneBasePage(WebDriver driver, boolean openPageUrl) {
        super(driver, openPageUrl);
        topMenuPage = new TopMenuPage(driver);
    }

    @Override
    protected WebElement getPageIdentifier() {
        return milestoneNameInput;
    }

    @Override
    protected String getPagePath() {
        return null;
    }

    public MilestoneBasePage setMilestoneName(Milestone milestone){
        milestoneNameInput.sendKeys(milestone.getName());
        return this;
    }
    public MilestoneBasePage setMilestoneReference(Milestone milestone){
        milestoneReferenceInput.sendKeys(milestone.getReference());
        return this;
    }
    public MilestoneBasePage setMilestoneDescription(Milestone milestone){
        milestoneDescriptionInput.sendKeys(milestone.getDescription());
        return this;
    }

    public MilestoneBasePage checkMilestoneCompleted(Milestone milestone){
        if(milestone.isCompleted()) {
            milestoneCompletedCheckbox.click();
        }
        return this;
    }
}