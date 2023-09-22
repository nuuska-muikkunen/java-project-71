package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;
import java.util.concurrent.Callable;

@Command(
        name = "gendiff",
        mixinStandardHelpOptions = true,
        version = "4.0.0",
        description = "Compares two configuration files and shows a difference."
)

public final class App implements Callable {
    @Parameters(description = "path to first file", paramLabel = "filepath1")
        private String filepath1;

    @Parameters(description = "path to second file", paramLabel = "filepath2")
        private String filepath2;

    @Option(names = {"-f", "--format"}, description = "output format [default: ${DEFAULT-VALUE}]",
            paramLabel = "format")
        private String format = "stylish";

    @Override
    public String call() throws Exception {
        var s = Differ.generate(filepath1, filepath2, format);
        System.out.println(s);
        return s;
    }

    public static void main(String[] args) {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }
}
