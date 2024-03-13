import configuration.ReadProperties;
import core.BrowserService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class CssLocatorsTest {
    private WebDriver driver;

    @BeforeTest
    public void setup() throws InterruptedException {
        driver = new BrowserService().getDriver();
        driver.get(ReadProperties.getUrl());
        //by css #id - Username input
        driver.findElement(By.cssSelector("#user-name")).sendKeys(ReadProperties.username());
        //by css #id - Password input
        driver.findElement(By.cssSelector("#password")).sendKeys(ReadProperties.password());
        //by css .class1.class2 - Clicking "Login" button
        driver.findElement(By.cssSelector(".submit-button.btn_action")).click();
        Thread.sleep(1000);
    }

    @AfterTest
    public void tearDown() {driver.quit();
    }

    @Test(testName = "Adding items to cart using CSS locators")
    public void locatorsCssTest_2() throws InterruptedException {

        // Find webElement by tagName - sorting the list by price (low to high)
        WebElement sorting = driver.findElement(By.tagName("select"));
        sorting.click();
        Thread.sleep(1000);
        Select selectSort = new Select(sorting);
        selectSort.selectByValue("lohi");
        Thread.sleep(1000);

        // Find webElement by linkText - clicking on the item "Sauce Labs Onesie"
        driver.findElement(By.linkText("Sauce Labs Onesie")).click();
        Thread.sleep(1000);

        // Find webElement by id - adding the item "Sauce Labs Onesie" to cart
        driver.findElement(By.id("add-to-cart-sauce-labs-onesie")).click();
        Thread.sleep(1000);

        // Find webElement by id - going back to Products page
        driver.findElement(By.id("back-to-products")).click();
        Thread.sleep(1000);

        // Find webElement by partialLinkText - clicking on the item "Sauce Labs Backpack"
        driver.findElement(By.partialLinkText("Labs Backpack")).click();
        Thread.sleep(1000);

        // Find webElement by id - going back to Products page
        driver.findElement(By.id("back-to-products")).click();
        Thread.sleep(1000);
    }
}