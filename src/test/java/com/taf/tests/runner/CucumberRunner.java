package com.taf.tests.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber-report.html", "io.qameta.allure.cucumber6jvm.AllureCucumber6Jvm"},
        glue = {"com.taf.tests.steps"},
        features = {"src/test/resources/features"},
        tags = "@ui"
)
public class CucumberRunner {
}
