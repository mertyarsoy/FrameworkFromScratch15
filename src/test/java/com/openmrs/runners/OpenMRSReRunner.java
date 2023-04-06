package com.openmrs.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "@target/uiFailedTests.txt",
        glue = {"com/openmrs/hook", "com/openmrs/stepdefinitions"},
        dryRun = false,
        tags = "@QA_regression",
        snippets = CucumberOptions.SnippetType.UNDERSCORE,
        plugin = {"pretty", "html:target/uiReport.html", "rerun:target/uiFailedTests.txt",
                "json:target/cucumber-reports/cucumber.json"}
)
public class OpenMRSReRunner {
}
