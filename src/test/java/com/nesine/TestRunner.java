package com.nesine;

import io.cucumber.java.Before;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.junit.Cucumber;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.junit.runner.RunWith;
import org.testng.annotations.DataProvider;


@RunWith(Cucumber.class)
@CucumberOptions(

        features = {
                "src/test/resources/features"
        },
        plugin = {
                "pretty", "io.qameta.allure.cucumber6jvm.AllureCucumber6Jvm"},
        monochrome = true,
        glue = "com.nesine",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)

public class TestRunner extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
        return super.scenarios();
    }

    @Before
    public void setUp(Scenario scenario) {

        Logger.info("-----  TEST STARTED " + scenario.getName() + "  SCENARIO --------");
    }

    @After
    public void tearDown(Scenario scenario) {

        Logger.info("---------- TEST FINISHED ---------\n");
    }

}