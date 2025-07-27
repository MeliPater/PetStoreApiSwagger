package com.petstore.stepDefinitions;

import com.fasterxml.jackson.databind.JsonNode;
import com.petstore.interactions.healthCheck;
import com.petstore.questions.verifyAddedPet;
import com.petstore.tasks.addPet;
import com.petstore.utils.TestDataLoader;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.core.environment.SystemEnvironmentVariables;
import net.thucydides.core.util.EnvironmentVariables;

import static io.restassured.RestAssured.baseURI;

public class petSteps {
    Actor actor;

    @Before
    public void setStage() {
        OnStage.setTheStage(new OnlineCast());
        EnvironmentVariables env = SystemEnvironmentVariables.createEnvironmentVariables();
        RestAssured.baseURI = env.getProperty("serenity.project.baseURL");
        //baseURI = "http://localhost:8080/api/v3";
        actor = Actor.named("Pet store owner").whoCan(CallAnApi.at(baseURI));
    }

    @Given("the pet store API is available")
    public void the_pet_store_api_is_available() {
        actor.attemptsTo(
                healthCheck.petStore()
        );
    }
    @When("i add a new pet in the store")
    public void i_add_a_new_pet_in_the_store() {
        JsonNode data = TestDataLoader.getRandomBody("Successful");
        actor.attemptsTo(
                addPet.with()
                        .withId(130)
                        .withNullName()
                        .withCategory(0,"Dogs")
                        .withPhotoUrl("url1.jpg")
                        .withTag(1,"bonita")
                        .withStatus("available")
        );
    }
    @Then("i verify that the pet has been added")
    public void i_verify_that_the_pet_has_been_added() {
        int petId = actor.recall("petId");
        actor.asksFor(
                verifyAddedPet.forID(petId,200)
        );
    }
}
