import org.apache.commons.io.input.WindowsLineEndingInputStream;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.util.List;

public class FileDownloadTest extends BaseTest {
    @Test
    public void fileDownloadTest() {
        driver.get("https://the-internet.herokuapp.com/download");
        List<WebElement> downloadableFiles = waitsService.waitForAllVisibleElementsLocatedBy(By.xpath("//*[@id='content'/div/a"));
        WebElement itemToDownload = downloadableFiles.get(0);
        itemToDownload.click();
        File folder = new File(System.getProperty("user.dir"));
        File[] listOfFiles = folder.listFiles();
        boolean found = false;
        File f = null;

        assert listOfFiles != null;
        for (File listOfFile : listOfFiles) {
            if (listOfFile.isFile()) {
                String fileName = listOfFile.getName();
                System.out.println("File " + listOfFile.getName());
                if (fileName.matches("spectrum-logo.png")) {
                    f = new File(fileName);
                    found = true;
                }

            }
            Assert.assertTrue(found, "Downloaded document is not found");
            f.deleteOnExit();
        }
    }
}


