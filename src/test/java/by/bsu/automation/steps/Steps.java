package by.bsu.automation.steps;

import java.util.concurrent.TimeUnit;

import by.bsu.automation.pages.DashboardPage;
import by.bsu.automation.pages.OkLoginPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


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
    }
    public void sendMessage(String message){
        DashboardPage dashboardPage = new DashboardPage(driver);
        dashboardPage.openPage();
        dashboardPage.sendMessage(message);
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
    /*public void loginOk(String username, String password)
    {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openPage();
        loginPage.login(username, password);
    }

    public boolean isLoggedIn(String username)
    {
        DashboardPage dashboardPage = new DashboardPage(driver);
        dashboardPage.openPage();
        return (username.equals(dashboardPage.getLoggedInUserName()));
    }

    public void postLinkTumblr(String link){
        DashboardPage dashboardPage = new DashboardPage(driver);
        dashboardPage.openPage();
        dashboardPage.postMessage(link);
    }

    public boolean hasPost(String link)
    {
        BlogPage blogPage = new BlogPage(driver);
        openNewTab();
        blogPage.openPage();
        return (link.equals(blogPage.getLink()));
    }

    public boolean isTagged(String searchTerm) {
        SearchPage searchPage = new SearchPage(driver);
        return(searchPage.isPresentInAllPosts(searchTerm));
    }

    private void openNewTab() {
        driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "t");
        logger.info("Opened new tab");
    }*/
}
