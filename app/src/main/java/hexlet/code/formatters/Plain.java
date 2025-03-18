package hexlet.code.formatters;

import java.util.List;
import java.util.Map;

public class Plain {

    public static String format(List<Map<String, Object>> diff) {
        StringBuilder result = new StringBuilder();

        for (Map<String, Object> entry : diff) {
            String key = (String) entry.get("key");
            String type = (String) entry.get("type");
            Object oldValue = entry.get("oldValue");
            Object newValue = entry.get("newValue");

            switch (type) {
                case "added" -> result.append(String.format("Property '%s' was added with value: %s\n",
                        key, formatValue(newValue)));
                case "removed" -> result.append(String.format("Property '%s' was removed\n", key));
                case "updated" -> result.append(String.format("Property '%s' was updated. From %s to %s\n",
                        key, formatValue(oldValue), formatValue(newValue)));
                default -> {} // Игнорируем "unchanged" (оставленные без изменений)
            }
        }
        return result.toString();
    }

    private static String formatValue(Object value) {
        if (value instanceof Map || value instanceof List) {
            return "[complex value]";
        } else if (value instanceof String) {
            return "'" + value + "'";
        }
        return String.valueOf(value);
    }
}