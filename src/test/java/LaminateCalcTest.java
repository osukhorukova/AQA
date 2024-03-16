import core.BrowserService;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class LaminateCalcTest extends BaseTest {
    BrowserService browserService = new BrowserService();
    WebDriver driver = browserService.gerDriver();

    @Test
    public void browserServiceTest() throws InterruptedException {
        driver.get("https://calc.by/building-calculators/laminate.html");

        WebElement roomLength = driver.findElement(By.id("ln_room_id"));
        roomLength.clear();
        roomLength.sendKeys("500");
        WebElement roomWidth = driver.findElement(By.id("wd_room_id"));
        roomWidth.clear();
        roomWidth.sendKeys("400");
        WebElement layingMethodLaminate = driver.findElement(By.id("laying_method_laminate"));
        Select selectLayingMethod = new Select(layingMethodLaminate);
        selectLayingMethod.selectByValue("0");
        WebElement lengthLaminate = driver.findElement(By.id("ln_lam_id"));
        lengthLaminate.clear();
        lengthLaminate.sendKeys("2000");
        WebElement widthLaminate = driver.findElement(By.id("wd_lam_id"));
        widthLaminate.clear();
        widthLaminate.sendKeys("200");
        WebElement directionLaminate = driver.findElement(By.id("direction-laminate-id1"));
        directionLaminate.click();

        WebElement calc_btn = driver.findElement(By.className("calc-btn-div"));
        calc_btn.click();

        Assert.assertEquals(driver.findElement(By.className("calc-result")).getText().trim().replace("\r", ""),
                "Требуемое количество досок ламината: 51\n" +
                        "Количество упаковок ламината: 7\n" +
                        "Ниже представлена схема укладки ламината");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
