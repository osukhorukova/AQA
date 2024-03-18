import com.fasterxml.jackson.databind.ser.Serializers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FileUploadTest extends BaseTest {
    @Test
    public void fileUploadTest() {
        driver.get("https://the-internet.herokuapp.com/upload");

        WebElement checkBox = driver.findElement(By.xpath("//*[@id='checkbox']"));
        WebElement button = waitsService.waitForElementClickable(By.cssSelector("#checkbox-example > button"));
        button.click();
        WebElement goneText = waitsService.waitForVisibilityLocatedBy(By.xpath("//*[@id='message']"));
        Assert.assertEquals(waitsService.waitForElementVisible(goneText), goneText);
        Assert.assertTrue(waitsService.waitForElementInvisible(checkBox));

    }
}
