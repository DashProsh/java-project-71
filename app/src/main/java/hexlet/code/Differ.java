package hexlet.code;

import hexlet.code.formatters.Formatter;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Differ {
    public static String generate(String data1, String data2, String format) throws IOException {

        String content1 = new String(Files.readAllBytes(Paths.get(data1)));
        String content2 = new String(Files.readAllBytes(Paths.get(data2)));

        Map<String, Object> fileInfo1 = Parser.parseFromString(content1);
        Map<String, Object> fileInfo2 = Parser.parseFromString(content2);

        List<Map<String, Object>> diff = DifferCalculation.calculateDiff(fileInfo1, fileInfo2);

        return Formatter.format(diff, format);
    }

    // без формата (по умолчанию "stylish")
    public static String generate(String data1, String data2) throws IOException {
        return generate(data1, data2, "stylish");

    }
}
