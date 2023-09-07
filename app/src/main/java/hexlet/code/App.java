package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;
import java.util.concurrent.Callable;

@Command(
        name = "gendiff",
        version = "3.0.0",
        description = "Compares two configuration files and shows a difference."
)
public final class App implements Callable {
    @Parameters(description = "path to first file", paramLabel = "filepath1")
        private String filepath1;
    @Parameters(description = "path to second file", paramLabel = "filepath2")
        private String filepath2;
    @Option(names = {"-V", "--version"}, versionHelp = true, description = "Print version information and exit.")
        private boolean versionInfoRequested;
    @Option(names = {"-h", "--help"}, usageHelp = true, description = "Show this help message and exit.")
        private boolean usageHelpRequested;
    @Option(names = {"-f", "--format"}, description = "output format [default: ${DEFAULT-VALUE}]",
            paramLabel = "format")
        private String format = "stylish";

    public boolean isVersionInfoRequested() {
        return versionInfoRequested;
    }

    public boolean isUsageHelpRequested() {
        return usageHelpRequested;
    }

    @Override
    public String call() throws Exception {
        String s = Differ.generate(filepath1, filepath2, format);
        System.out.println(s);
        return s;
    }
    public static void main(String[] args) {
        int exitCode = new CommandLine(new App()).execute(args);
//        if (commandLine.isUsageHelpRequested()) {
//            commandLine.usage(System.out);
//        } else if (commandLine.isVersionHelpRequested()) {
//            commandLine.printVersionHelp(System.out);
//        }
        System.exit(exitCode);
    }
}
