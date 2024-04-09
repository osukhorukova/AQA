package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DashboardPage extends BasePage {
    private final static String pagePath = "/index.php?/dashboard";
    // Блок описания локаторов для элементов
    private final By headerTitleLabelLocator =
            By.xpath("//div[contains(@class, 'content-header-title') and contains(text(),' Projects')]");
    public TopMenuPage topMenuPage;

    // Блок инициализации класса
    public DashboardPage(WebDriver driver) {
        this(driver,false);
    }
    public DashboardPage(WebDriver driver, boolean openPageByUrl) {
        super(driver, openPageByUrl);
        topMenuPage = new TopMenuPage(driver);
        openPageByUrl();
    }

    @Override
    protected WebElement getPageIdentifier() {
        return driver.findElement(headerTitleLabelLocator);
    }

    @Override
    protected String getPagePath() {
        return pagePath;
    }

    // Блок атомарных методов
    public WebElement getHeaderTitleLabel() {
        return driver.findElement(headerTitleLabelLocator);
    }
}