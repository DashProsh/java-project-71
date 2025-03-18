package hexlet.code.formatters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import java.util.Map;

public class Json {
    public static String format(List<Map<String, Object>> diff) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(diff);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Ошибка при формировании JSON: " + e.getMessage(), e);
        }
    }
}
