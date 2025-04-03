package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Objects;

public class Parser {

    public static Map<String, Object> parseFromResources(String fileName) throws IOException {
        ObjectMapper objectMapper;

        if (fileName.endsWith(".json")) {
            objectMapper = new ObjectMapper();
        } else if (fileName.endsWith(".yaml") || fileName.endsWith(".yml")) {
            objectMapper = new ObjectMapper(new YAMLFactory());
        } else {
            throw new IllegalArgumentException("Unsupported file format: " + fileName);
        }

        Path path;
        try {
            path = Paths.get(Objects.requireNonNull(
                    Parser.class.getClassLoader().getResource("fixtures/" + fileName)).toURI());
        } catch (URISyntaxException e) {
            throw new RuntimeException("Invalid file path: " + fileName, e);
        }

        return objectMapper.readValue(path.toFile(), new TypeReference<Map<String, Object>>() { });
    }


    public static Map<String, Object> parse(String filePath) throws IOException {
        ObjectMapper objectMapper;

        if (filePath.endsWith(".json")) {
            objectMapper = new ObjectMapper();
        } else if (filePath.endsWith(".yaml") || filePath.endsWith(".yml")) {
            objectMapper = new ObjectMapper(new YAMLFactory());
        } else {
            throw new IllegalArgumentException("Unsupported file format: " + filePath);
        }

        return objectMapper.readValue(new File(filePath), new TypeReference<Map<String, Object>>() { });
    }
}
