package by.bsu.automation;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import by.bsu.automation.steps.Steps;

public class OdnoklassnikiAutomationTest {
    private Steps steps;
    private final String USERNAME = "Кочнева Анастасия";
    private final String PHONE = "375257120870";
    private final String PASSWORD = "testepam1";
    private final String MESSAGE = "This is automation test";
    private final String PERFORMER = "Александр Солодуха";

    @BeforeMethod (description = "Init browser")
    public void setUp() {
        steps = new Steps();
        steps.initBrowser();
    }
    @Test (description = "Login to Ok")
    public void oneCanLoginOdnoklassniki() {
        steps.loginOk(PHONE,PASSWORD);
        Assert.assertTrue(steps.isLoggedIn(USERNAME));
    }
    @Test (description = "Post a new message to Ok")
    public void oneCanPostMessage() {
        steps.loginOk(PHONE, PASSWORD);
        steps.postMessageOk(MESSAGE);
        Assert.assertTrue(steps.hasPost(MESSAGE));
    }
    @Test (description = "Find performer in player")
    public void oneCanTurnOnPlayer() {
        steps.loginOk(PHONE, PASSWORD);
        steps.playerTurnOn(PERFORMER);
    }
    @Test (description = "Send message")
    public void oneCanSendMessage() {
        steps.loginOk(PHONE, PASSWORD);
        steps.sendMessage(MESSAGE);
    }
    @Test (description = "Leave comment for status")
    public void oneCanLeaveComments() {
        steps.loginOk(PHONE, PASSWORD);
        steps.leaveComment(MESSAGE);
        Assert.assertTrue(steps.getComment(MESSAGE));
    }
    @AfterMethod (description = "Stop Browser")
    public void stopBrowser() {
        steps.closeDriver();
    }
}