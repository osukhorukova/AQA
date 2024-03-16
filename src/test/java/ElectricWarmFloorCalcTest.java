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
        floorLength.sendKeys("6");
        Select selectRoom = new Select(roomType);
        selectRoom.selectByValue("2");
        Select selectHeatingType = new Select(heatingType);
        selectHeatingType.selectByValue("3");
        floorLosses.sendKeys("41484");

        WebElement button = driver.findElement(By.name("button"));
        button.click();

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
