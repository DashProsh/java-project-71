package hexlet.code;

import org.junit.jupiter.api.Test;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.assertEquals;

class DifferTest {
    private static final String EXPECTED_DIFF = """
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

    @Test
    void testGenerateDiffForJson() throws IOException {
        String filePath1 = "file1.json";
        String filePath2 = "file2.json";
        String actualDiff = Differ.generate(filePath1, filePath2);
        assertEquals(EXPECTED_DIFF.trim(), actualDiff.trim());
        System.out.println("ВСЕ РАБОТАЕТ!");
    }

    @Test
    void testGenerateDiffForYaml() throws IOException {
        String filePath1 = "file1.yml";
        String filePath2 = "file2.yml";
        String actualDiff = Differ.generate(filePath1, filePath2);
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