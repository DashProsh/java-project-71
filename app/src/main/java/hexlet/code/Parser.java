package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.IOException;
import java.util.Map;


public class Parser {

    public static Map<String, Object> parseFromString(String content) throws IOException {
        ObjectMapper objectMapper;

        if (content.trim().startsWith("{") || content.trim().startsWith("[")) {
            objectMapper = new ObjectMapper(); // JSON
        } else {
            objectMapper = new ObjectMapper(new YAMLFactory()); // YAML
        }

        return objectMapper.readValue(content, new TypeReference<Map<String, Object>>() { });
    }
}
