package com.openmrs.hook;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import utils.BrowserUtils;
import utils.ConfigReader;
import utils.DriverHelper;

public class OpenMRSHook {
    protected WebDriver driver;

    @Before
    public void setup() {
        driver = DriverHelper.getDriver();
        driver.navigate().to(ConfigReader.readProperty("QA_openMRSUrl"));
    }

    @After
    public void tearDown(Scenario scenario) throws InterruptedException {
        BrowserUtils.getScreenShotForCucumber(driver, scenario);
        driver.quit();
    }
}
