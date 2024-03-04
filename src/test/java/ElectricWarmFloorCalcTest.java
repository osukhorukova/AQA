import core.BrowserService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.lang.ref.SoftReference;

public class ElectricWarmFloorCalcTest extends BaseTest {
    BrowserService browserService = new BrowserService();
    WebDriver driver = browserService.gerDriver();

    @Test
    public void browserServiceTest() throws InterruptedException {
        driver.get("https://kermi-fko.ru/raschety/Calc-Rehau-Solelec.aspx");
        WebElement floorWidth = driver.findElement(By.id("el_f_width"));
        WebElement floorLength = driver.findElement(By.id("el_f_lenght"));
        WebElement roomType = driver.findElement(By.id("room_type"));
        WebElement floorLosses = driver.findElement(By.id("el_f_losses"));
        WebElement heatingType = driver.findElement(By.id("heating_type"));

        floorWidth.sendKeys("5");
        Thread.sleep(2000);
        floorLength.sendKeys("6");
        Thread.sleep(2000);
        Select selectRoom = new Select(roomType);
        Thread.sleep(2000);
        selectRoom.selectByValue("2");
        Thread.sleep(2000);
        Select selectHeatingType = new Select(heatingType);
        Thread.sleep(2000);
        selectHeatingType.selectByValue("3");
        Thread.sleep(2000);
        floorLosses.sendKeys("41484");
        Thread.sleep(2000);

        WebElement button = driver.findElement(By.name("button"));
        button.click();

        Thread.sleep(2000);

        WebElement floorCablePower = driver.findElement(By.id("floor_cable_power"));
        WebElement specFloorCablePower = driver.findElement(By.id("spec_floor_cable_power"));

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(floorCablePower.getAttribute("value"), "23086", "Something went wrong...");
        softAssert.assertEquals(specFloorCablePower.getAttribute("value"), "770", "Something went wrong...");

        softAssert.assertAll();

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
