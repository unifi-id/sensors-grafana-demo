package id.unifi.envsensorsapi.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ObjectMapperUtil {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    private ObjectMapperUtil() {
    }

    public static <T> T convertValue(String content, Class<T> returnType) {
        try {
            return objectMapper.readValue(content, returnType);
        } catch (JsonProcessingException e) {
            return null;
        }
    }

}
