package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class Parser {

    public static Map<String, Object> parse(String filePath) throws IOException {
        ObjectMapper objectMapper;

        if (filePath.endsWith(".json")) {
            objectMapper = new ObjectMapper();
        } else if (filePath.endsWith(".yaml") || filePath.endsWith(".yml")) {
            objectMapper = new ObjectMapper(new YAMLFactory()); // Используем YAML парсер
        } else {
            throw new IllegalArgumentException("Unsupported file format: " + filePath);
        }

        return objectMapper.readValue(new File("src/main/resources/fixtures/" + filePath),
                new TypeReference<Map<String, Object>>() { });
    }
}
