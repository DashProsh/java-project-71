package hexlet.code.formatters;

import java.util.List;
import java.util.Map;

public class Stylish {
    public static String format(List<Map<String, Object>> diff) {
        StringBuilder result = new StringBuilder("{\n");

        for (Map<String, Object> entry : diff) {
            String type = (String) entry.get("type");  // Исправлено с "sign"
            String key = (String) entry.get("key");
            Object oldValue = entry.get("oldValue");
            Object newValue = entry.get("newValue");

            switch (type) {
                case "added" -> result.append("  + ").append(key).append(": ").append(newValue).append("\n");
                case "removed" -> result.append("  - ").append(key).append(": ").append(oldValue).append("\n");
                case "updated" -> {
                    result.append("  - ").append(key).append(": ").append(oldValue).append("\n");
                    result.append("  + ").append(key).append(": ").append(newValue).append("\n");
                }
                case "unchanged" -> result.append("    ").append(key).append(": ")
                        .append(entry.get("value")).append("\n");
                default -> { }
            }
        }

        result.append("}\n");
        return result.toString().strip();
    }
}
