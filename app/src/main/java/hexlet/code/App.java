package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

import java.io.IOException;

@Command(name = "gendiff", mixinStandardHelpOptions = true, version = "gendiff 1.1.1",
        description = "Compares two configuration files and shows a difference.")

class App implements Runnable {

//    @Option(names = { "-h", "--help" }, usageHelp = true, description = "Show this help message and exit.")
//    boolean usageHelpRequested;
//
//    @Option(names = { "-V", "--version" }, versionHelp = true, description = "Print version information and exit.")
//    boolean versionInfoRequested;

    @Option(names = { "-f", "--format " }, paramLabel = "format",
            description = "output format [default: stylish]", defaultValue = "stylish")
    private String format;

    @CommandLine.Parameters(index = "0", paramLabel = "filepath1", description = "path to first file")
    private String filepath1;

    @CommandLine.Parameters(index = "1", paramLabel = "filepath2", description = "path to second file")
    private String filepath2;


    @Override
    public void run() {
        try {
            String diff = Differ.generate(filepath1, filepath2);
            System.out.println(diff);
        } catch (IOException e) {
            System.err.println("Ошибка при чтении файла: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        new CommandLine(new App()).execute(args);
    }
}
