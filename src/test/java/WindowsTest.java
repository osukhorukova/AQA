import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class WindowsTest extends BaseTest {
    @Test
    public void frameTest() {
        driver.get("https://the-internet.herokuapp.com/windows");

        String originalWindowHandle = driver.getWindowHandle();

        driver.findElement(By.linkText("Click Here")).click();
        driver.findElement(By.linkText("Click Here")).click();

        Set<String> windowHandleSet = driver.getWindowHandles();
        List<String> windowHandleList = new ArrayList<>(windowHandleSet);

        driver.switchTo().window(windowHandleList.get(1));
        driver.switchTo().window(windowHandleList.get(2));

        Assert.assertEquals(waitsService.waitForVisibilityLocatedBy(By.tagName("h3")).getText(), "New Window");
        driver.close();
        driver.switchTo().window(originalWindowHandle);
        Assert.assertEquals(driver.getWindowHandles().size(), 2);
    }
}
