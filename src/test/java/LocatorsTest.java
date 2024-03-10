import configuration.ReadProperties;
import core.BrowserService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;


public class LocatorsTest {
    private WebDriver driver;

    @BeforeTest
    public void setup() {
        driver = new BrowserService().getDriver();
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

    @Test(testName = "Signing in as a standard user")
    public void locatorsBasicTest_1() throws InterruptedException {
        driver.get(ReadProperties.getUrl());

        // Find webElement by ID - Username input
        driver.findElement(By.id("user-name")).sendKeys(ReadProperties.username());
        Thread.sleep(1000);
        // Find webElement by Name - Password input
        driver.findElement(By.name("password")).sendKeys(ReadProperties.password());
        Thread.sleep(1000);
        // Find webElement by className - Clicking "Login" button
        driver.findElement(By.className("submit-button")).click();
        Thread.sleep(1000);
    }

    @Test(testName = "Adding items to cart using basic locators", dependsOnMethods = "locatorsBasicTest_1")
    public void locatorsBasicTest_2() throws InterruptedException {

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

//    @Test(testName = "Adding items to cart using CSS locators", dependsOnMethods = "locatorsBasicTest_1")
//    public void locatorsCssTest() throws InterruptedException {
//
//    }
}

