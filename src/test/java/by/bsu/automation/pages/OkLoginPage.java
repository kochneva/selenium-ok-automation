package by.bsu.automation.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OkLoginPage extends AbstractPage
{
    private final String BASE_URL = "http://ok.ru";
    private final Logger logger = Logger.getLogger(OkLoginPage.class);

    @FindBy(id = "field_email")
    private WebElement inputPhone;

    @FindBy(id = "field_password")
    private WebElement inputPassword;

    @FindBy(xpath = "//input[@class='button-pro __orange inlineBlock']")
    private WebElement submitButton;

    /*@FindBy(xpath = "//span[@class='blog-list-item-info-name']")
    private WebElement username;*/

    public OkLoginPage(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public void openPage()
    {
        driver.navigate().to(BASE_URL);
        logger.info("Opened login page");
    }

    public void login(String phone, String password)
    {
        inputPhone.sendKeys(phone);
        inputPassword.sendKeys(password);
        submitButton.click();
        logger.info("Logged in");
    }
}