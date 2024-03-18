import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContextMenuTest extends BaseTest {
    @Test
    public void presenceOfElementsTest()  {
        driver.get("https://the-internet.herokuapp.com/context_menu");
        Actions actions = new Actions(driver);

        WebElement button = waitsService.waitForElementClickable(By.id("hot-spot"));
        actions
                .moveToElement(button,50,50)
                .contextClick()
                .build()
                .perform();
        WebElement alertMessage = waitsService.waitForVisibilityLocatedBy(By.xpath("//*[@id='content']/script"));
        Assert.assertEquals(alertMessage.getText(),"You selected a context menu");
    }
}
