package by.bsu.automation.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage extends AbstractPage
{
    private final String BASE_URL = "http://ok.ru/profile/575979020709";
    private final Logger logger = Logger.getLogger(DashboardPage.class);

    @FindBy(xpath = "//a[@class='mctc_nameLink bl']")
    private WebElement username;

    @FindBy(id = "posting_form_text_field")
    private WebElement newPostButton;

    @FindBy(xpath = "//div[@id ='posting_form_text_field']")
    private WebElement postField;

    @FindBy(xpath = "//input[@class='button-pro']")
    private WebElement postButton;

    @FindBy(xpath = "//div[@class='media-text_cnt_tx']")
    private WebElement post;

    @FindBy(id = "hook_ToolbarIconMusic_ToolbarIconMusic")
    private WebElement player;

    @FindBy(xpath = "//input[@placeholder='Искать песни на сайте']")
    private WebElement playerSearchaArea;

    @FindBy(xpath = "//a[@class='vl_btn']")
    private WebElement playerSearchSubmit;

    @FindBy(id = "p0m_sec_search_result74334128600135")
    private WebElement playerPlayButton;

    @FindBy(id = "hook_ToolbarIconMessages_ToolbarMessages")
    private WebElement messages;

    @FindBy(id = "ok-e-m")
    private WebElement messageTextArea;

    @FindBy(xpath = "//div[@uid='uidTrigerSendMsg']")
    private WebElement messageSendButton;

    @FindBy(xpath = "//div[@class='rev_cnt']")
    private WebElement status;

    @FindBy(xpath = "//div[@data-placeholder='Комментировать']")
    private WebElement statusCommentTextArea;

    @FindBy(xpath = "//button[@class='button-pro']")
    private WebElement statusCommentSubmit;

    @FindBy(xpath = "//span[text() = 'This is automation test']")
    private WebElement statusCommentText;

    public DashboardPage(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public void openPage()
    {
        driver.navigate().to(BASE_URL);
        logger.info("Opened dashboard page");
    }

    public String getLoggedInUserName()
    {
        return username.getText();
    }

    public void postMessage(String message)
    {
        newPostButton.click();
        postField.sendKeys(message);
        postButton.click();
        logger.info("Posted Message");
    }
    public void playerTurnOn(String performer)
    {
        player.click();
        playerSearchaArea.sendKeys(performer);
        playerSearchSubmit.click();
        logger.info("Finded performer");
        //playerPlayButton.click();

    }
    public void sendMessage(String message)
    {
        messages.click();
        messageTextArea.click();
        driver.switchTo().activeElement().sendKeys(message);
        messageSendButton.click();
        logger.info("Sended message to Kochneva");
    }
    public void leaveComment(String comment){
        status.click();
        statusCommentTextArea.click();
        driver.switchTo().activeElement().sendKeys(comment);
        driver.switchTo().activeElement().sendKeys(Keys.CONTROL, Keys.ENTER);
        //statusCommentSubmit.click();
        logger.info("Left comment for status");
    }
    public String getComment()
    {
        status.click();
        return statusCommentText.getText();
    }
    public String getPost()
    {
        return post.getText();
    }
}