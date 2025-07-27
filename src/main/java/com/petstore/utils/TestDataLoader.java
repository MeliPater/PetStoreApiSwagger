package com.petstore.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Random;

public class TestDataLoader {
    private static final String TEST_DATA_FILE = "src/test/resources/data/petData.json";
    private static JsonNode rootNode;
    private static final Random random = new Random();

    static {
        try {
            ObjectMapper mapper = new ObjectMapper();
            rootNode = mapper.readTree(TestDataLoader.class.getResourceAsStream(TEST_DATA_FILE));
        } catch (IOException e) {
            throw new RuntimeException("Failed to load test data file", e);
        }
    }

    public static JsonNode getRandomBody(String scenarioType) {
        JsonNode scenarios = rootNode.path("scenarios").path(scenarioType);
        if (!scenarios.isArray() || scenarios.size() == 0) {
            throw new IllegalArgumentException("No test data found for scenario type: " + scenarioType);
        }
        return scenarios.get(random.nextInt(scenarios.size()));
    }
}