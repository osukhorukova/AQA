package steps;

import baseEntities.BaseSteps;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pages.ProductsPage;

public class ProductsSteps extends BaseSteps {
    private ProductsPage productsPage;

    public ProductsSteps(WebDriver driver) {
        super(driver);
    }

    public void addProductByIndexToCart(int position) {
        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.getAddOneItemButton(position).click();
    }

    public void selectSorting(String sortParam) {
        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.getSortContainer().click();
        Select selectSort = new Select(productsPage.getSortContainer());
        selectSort.selectByValue(sortParam);
    }
}
