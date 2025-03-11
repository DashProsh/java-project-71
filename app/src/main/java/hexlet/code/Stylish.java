package hexlet.code;

import java.util.List;
import java.util.Map;

public class Stylish {
    public static String format(List<Map<String, Object>> diff) {
        StringBuilder result = new StringBuilder("\n{\n");
        for (Map<String, Object> entry : diff) {
            String sign = (String) entry.get("sign");
            String key = (String) entry.get("key");
            Object value = entry.get("value");

            result.append("  ").append(sign).append(" ").append(key).append(": ").append(value).append("\n");
        }
        result.append("}\n");
        return result.toString();
    }
}