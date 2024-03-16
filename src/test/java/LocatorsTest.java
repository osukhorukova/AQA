import configuration.ReadProperties;
import core.BrowserService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;


public class LocatorsTest {
    private WebDriver driver;

    @BeforeTest
    public void setup() throws InterruptedException {
        driver = new BrowserService().getDriver();
        driver.get(ReadProperties.getUrl());
        //by ID - Username input
        driver.findElement(By.id("user-name")).sendKeys(ReadProperties.username());
        //by Name - Password input
        driver.findElement(By.name("password")).sendKeys(ReadProperties.password());
        //by className - Clicking "Login" button
        driver.findElement(By.className("submit-button")).click();
        Thread.sleep(1000);
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

    @Test(testName = "Adding items to cart using basic locators")
    public void locatorsBasicTest_2() throws InterruptedException {
        //by tagName - sorting the list by price (low to high)
        WebElement sorting = driver.findElement(By.tagName("select"));
        sorting.click();
        Assert.assertTrue(sorting.isDisplayed());
        Select selectSort = new Select(sorting);
        selectSort.selectByValue("lohi");
        //by linkText - clicking on the item "Sauce Labs Onesie"
        driver.findElement(By.linkText("Sauce Labs Onesie")).click();
        //by id - adding the item "Sauce Labs Onesie" to cart
        driver.findElement(By.id("add-to-cart-sauce-labs-onesie")).click();
        //by id - going back to Products page
        driver.findElement(By.id("back-to-products")).click();
        //by partialLinkText - clicking on the item "Sauce Labs Backpack"
        driver.findElement(By.partialLinkText("Labs Backpack")).click();
        //by id - going back to Products page
        driver.findElement(By.id("back-to-products")).click();
    }
}