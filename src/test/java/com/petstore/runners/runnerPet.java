package com.petstore.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = {"pretty","json:target/site/serenity/serenity.json", "json:target/cucumber-json-report.json"},
        features = "src/test/resources/features",
        glue = "com.petstore.stepDefinitions",
        tags = "@pet",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)

public class runnerPet {
}
