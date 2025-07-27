package com.petstore.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.rest.interactions.Get;

import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.hamcrest.Matchers.equalTo;

public class verifyAddedPet implements Question<Boolean> {
    private int petId;
    private int expectedStatusCode;

    public verifyAddedPet(int petId, int expectedStatusCode) {
        this.petId = petId;
        this.expectedStatusCode = expectedStatusCode;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        actor.attemptsTo(
                Get.resource("/pet/{petId}")
                        .with(request -> request.pathParam("petId", petId))
        );

        actor.should(
                seeThatResponse("Verification of the new pet added",
                        response -> {
                    response.statusCode(expectedStatusCode);
                    if(expectedStatusCode == 200){
                        response.body("id",equalTo(petId));
                    } else if (expectedStatusCode == 404){
                        response.body(equalTo("Pet not found"));
                    }
                        })
        );
        return true;
    }

    public static verifyAddedPet forID(int petId,int expectedStatusCode){
        return new verifyAddedPet(petId, expectedStatusCode);
    }
}
