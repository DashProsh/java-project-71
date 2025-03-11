package hexlet.code.formatters;

import java.util.List;
import java.util.Map;

public class Formatter {

    public static String format(List<Map<String, Object>> diff, String format) {
        return switch (format) {
            case "plain" -> Plain.format(diff);
            case "stylish" -> Stylish.format(diff);
            default -> throw new IllegalArgumentException("Unsupported format: " + format);
        };
    }
}