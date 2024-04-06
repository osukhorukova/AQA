package steps;

import baseEntities.BaseSteps;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.WebDriver;
import pages.CartPage;
import pages.LoginPage;
import pages.ProductsPage;
import pages.checkout.CompletePage;
import pages.checkout.OverviewPage;
import pages.checkout.YourInformationPage;

public class CheckoutSteps extends BaseSteps {
    CartPage cartPage = new CartPage(driver);

    public CheckoutSteps(WebDriver driver) {
        super(driver);
    }

    public void navigateToCheckout() {
        cartPage.getCheckoutButton().click();
    }

    public void fillInCheckoutForm(String firstName, String lastName, String postalCode) {
        YourInformationPage yourInformationPage = new YourInformationPage(driver);
        yourInformationPage.getFirstNameInput().sendKeys(firstName);
        yourInformationPage.getLastNameInput().sendKeys(lastName);
        yourInformationPage.getPostalCodeInput().sendKeys(postalCode);
        yourInformationPage.getContinueButton().click();
    }

    public void finishCheckout() {
        OverviewPage overviewPage = new OverviewPage(driver);
        overviewPage.getFinishButton().click();
    }

    public void navigateToBackHomeButton() {
        CompletePage completePage = new CompletePage(driver);
        completePage.getBackHomeButton().click();
    }
}