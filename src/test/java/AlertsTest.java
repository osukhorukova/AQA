import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AlertsTest extends BaseTest {
    @Test
    public void alertTest() {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement button = waitsService.waitForElementClickable(By.xpath("//*[text()='Click for JS Prompt']"));
        button.click();
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(), "I am a JS prompt");
        alert.sendKeys("Hello, world!");
        alert.accept();
        Assert.assertEquals(waitsService.waitForVisibilityLocatedBy(By.xpath("//*[@id='result']")).getText(), "You entered: Hello, world!");
    }
}