package baseEntities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BaseSteps {
    protected WebDriver driver;

    public BaseSteps(WebDriver driver){
        this.driver = driver;
    }
}
