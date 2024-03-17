import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DynamicControlsTest extends BaseTest {
    @Test
    public void presenceOfElementsTest() {
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        WebElement checkBox = driver.findElement(By.xpath("//*[@id='checkbox']"));
        WebElement button = waitsService.waitForElementClickable(By.cssSelector("#checkbox-example > button"));
        button.click();
        WebElement goneText = waitsService.waitForVisibilityLocatedBy(By.xpath("//*[@id='message']"));
        Assert.assertEquals(waitsService.waitForElementVisible(goneText), goneText);
        Assert.assertTrue(waitsService.waitForElementInvisible(checkBox));

    }
}
