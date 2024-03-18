import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class JSTest extends BaseTest{
    @Test
    public void jsTest(){
        driver.get("https://the-internet.herokuapp.com/jqueryui/menu#");
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        WebElement webElement = driver.findElement(By.id("ui-id-2"));
        jsExecutor.executeScript("arguments[0].click();",webElement);
    }
}
