package pages.checkout;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class YourInformationPage extends BasePage {
    private final static String pagePath = "/checkout-step-one.html";

    // Блок описания локаторов для элементов
    private final By firstNameLocator = By.id("first-name");
    private final By lastNameLocator = By.id("last-name");
    private final By postalCodeLocator = By.id("postal-code");
    private final By continueButtonLocator = By.id("continue");

    // Блок инициализации класса
    public YourInformationPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return firstNameLocator;
    }

    @Override
    protected String getPagePath() {
        return pagePath;
    }

    // Блок атомарных методов
    public WebElement getFirstNameInput() {
        return waitsService.waitForVisibilityLocatedBy(firstNameLocator);
    }

    public WebElement getLastNameInput() {
        return waitsService.waitForVisibilityLocatedBy(lastNameLocator);
    }

    public WebElement getPostalCodeInput() {
        return waitsService.waitForVisibilityLocatedBy(postalCodeLocator);
    }

    public WebElement getContinueButton() {
        return waitsService.waitForVisibilityLocatedBy(continueButtonLocator);
    }
}
