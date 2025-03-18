package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

import java.io.IOException;

@Command(name = "gendiff", mixinStandardHelpOptions = true, version = "gendiff 1.1.1",
        description = "Compares two configuration files and shows a difference.")

class App implements Runnable {

    @Option(names = { "-f", "--format" }, paramLabel = "format",
            description = "output format [default: stylish]", defaultValue = "stylish")
    private String format;

    @CommandLine.Parameters(index = "0", paramLabel = "filePath1", description = "path to first file")
    private String filePath1;

    @CommandLine.Parameters(index = "1", paramLabel = "filePath2", description = "path to second file")
    private String filePath2;


    @Override
    public void run() {
        try {
            String diff = Differ.generate(filePath1, filePath2, format);
            System.out.println(diff);
        } catch (IOException e) {
            System.err.println("Ошибка при чтении файла: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        new CommandLine(new App()).execute(args);
    }
}
