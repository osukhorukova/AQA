import configuration.ReadProperties;
import core.BrowserService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class LocatorsTest {
    private WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new BrowserService().getDriver();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test (testName = "Signing in as a standard user")
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

        @Test (testName = "Adding items to cart")
        public void locatorsBasicTest_2() throws InterruptedException {
            driver.get(ReadProperties.getUrl());

            // Find webElement by tagName - sorting the list by price (low to high)
            driver.findElement(By.tagName("select")).click();

            // Find webElement by linkText
            driver.findElement(By.linkText("Forgot your password?")).click();

            // Find webElement by linkText
            driver.findElement(By.partialLinkText("your password?")).click();
        }
}

