package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {
    private final static String pagePath = "";
    // Блок описания локаторов для элементов
    private final By usernameInputLocator = By.id("user-name");
    private final By passwordInputLocator = By.id("password");
    private final By loginButtonLocator = By.id("login-button");

    // Блок инициализации класса
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return usernameInputLocator;
    }

    @Override
    protected String getPagePath() {
        return pagePath;
    }

    // Блок атомарных методов
    public WebElement getUsernameInput() {
        return waitsService.waitForVisibilityLocatedBy(usernameInputLocator);
    }

    public WebElement getPasswordInput() {
        return waitsService.waitForVisibilityLocatedBy(passwordInputLocator);
    }

    public WebElement getLoginButton() {
        return waitsService.waitForVisibilityLocatedBy(loginButtonLocator);
    }

    public void clickLoginButton() {
        getLoginButton().click();
    }
}
