package hexlet.code;

import hexlet.code.formatters.Formatter;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.assertEquals;

class DifferTest {

    private static final String EXPECTED_JSON_STYLISH = """
            {
                chars1: [a, b, c]
              - chars2: [d, e, f]
              + chars2: false
              - checked: false
              + checked: true
              - default: null
              + default: [value1, value2]
              - id: 45
              + id: null
              - key1: value1
              + key2: value2
                numbers1: [1, 2, 3, 4]
              - numbers2: [2, 3, 4, 5]
              + numbers2: [22, 33, 44, 55]
              - numbers3: [3, 4, 5]
              + numbers4: [4, 5, 6]
              + obj1: {nestedKey=value, isNested=true}
              - setting1: Some value
              + setting1: Another value
              - setting2: 200
              + setting2: 300
              - setting3: true
              + setting3: none
            }
            """;


    private static final String EXPECTED_DIFF_PLAIN = """
            Property 'chars2' was updated. From [complex value] to false
            Property 'checked' was updated. From false to true
            Property 'default' was updated. From null to [complex value]
            Property 'id' was updated. From 45 to null
            Property 'key1' was removed
            Property 'key2' was added with value: 'value2'
            Property 'numbers2' was updated. From [complex value] to [complex value]
            Property 'numbers3' was removed
            Property 'numbers4' was added with value: [complex value]
            Property 'obj1' was added with value: [complex value]
            Property 'setting1' was updated. From 'Some value' to 'Another value'
            Property 'setting2' was updated. From 200 to 300
            Property 'setting3' was updated. From true to 'none'
            """;


    private static final String EXPECTED_JSON = """
            [ {
              "type" : "unchanged",
              "value" : [ "a", "b", "c" ],
              "key" : "chars1"
            }, {
              "newValue" : false,
              "oldValue" : [ "d", "e", "f" ],
              "type" : "updated",
              "key" : "chars2"
            }, {
              "newValue" : true,
              "oldValue" : false,
              "type" : "updated",
              "key" : "checked"
            }, {
              "newValue" : [ "value1", "value2" ],
              "oldValue" : null,
              "type" : "updated",
              "key" : "default"
            }, {
              "newValue" : null,
              "oldValue" : 45,
              "type" : "updated",
              "key" : "id"
            }, {
              "oldValue" : "value1",
              "type" : "removed",
              "key" : "key1"
            }, {
              "newValue" : "value2",
              "type" : "added",
              "key" : "key2"
            }, {
              "type" : "unchanged",
              "value" : [ 1, 2, 3, 4 ],
              "key" : "numbers1"
            }, {
              "newValue" : [ 22, 33, 44, 55 ],
              "oldValue" : [ 2, 3, 4, 5 ],
              "type" : "updated",
              "key" : "numbers2"
            }, {
              "oldValue" : [ 3, 4, 5 ],
              "type" : "removed",
              "key" : "numbers3"
            }, {
              "newValue" : [ 4, 5, 6 ],
              "type" : "added",
              "key" : "numbers4"
            }, {
              "newValue" : {
                "nestedKey" : "value",
                "isNested" : true
              },
              "type" : "added",
              "key" : "obj1"
            }, {
              "newValue" : "Another value",
              "oldValue" : "Some value",
              "type" : "updated",
              "key" : "setting1"
            }, {
              "newValue" : 300,
              "oldValue" : 200,
              "type" : "updated",
              "key" : "setting2"
            }, {
              "newValue" : "none",
              "oldValue" : true,
              "type" : "updated",
              "key" : "setting3"
            } ]
            """;

    @Test
    void testGenerateDiffForJsonStylish() throws IOException {
        var data1 = Parser.parseFromResources("file1.json");
        var data2 = Parser.parseFromResources("file2.json");
        var diff = Differ.calculateDiff(data1, data2);
        var actual = Formatter.format(diff, "stylish");
        System.out.println("Actual output: \n" + actual);
        assertEquals(EXPECTED_JSON_STYLISH.strip(), actual.strip());
        System.out.println("ВСЕ РАБОТАЕТ!!!");
    }

    @Test
    void testGenerateDiffForJsonPlain() throws IOException {
        var data1 = Parser.parseFromResources("file1.yml");
        var data2 = Parser.parseFromResources("file2.yml");
        var diff = Differ.calculateDiff(data1, data2);
        var actual = Formatter.format(diff, "plain");
        System.out.println("Actual output: " + actual);
        assertEquals(EXPECTED_DIFF_PLAIN.strip(), actual.strip());
        System.out.println("ВСЕ РАБОТАЕТ! лала!!!");
    }


    @Test
    void testGenerateDiffForJsonJson() throws IOException {
        var data1 = Parser.parseFromResources("file1.json");
        var data2 = Parser.parseFromResources("file2.json");
        var diff = Differ.calculateDiff(data1, data2);
        var actual = Formatter.format(diff, "json");
        System.out.println("Actual output: " + actual);
        assertEquals(EXPECTED_JSON.strip(), actual.strip());
        System.out.println("ВСЕ РАБОТАЕТ! дада!!!");
    }
}
