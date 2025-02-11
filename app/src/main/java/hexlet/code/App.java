package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;


@Command(name = "gendiff", mixinStandardHelpOptions = true, version = "gendiff 1.1.1",
        description = "Compares two configuration files and shows a difference.")

class App implements Runnable {

    @Option(names = { "-h", "--help" }, usageHelp = true, description = "Show this help message and exit.")
    boolean usageHelpRequested;

    @Option(names = { "-V", "--version" }, versionHelp = true, description = "Print version information and exit.")
    boolean versionInfoRequested;

    @Override
    public void run () {
        System.out.println("Use -h or --help to see available options.");
    }

    public static void main(String[] args) {
        new CommandLine(new App()).execute(args);
    }
}