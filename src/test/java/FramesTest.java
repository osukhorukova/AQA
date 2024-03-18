import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FramesTest extends BaseTest {
    @Test
    public void frameTest()  {
        driver.get("https://the-internet.herokuapp.com/frames");
        driver.findElement(By.xpath("//*[@id='content']/div/ul/li[2]/a")).click();
        driver.switchTo().frame(0);
        WebElement placeholder = driver.findElement(By.xpath("//*[@id='tinymce']/p"));
        Assert.assertEquals(placeholder.getText(),"Your content goes here.");
        driver.switchTo().parentFrame();
    }
}
