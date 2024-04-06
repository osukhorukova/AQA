package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ProductsPage extends BasePage {
    private final static String pagePath = "/inventory.html";
    // Блок описания локаторов для элементов
    private final By itemLocator = By.className("inventory_item");
    private final By sortContainerLocator = By.className("product_sort_container");
    private final By addItemButtonLocator = By.className("btn_inventory");
    private final By cartButtonLocator = By.className("shopping_cart_link");

    // Блок инициализации класса
    public ProductsPage(WebDriver driver) {
        this(driver, false);
    }

    public ProductsPage(WebDriver driver, boolean openPageByUrl) {
        super(driver, openPageByUrl);
        openPageByUrl();
    }

    @Override
    protected By getPageIdentifier() {
        return itemLocator;
    }

    @Override
    protected String getPagePath() {
        return pagePath;
    }

    // Блок атомарных методов
    public boolean isPageOpened() {
        return driver.findElement(itemLocator).isDisplayed();
    }

    public WebElement getSortContainer() {
        return waitsService.waitForVisibilityLocatedBy(sortContainerLocator);
    }

    public WebElement getAddOneItemButton(int index) {
        return waitsService.waitForAllVisibleElementsLocatedBy(addItemButtonLocator).get(index);
    }

    public WebElement getCartButton() {
        return waitsService.waitForVisibilityLocatedBy(cartButtonLocator);
    }
}