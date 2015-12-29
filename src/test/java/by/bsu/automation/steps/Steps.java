package by.bsu.automation.steps;

import java.util.concurrent.TimeUnit;

import by.bsu.automation.pages.DashboardPage;
import by.bsu.automation.pages.OkLoginPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Steps
{
    private WebDriver driver;

    private final Logger logger = Logger.getLogger(Steps.class);

    public void initBrowser()
    {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(45, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
        logger.info("Initialized browser");
    }

    public void closeDriver()
    {
        driver.quit();
        logger.info("Stopped browser");
    }

    public void loginOk(String phone, String password)
    {
        OkLoginPage loginPage = new OkLoginPage(driver);
        loginPage.openPage();
        loginPage.login(phone, password);
    }
    public boolean isLoggedIn(String username) {
        DashboardPage dashboardPage = new DashboardPage(driver);
        dashboardPage.openPage();
        return (username.equals(dashboardPage.getLoggedInUserName()));
    }
    public void postMessageOk(String message){
        DashboardPage dashboardPage = new DashboardPage(driver);
        dashboardPage.openPage();
        dashboardPage.postMessage(message);
    }
    public boolean hasPost(String post)
    {
        DashboardPage dashboardPage = new DashboardPage(driver);
        openNewTab();
        dashboardPage.openPage();
        return (post.equals(dashboardPage.getPost()));
    }
    public void playerTurnOn(String performer){
        DashboardPage dashboardPage = new DashboardPage(driver);
        dashboardPage.openPage();
        dashboardPage.playerTurnOn(performer);
        //return (performer.equals(dashboardPage.getPerformer()));
    }
    public void sendMessage(String message){
        DashboardPage dashboardPage = new DashboardPage(driver);
        dashboardPage.openPage();
        dashboardPage.sendMessage(message);

    }
    public boolean getMessage(String message)
    {
        DashboardPage dashboardPage = new DashboardPage(driver);
        openNewTab();
        dashboardPage.openPage();
        return (message.equals(dashboardPage.getkSendedMessage()));
    }
    public void leaveComment(String comment){
        DashboardPage dashboardPage = new DashboardPage(driver);
        dashboardPage.openPage();
        dashboardPage.leaveComment(comment);
    }
    public boolean getComment(String comment)
    {
        DashboardPage dashboardPage = new DashboardPage(driver);
        openNewTab();
        dashboardPage.openPage();
        return (comment.equals(dashboardPage.getComment()));
    }

    private void openNewTab() {
        driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "t");
        logger.info("Opened new tab");
    }
}
