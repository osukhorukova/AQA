import configuration.ReadProperties;
import core.BrowserService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
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
    public void tearDown() {
        driver.quit();
    }

    @Test(testName = "Adding items to cart using CSS locators")
    public void locatorsCssTest_1() throws InterruptedException {

        //by css tagName - sorting the list by name (Z to A)
        WebElement sorting = driver.findElement(By.cssSelector("select"));
        sorting.click();
        Thread.sleep(1000);
        Select selectSort = new Select(sorting);
        selectSort.selectByValue("za");
        Thread.sleep(1000);
        //by .class - opening the hamburger menu
        driver.findElement(By.cssSelector(".bm-burger-button")).click();
        Thread.sleep(1000);
        //by tagName.class - closing the hamburger menu
        driver.findElement(By.cssSelector("div.bm-cross-button")).click();
        Thread.sleep(1000);
        //by [attribute=value] - adding "Sauce Labs Backpack" to cart
        driver.findElement(By.cssSelector("[data-test='add-to-cart-sauce-labs-backpack']")).click();
        Thread.sleep(1000);
        //by .class1 .class2 - opening cart
        driver.findElement(By.cssSelector(".primary_header .shopping_cart_container")).click();
        Thread.sleep(1000);
        //by [attribute$=value] - checking the items counter on the cart navbar icon
        Assert.assertEquals(driver.findElement(By.cssSelector("[class$='badge']")).getText(), "1");
        Thread.sleep(1000);
        //by [attribute|=value] - going back to shopping
        driver.findElement(By.cssSelector("[name|='continue']")).click();
        Thread.sleep(1000);
        //by [attribute^=value] - checking the presence of twitter link
        Assert.assertTrue(driver.findElement(By.cssSelector("[href^='https://twitter']")).isDisplayed());
        Thread.sleep(1000);
        //by [] - checking the presence of facebook link
        Assert.assertTrue(driver.findElement(By.cssSelector("[class~='social_facebook']")).isDisplayed());
        Thread.sleep(1000);
        //by [attribute*=value] - checking the presence of linkedin link
        Assert.assertTrue(driver.findElement(By.cssSelector("[href*='linkedin']")).isDisplayed());
        Thread.sleep(1000);
    }
}
