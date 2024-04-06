package pages.checkout;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CompletePage extends BasePage {
    private final static String pagePath = "/checkout-complete.html";

    // Блок описания локаторов для элементов
    private final By completeHeaderLocator = By.className("complete-header");
    private final By backHomeButtonLocator = By.id("back-to-products");

    // Блок инициализации класса

    public CompletePage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return completeHeaderLocator;
    }

    @Override
    protected String getPagePath() {
        return pagePath;
    }

    // Блок атомарных методов
    public String getTextFromCompleteHeader() {
        return waitsService.waitForVisibilityLocatedBy(completeHeaderLocator).getText();
    }

    public WebElement getBackHomeButton() {
        return waitsService.waitForVisibilityLocatedBy(backHomeButtonLocator);
    }
}