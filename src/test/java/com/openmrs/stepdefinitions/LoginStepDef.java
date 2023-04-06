package com.openmrs.stepdefinitions;

import com.openmrs.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import utils.ConfigReader;
import utils.DriverHelper;

public class LoginStepDef {
    WebDriver driver = DriverHelper.getDriver();
    LoginPage loginPage = new LoginPage(driver);

    @Given("User provides username, password and {string}")
    public void user_provides_username_password_and(String location) {
        loginPage.Login(ConfigReader.readProperty("QA_username"), ConfigReader.readProperty("QA_password"), location);
    }

    @Then("User validates the {string} and {string}")
    public void user_validates_the_and(String expectedTitle, String expectedUrl) {
        Assert.assertEquals(expectedTitle, driver.getTitle().trim());
        Assert.assertEquals(expectedUrl, driver.getCurrentUrl().trim());
    }

    @Given("User provides {string}, {string} and {string}")
    public void user_provides_and(String username, String password, String location) {
        loginPage.Login(username, password, location);
    }

    @Then("User validates {string} message")
    public void user_validates_message(String errorMessage) {
        loginPage.validateErrorMessage(errorMessage);
    }
}
