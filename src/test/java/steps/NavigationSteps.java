package steps;

import org.openqa.selenium.WebDriver;
import pages.DashboardPage;
import pages.LoginPage;
import baseEntities.BaseSteps;

public class NavigationSteps extends BaseSteps{
    private LoginPage loginPage;
    private DashboardPage dashboardPage;
    public NavigationSteps(WebDriver driver) {
        super(driver);
    }

    public void login(String username, String password) {
        loginPage = new LoginPage(driver);
        loginPage.getEmailInput().sendKeys(username);
        loginPage.getPasswordInput().sendKeys(password);
        loginPage.clickLoginButton();
    }
    public void navigateToDashboardByUrl(){
        dashboardPage = new DashboardPage(driver,true);
    }
}
