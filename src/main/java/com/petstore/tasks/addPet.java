package com.petstore.tasks;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.petstore.models.*;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Post;

import java.util.ArrayList;
import java.util.List;

public class addPet implements Task {
    private final Pet pet = new Pet();
    private final List<String> photoUrls = new ArrayList<>();
    private final List<Tag> tags = new ArrayList<>();

    @Override
    public <T extends Actor> void performAs(T actor) {
        // Configurar listas solo si se agregaron elementos
        if (!photoUrls.isEmpty()) {
            pet.setPhotoUrls(new ArrayList<>(photoUrls));
        }

        if (!tags.isEmpty()) {
            pet.setTags(new ArrayList<>(tags));
        }

        try {
            ObjectMapper mapper = new ObjectMapper()
                    .disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);

            String body = mapper.writeValueAsString(pet);

            actor.attemptsTo(
                    Post.to("/pet")
                            .with(request -> request
                                    .header("Content-Type", "application/json")
                                    .body(body)
                            )
            );
            actor.remember("petId", pet.getId());
        } catch (Exception e) {
            throw new RuntimeException("Error serializando el cuerpo del JSON", e);
        }
    }

    public static addPet with() {
        return Tasks.instrumented(addPet.class);
    }

    // Métodos para campos con valores
    public addPet withId(Integer id) {
        pet.setId(id);
        return this;
    }

    public addPet withName(String name) {
        pet.setName(name);
        return this;
    }

    public addPet withCategory(Integer id, String name) {
        pet.setCategory(new Category(id, name));
        return this;
    }

    public addPet withPhotoUrl(String photoUrl) {
        this.photoUrls.add(photoUrl);
        return this;
    }

    public addPet withTag(Integer id, String name) {
        this.tags.add(new Tag(id, name));
        return this;
    }

    public addPet withStatus(String status) {
        pet.setStatus(status);
        return this;
    }

    // Métodos para campos null explícitos
    public addPet withNullId() {
        pet.setNullId();
        return this;
    }

    public addPet withNullName() {
        pet.setNullName();
        return this;
    }

    public addPet withNullCategory() {
        pet.setNullCategory();
        return this;
    }

    public addPet withNullPhotoUrls() {
        pet.setNullPhotoUrls();
        return this;
    }

    public addPet withNullTags() {
        pet.setNullTags();
        return this;
    }

    public addPet withNullStatus() {
        pet.setNullStatus();
        return this;
    }
}