package hexlet.code;

import hexlet.code.formatters.Formatter;

import java.io.IOException;
import java.util.*;

public class Differ {

    public static String generate(String filePath1, String filePath2, String format) throws IOException {
        // Используем новый Parser для обработки разных форматов
        Map<String, Object> fileInfo1 = Parser.parse(filePath1);
        Map<String, Object> fileInfo2 = Parser.parse(filePath2);

        List<Map<String, Object>> diff = calculateDiff(fileInfo1, fileInfo2);

        return Formatter.format(diff, format);
    }

    public static List<Map<String, Object>> calculateDiff(Map<String, Object> fileInfo1, Map<String, Object> fileInfo2) {
        Set<String> allKeys = new TreeSet<>();
        allKeys.addAll(fileInfo1.keySet());
        allKeys.addAll(fileInfo2.keySet());

        List<Map<String, Object>> diff = new ArrayList<>();

        for (String key : allKeys) {
            Object value1 = fileInfo1.get(key);
            Object value2 = fileInfo2.get(key);

            Map<String, Object> diffEntry = new HashMap<>();
            diffEntry.put("key", key);

            if (!fileInfo1.containsKey(key)) {
                // Ключ был добавлен во второй файл
                diffEntry.put("type", "added");
                diffEntry.put("newValue", value2);
            } else if (!fileInfo2.containsKey(key)) {
                // Ключ был удалён
                diffEntry.put("type", "removed");
                diffEntry.put("oldValue", value1);
            } else if (Objects.equals(value1, value2)) {
                // Значение осталось неизменным
                diffEntry.put("type", "unchanged");
                diffEntry.put("value", value1);
            } else {
                // Значение изменилось
                diffEntry.put("type", "updated");
                diffEntry.put("oldValue", value1);
                diffEntry.put("newValue", value2);
            }

            diff.add(diffEntry);
        }

        return diff;
    }
}


//package hexlet.code;
//
//import com.fasterxml.jackson.core.type.TypeReference;
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//import java.io.File;
//import java.io.IOException;
//import java.util.Map;
//import java.util.Set;
//import java.util.TreeSet;
//
//
//public class Differ {
//
//    public static String generate(String filePath1, String filePath2) throws IOException {
//        ObjectMapper objectMapper = new ObjectMapper();
//
//        // Читаю JSON и складываю в Map
//
//        Map<String, Object> fileInfo1 = objectMapper.readValue(new File("src/main/resources/" + filePath1),
//                new TypeReference<Map<String, Object>>() { });
//        Map<String, Object> fileInfo2 = objectMapper.readValue(new File("src/main/resources/" + filePath2),
//                new TypeReference<Map<String, Object>>() { });
//
//        return generateDiff(fileInfo1, fileInfo2);
//    }
//
//    public static String generateDiff(Map<String, Object> fileInfo1, Map<String, Object> fileInfo2) {
//
//        //разбиваю на значения
//        Set<String> allKeys = new TreeSet<>();
//        allKeys.addAll(fileInfo1.keySet());
//        allKeys.addAll(fileInfo2.keySet());
//
//        // тут буду хранить результат сравнения
//        StringBuilder differences = new StringBuilder("\n"
//                + "{\n");
//
//        //сравниваю по значениям и вывожу обратно ключ-значение
//        for (String key : allKeys) {
//
//            Object value1 = fileInfo1.get(key);
//            Object value2 = fileInfo2.get(key);
//
//            if (value1 != null && value2 != null && value1.equals(value2)) {
//                differences.append("    ").append(key).append(": ").append(value1).append("\n");
//            } else {
//                if (value1 != null) {
//                    differences.append("  - ").append(key).append(": ").append(value1).append("\n");
//                }
//                if (value2 != null) {
//                    differences.append("  + ").append(key).append(": ").append(value2).append("\n");
//                }
//            }
//        }
//
//        differences.append("}\n");
//        return differences.toString();
//    }
//}
