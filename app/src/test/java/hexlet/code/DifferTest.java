package hexlet.code;

import org.junit.jupiter.api.Test;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.assertEquals;

class DifferTest {
    private static final String EXPECTED_DIFF = """
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

    @Test
    void testGenerateDiffForJson() throws IOException {
        String filePath1 = "file1.json";
        String filePath2 = "file2.json";
        String actualDiff = Differ.generate(filePath1, filePath2, "plain");
        assertEquals(EXPECTED_DIFF.trim(), actualDiff.trim());
        System.out.println("ВСЕ РАБОТАЕТ!");
    }

    @Test
    void testGenerateDiffForYaml() throws IOException {
        String filePath1 = "file1.yml";
        String filePath2 = "file2.yml";
        String actualDiff = Differ.generate(filePath1, filePath2, "plain");
        assertEquals(EXPECTED_DIFF.trim(), actualDiff.trim());
        System.out.println("ВСЕ РАБОТАЕТ! лала!");
    }

}




//
//@Test
//void testGenerateDiffJson() throws IOException {
//    // Указываем пути к фикстурам
//    String filePath1 = "file1.json";
//    String filePath2 = "file2.json";
//
//    // Ожидаемый результат сравнения JSON-файлов
//    String expectedDiff = """
//            {
//              - follow: false
//                host: hexlet.io
//              - proxy: 123.234.53.22
//              - timeout: 50
//              + timeout: 20
//              + verbose: true
//            }
//            """;
//
//    // Запускаем метод сравнения
//    String actualDiff = Differ.generate(filePath1, filePath2);
//
//    // Проверяем, что результат совпадает с ожидаемым
//    assertEquals(expectedDiff.trim(), actualDiff.trim());
//    System.out.println("ВСЕ РАБОТАЕТ!!");
//}
//
//@Test
//void testGenerateDiffYml() throws IOException {
//    // Указываем пути к фикстурам
//    String filePath1 = "file1.yml";
//    String filePath2 = "file2.yml";
//
//    // Ожидаемый результат сравнения YML-файлов
//    String expectedDiff = """
//            {
//              - follow: false
//                host: hexlet.io
//              - proxy: 123.234.53.22
//              - timeout: 50
//              + timeout: 20
//              + verbose: true
//            }
//            """;
//
//    // Запускаем метод сравнения
//    String actualDiff = Differ.generate(filePath1, filePath2);
//
//    // Проверяем, что результат совпадает с ожидаемым
//    assertEquals(expectedDiff.trim(), actualDiff.trim());
//    System.out.println("ВСЕ РАБОТАЕТ! лала!");
//}