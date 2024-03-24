package core;

import configuration.ReadProperties;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.io.File;
import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

public class WaitsService {
    private WebDriver driver;
    private Duration timeout;
    WebDriverWait wait;

    public WaitsService(WebDriver driver, Duration timeout) {
        this.driver = driver;
        this.timeout = timeout;
        new WebDriverWait(driver, timeout);
    }

    public WaitsService(WebDriver driver) {
        this.driver = driver;
        this.timeout = Duration.ofSeconds(ReadProperties.timeout());
        wait = new WebDriverWait(driver, this.timeout);
    }

    // аналог find WebElement
    public WebElement waitForExists(By by) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public WebElement waitForElementClickable(By by) {
        return wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    public Boolean waitForElementInvisible(WebElement webElement) {
        return wait.until(ExpectedConditions.invisibilityOf(webElement));
    }

    public WebElement waitForElementVisible(WebElement webElement) {
        return wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    // это по сути цикл do until
    public WebElement waitForVisibilityLocatedBy(By by) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public List<WebElement> waitForAllVisibleElementsLocatedBy(By locator) {
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    public WebElement fluentWaitForElement(By by) {
        FluentWait<WebDriver> fluent = new FluentWait<>(driver)
                .withTimeout(timeout)
                .pollingEvery(Duration.ofMillis(50))
                .ignoring(NoSuchElementException.class);
        return fluent.until(driver -> driver.findElement(by));
    }
}
