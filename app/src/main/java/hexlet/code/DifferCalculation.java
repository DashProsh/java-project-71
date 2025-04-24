package hexlet.code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class DifferCalculation {

    public static List<Map<String, Object>> calculateDiff(Map<String, Object> fileInfo1,
                                                          Map<String, Object> fileInfo2) {
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
                // ключ был добавлен во второй файл
                diffEntry.put("type", "added");
                diffEntry.put("newValue", value2);
            } else if (!fileInfo2.containsKey(key)) {
                // ключ был удалён
                diffEntry.put("type", "removed");
                diffEntry.put("oldValue", value1);
            } else if (Objects.equals(value1, value2)) {
                //значение осталось неизменным
                diffEntry.put("type", "unchanged");
                diffEntry.put("value", value1);
            } else {
                // значение изменилось
                diffEntry.put("type", "updated");
                diffEntry.put("oldValue", value1);
                diffEntry.put("newValue", value2);
            }
            diff.add(diffEntry);
        }
        return diff;
    }
}
