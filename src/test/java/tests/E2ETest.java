package tests;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.ProductsPage;
import pages.checkout.CompletePage;
import pages.checkout.OverviewPage;
import pages.checkout.YourInformationPage;
import steps.CheckoutSteps;
import steps.NavigationSteps;
import steps.ProductsSteps;

public class E2ETest extends BaseTest {
    @Test(testName = "E2E: Buying items as a standard_user")
    public void e2eTest() {
        NavigationSteps navigationSteps = new NavigationSteps(driver);
        navigationSteps.login(ReadProperties.username(), ReadProperties.password());
        Assert.assertTrue(new ProductsPage(driver).isPageOpened());
        ProductsSteps productsSteps = new ProductsSteps(driver);
        productsSteps.selectSorting("lohi");
        productsSteps.addProductByIndexToCart(0);
        navigationSteps.navigateToCart();
        Assert.assertTrue(new CartPage(driver).isPageOpened());
        CheckoutSteps checkoutSteps = new CheckoutSteps(driver);
        checkoutSteps.navigateToCheckout();
        Assert.assertTrue(new YourInformationPage(driver).isPageOpened());
        checkoutSteps.fillInCheckoutForm(ReadProperties.firstName(),ReadProperties.lastName(),ReadProperties.postalCode());
        Assert.assertTrue(new OverviewPage(driver).isPageOpened());
        checkoutSteps.finishCheckout();
        Assert.assertTrue(new CompletePage(driver).isPageOpened());
        Assert.assertEquals(new CompletePage(driver).getTextFromCompleteHeader(), "Thank you for your order!");
        checkoutSteps.navigateToBackHomeButton();
    }
}
