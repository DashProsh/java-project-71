package hexlet.code;

import com.fasterxml.jackson.databind.ObjectMapper;
import hexlet.code.formatters.Formatter;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DifferTest {

    private static String readExpected(String fileName) throws IOException {
        var path = Paths.get("src/test/resources/fixtures/" + fileName);
        return Files.readString(path).strip();
    }

    @Test
    void testGenerateDiffForJsonStylish() throws IOException {
        var data1 = Parser.parseFromResources("file1.json");
        var data2 = Parser.parseFromResources("file2.json");
        var diff = Differ.calculateDiff(data1, data2);
        var actual = Formatter.format(diff, "stylish");
        assertEquals(readExpected("expectedStylish.txt"), actual.strip());
        System.out.println("ВСЕ РАБОТАЕТ!!!");
    }

    @Test
    void testGenerateDiffForJsonPlain() throws IOException {
        var data1 = Parser.parseFromResources("file1.yml");
        var data2 = Parser.parseFromResources("file2.yml");
        var diff = Differ.calculateDiff(data1, data2);
        var actual = Formatter.format(diff, "plain");
        assertEquals(readExpected("expectedPlain.txt"), actual.strip());
        System.out.println("ВСЕ РАБОТАЕТ! лала!!!");
    }

    @Test
    void testGenerateDiffForJsonJson() throws IOException {
        var data1 = Parser.parseFromResources("file1.json");
        var data2 = Parser.parseFromResources("file2.json");
        var diff = Differ.calculateDiff(data1, data2);
        var actual = Formatter.format(diff, "json");
        ObjectMapper mapper = new ObjectMapper();
        var expected = mapper.readTree(readExpected("expectedJson.json"));
        var actualTree = mapper.readTree(actual);
        assertEquals(expected, actualTree);
        System.out.println("ВСЕ РАБОТАЕТ! дада!!!");
    }
}
