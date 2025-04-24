package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.IOException;
import java.util.Map;

public class Parser {

    public static Map<String, Object> parseFromString(String content, String fileName) throws IOException {
        ObjectMapper objectMapper;

        // если JSON
        if (fileName.endsWith(".json")) {
            objectMapper = new ObjectMapper(); //
        } else if (fileName.endsWith(".yaml") || fileName.endsWith(".yml")) { // если YAML
            objectMapper = new ObjectMapper(new YAMLFactory());
        } else {
            throw new IllegalArgumentException("Ошибка: формат неясен"); // Если формат не поддерживается
        }

        return objectMapper.readValue(content, new TypeReference<Map<String, Object>>() { });
    }
}
