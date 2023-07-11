package com.example.lmspeaksoft.entity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.AttributeConverter;

import java.io.IOException;
import java.util.Map;

public class Converter implements AttributeConverter<Map, String> {
    private final ObjectMapper objectMapper = new ObjectMapper();
    @Override
    public String convertToDatabaseColumn(Map taskDataStringMap) {
        try {
            return objectMapper.writeValueAsString(taskDataStringMap);
        } catch (JsonProcessingException e) {
            // Handle exception
            return null;
        }
    }

    @Override
    public Map convertToEntityAttribute(String s) {
        try {
            return objectMapper.readValue(s, Map.class);
        } catch (IOException e) {
            // Handle exception
            return null;
        }
    }
}
