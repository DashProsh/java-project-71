package hexlet.code;

import com.fasterxml.jackson.databind.ObjectMapper;
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

    private static String getFixturePath(String fileName) {
        return Paths.get("src/test/resources/fixtures/" + fileName).toString();
    }

    @Test
    void testGenerateJsonStylish() throws IOException {
        String expected = readExpected("expectedStylish.txt");
        String actual = Differ.generate(getFixturePath("file1.json"), getFixturePath("file2.json"), "stylish");
        assertEquals(expected.strip(), actual.strip());
        System.out.println("1 ВСЕ РАБОТАЕТ");
    }

    @Test
    void testGenerateJsonPlain() throws IOException {
        String expected = readExpected("expectedPlain.txt");
        String actual = Differ.generate(getFixturePath("file1.json"), getFixturePath("file2.json"), "plain");
        assertEquals(expected.strip(), actual.strip());
        System.out.println("2 ВСЕ РАБОТАЕТ");
    }

    @Test
    void testGenerateJsonJson() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        var expected = mapper.readTree(readExpected("expectedJson.json"));
        var actual = mapper.readTree(Differ.generate(getFixturePath("file1.json"), getFixturePath("file2.json"),
                "json"));
        assertEquals(expected, actual);
        System.out.println("3 ВСЕ РАБОТАЕТ");
    }


    @Test
    void testGenerateYamlStylish() throws IOException {
        String expected = readExpected("expectedStylish.txt");
        String actual = Differ.generate(getFixturePath("file1.yml"), getFixturePath("file2.yml"), "stylish");
        assertEquals(expected.strip(), actual.strip());
        System.out.println("4 ВСЕ РАБОТАЕТ");
    }

    @Test
    void testGenerateYamlPlain() throws IOException {
        String expected = readExpected("expectedPlain.txt");
        String actual = Differ.generate(getFixturePath("file1.yml"), getFixturePath("file2.yml"), "plain");
        assertEquals(expected.strip(), actual.strip());
        System.out.println("5 ВСЕ РАБОТАЕТ");
    }

    @Test
    void testGenerateYamlJson() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        var expected = mapper.readTree(readExpected("expectedJson.json"));
        var actual = mapper.readTree(Differ.generate(getFixturePath("file1.yml"), getFixturePath("file2.yml"),
                "json"));
        assertEquals(expected, actual);
        System.out.println("6 ВСЕ РАБОТАЕТ");
    }

    @Test
    void testGenerateJsonDefault() throws IOException {
        String expected = readExpected("expectedStylish.txt");
        String actual = Differ.generate(getFixturePath("file1.json"), getFixturePath("file2.json"));
        assertEquals(expected.strip(), actual.strip());
        System.out.println("7 ВСЕ РАБОТАЕТ");
    }

    @Test
    void testGenerateYamlDefault() throws IOException {
        String expected = readExpected("expectedStylish.txt");
        String actual = Differ.generate(getFixturePath("file1.yml"), getFixturePath("file2.yml"));
        assertEquals(expected.strip(), actual.strip());
        System.out.println("8 ВСЕ РАБОТАЕТ");
    }
}
