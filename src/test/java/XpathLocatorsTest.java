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

public class XpathLocatorsTest {
    private WebDriver driver;

    @BeforeTest
    public void setup() throws InterruptedException {
        driver = new BrowserService().getDriver();
        driver.get(ReadProperties.getUrl());
        //by xpath (“//tag[@attribute=‘value’]“) - Username input
        driver.findElement(By.xpath("//*[@id='user-name']")).sendKeys(ReadProperties.username());
        //by xpath (“//tag[@attribute=‘value’]“)  - Password input
        driver.findElement(By.xpath("//*[@id='password']")).sendKeys(ReadProperties.password());
        //by xpath (“//tag[@attribute=‘value’]“)   - Clicking "Login" button
        driver.findElement(By.xpath("//*[@class='submit-button btn_action']")).click();
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

    @Test(testName = "Adding items to cart using XPath")
    public void locatorsXpathTest_1() throws InterruptedException {

        //by XPath (“//tag[contains(@attribute,‘text’)]“) - sorting the list by name (Z to A)
        WebElement sorting = driver.findElement(By.xpath("//select[contains(@class,'sort')]"));
        sorting.click();
        Select selectSort = new Select(sorting);
        selectSort.selectByValue("za");
        //by Xpath (“//tag[text()=‘text’]“) - opening "Sauce Labs Onesie", adding it to cart and going back
        driver.findElement(By.xpath("//*[text()='Sauce Labs Onesie']")).click();
        driver.findElement(By.xpath("//*[text()='Add to cart']")).click();
        driver.findElement(By.xpath("//*[text()='Back to products']")).click();
        //by Xpath (“//tag[contains(text(),‘text’)]“) - opening "Sauce Labs Bike Light", adding it to cart and going back
        driver.findElement(By.xpath("//*[contains(text(), 'Lig')]")).click();
        driver.findElement(By.xpath("//*[contains(text(), 'to cart')]")).click();
        driver.findElement(By.xpath("//*[contains(text(), 'Back to')]")).click();
        //by XPath parent - opening cart
        driver.findElement(By.xpath("//a/parent::div")).click();
        //by Xpath child - checking the items counter on the cart navbar icon
        Assert.assertEquals(driver.findElement(By.xpath("//a/child::span")).getText(), "2");
        //by Xpath (“//tag[contains(text(),‘text’)]“) - pressing Checkout button
        driver.findElement(By.xpath("//*[contains(text(), 'Check')]")).click();
        //by Xpath (“//tag[contains(@attribute,‘text’)]“)  - pressing Continue without filling in the form
        driver.findElement(By.xpath("//*[@id='continue']")).click();
        //by Xpath ancestor - checking that the error message appeared
        Assert.assertTrue(driver.findElement(By.xpath("//button/ancestor::h3")).isDisplayed());
        //by Xpath descendant - closing the error message
        driver.findElement(By.xpath("//div[@class='error-message-container error']//descendant::button")).click();
        //by XPath following - checking the presence of linkedin link
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='social_facebook']/following::a")).isDisplayed());
        //by XPath preceding - checking the presence of twitter link
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='social_facebook']/preceding::li")).isDisplayed());
    }
}
