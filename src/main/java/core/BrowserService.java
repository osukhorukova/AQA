package core;

import configuration.ReadProperties;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.sql.DriverManager;
import java.time.Duration;

public class BrowserService {
    WebDriver driver = null;
    DriverManagerType driverManagerType;

    public BrowserService() {
        switch (ReadProperties.browserName().toLowerCase()) {
            case "chrome":
                driverManagerType = DriverManagerType.CHROME;
                WebDriverManager.getInstance(driverManagerType).clearDriverCache().setup();
                driver = new ChromeDriver(getChromeOptions());
                break;
            default:
                System.out.println("Browser " + ReadProperties.browserName() + " is not supported");
                break;
        }
    }
    public WebDriver getDriver(){
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(ReadProperties.timeout()));
        return driver;
    }

    public ChromeOptions getChromeOptions() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-gpu");
        chromeOptions.addArguments("--ignore-certificate-errors");
        chromeOptions.addArguments("--silent");
        chromeOptions.addArguments("--start-maximized");
        //chromeOptions.addArguments("--headless");
        return chromeOptions;
    }


}