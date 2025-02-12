package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

import java.io.File;
import java.util.List;


@Command(name = "gendiff", mixinStandardHelpOptions = true, version = "gendiff 1.1.1",
        description = "Compares two configuration files and shows a difference.")

class App implements Runnable {

    @Option(names = { "-h", "--help" }, usageHelp = true, description = "Show this help message and exit.")
    boolean usageHelpRequested;

    @Option(names = { "-V", "--version" }, versionHelp = true, description = "Print version information and exit.")
    boolean versionInfoRequested;

    @Option(names = { "-f", "--format " }, paramLabel = "format", description = "output format [default: stylish]", defaultValue = "stylish")
    private String format;

    @CommandLine.Parameters(index = "0", paramLabel = "filepath1", description = "path to first file")
    private String filepath1;

    @CommandLine.Parameters(index = "1", paramLabel = "filepath2", description = "path to second file")
    private String filepath2;


    @Override
    public void run () {
        System.out.println("0");
    }

    public static void main(String[] args) {
        new CommandLine(new App()).execute(args);
    }
}