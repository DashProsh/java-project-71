package hexlet.code;

import org.junit.jupiter.api.Test;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.assertEquals;

class DifferTest {

    @Test
    void testGenerateDiff() throws IOException {
        // Указываем пути к фикстурам
        String filePath1 = "file1.json";
        String filePath2 = "file2.json";

        // Ожидаемый результат сравнения JSON-файлов
        String expectedDiff = """
            {
              - follow: false
                host: hexlet.io
              - proxy: 123.234.53.22
              - timeout: 50
              + timeout: 20
              + verbose: true
            }
            """;

        // Запускаем метод сравнения
        String actualDiff = Differ.generate(filePath1, filePath2);

        // Проверяем, что результат совпадает с ожидаемым
        assertEquals(expectedDiff.trim(), actualDiff.trim());
    }
}