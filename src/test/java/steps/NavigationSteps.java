package steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import pages.ProductsPage;
import pages.LoginPage;
import baseEntities.BaseSteps;

public class NavigationSteps extends BaseSteps {
    private LoginPage loginPage;
    private ProductsPage productsPage;

    public NavigationSteps(WebDriver driver) {
        super(driver);
    }

    public void login(String username, String password) {
        loginPage = new LoginPage(driver);
        loginPage.getUsernameInput().sendKeys(username);
        loginPage.getPasswordInput().sendKeys(password);
        loginPage.clickLoginButton();
    }

    public void navigateToProductPageByUrl() {
        productsPage = new ProductsPage(driver, true);
    }

    public void navigateToCart() {
        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.getCartButton().click();
    }
}
