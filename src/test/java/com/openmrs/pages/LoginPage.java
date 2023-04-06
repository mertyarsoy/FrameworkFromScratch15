package com.openmrs.pages;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

import java.security.Key;
import java.util.List;

public class LoginPage {
    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id='username']")
    WebElement username;
    @FindBy(xpath = "//input[@id='password']")
    WebElement password;
    @FindBy(xpath = "//ul[@id='sessionLocation']//li")
    List<WebElement> sessions;
    public void Login(String username, String password, String session) {
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        for (int i = 0; i < sessions.size(); i++) {
            if (BrowserUtils.getTextandTrim(sessions.get(i)).contains(session)) {
                sessions.get(i).click();
                sessions.get(i).sendKeys(Keys.ENTER);
                break;
            }
        }
    }

    @FindBy(css = "#error-message")
    WebElement errorMessage;
    public void validateErrorMessage(String errorMessage) {
        Assert.assertTrue(BrowserUtils.getTextandTrim(this.errorMessage).contains(errorMessage));
    }

}
