package pages.checkout;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OverviewPage extends BasePage {
    private final static String pagePath = "/checkout-step-two.html";

    // Блок описания локаторов для элементов
    private final By finishButtonLocator = By.id("finish");

    // Блок инициализации класса

    public OverviewPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return finishButtonLocator;
    }

    @Override
    protected String getPagePath() {
        return pagePath;
    }

    // Блок атомарных методов
    public WebElement getFinishButton() {
        return waitsService.waitForVisibilityLocatedBy(finishButtonLocator);
    }
}
