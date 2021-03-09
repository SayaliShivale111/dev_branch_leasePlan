package com.serenity.bdd.suite;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
    plugin = {"pretty"},
    glue = {"com.serenity.bdd.stepdefinitions"},
    features = "src/test/resources/features/xkcd_info.feature"
)
public class CucumberTestSuite {

}
