import com.fasterxml.jackson.databind.ser.Serializers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Objects;

public class FileUploadTest extends BaseTest {
    @Test
    public void fileUploadTest() {
        driver.get("https://the-internet.herokuapp.com/upload");
        WebElement fileUploadButton = waitsService.waitForVisibilityLocatedBy(By.id("file-upload"));
        String path = Objects.requireNonNull(FileUploadTest.class.getClassLoader().getResource("Coffee_OpenGraph.png")).getPath();
        fileUploadButton.sendKeys(path);
        waitsService.waitForElementVisible(fileUploadButton).submit();
        Assert.assertEquals(waitsService.waitForElementClickable(By.id("uploaded-files")).getText(), "Coffee_OpenGraph.png");
    }
}
