package com.petstore.models;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.io.IOException;

public class PetSerializer extends JsonSerializer<Pet> {
    @Override
    public void serialize(Pet pet, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeStartObject();

        if (pet.includeId) {
            gen.writeObjectField("id", pet.getId());
        }

        if (pet.includeName) {
            gen.writeObjectField("name", pet.getName());
        }

        if (pet.includeCategory) {
            gen.writeObjectField("category", pet.getCategory());
        }

        if (pet.includePhotoUrls) {
            gen.writeObjectField("photoUrls", pet.getPhotoUrls());
        }

        if (pet.includeTags) {
            gen.writeObjectField("tags", pet.getTags());
        }

        if (pet.includeStatus) {
            gen.writeObjectField("status", pet.getStatus());
        }

        gen.writeEndObject();
    }
}