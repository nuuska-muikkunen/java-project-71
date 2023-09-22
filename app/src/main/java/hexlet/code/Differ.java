package hexlet.code;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Differ {

    static final String PATH_TO_FIXTURE = "src/test/resources/fixtures/";

    public static String fixture(String nameOfFile) {
        return PATH_TO_FIXTURE + nameOfFile;
    }

    public static String fixtureToString(String filePath) throws Exception {
        File file = new File(filePath);
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        StringBuilder s = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null) {
            s.append(line).append("\n");
        }
        return s.substring(0, s.length() - 1).trim();
    }

    public static String generate(String filePath1, String filePath2, String format) throws Exception {
        String endOfFile1 = filePath1.substring(filePath1.lastIndexOf("."));
        String endOfFile2 = filePath2.substring(filePath2.lastIndexOf("."));
        if (!endOfFile1.equals(endOfFile2)) {
            return "The files are of different types";
        }
        if (!endOfFile1.equals(".json") && !endOfFile1.equals(".yaml") && !endOfFile1.equals(".yml")) {
            return "There are files of unknown format";
        }
        String linesOfFile1 = Files.readString(Paths.get(filePath1).toAbsolutePath().normalize());
        String linesOfFile2 = Files.readString(Paths.get(filePath2).toAbsolutePath().normalize());
        var file1InMapFormat = Parser.parse(linesOfFile1, endOfFile1);
        var file2InMapFormat = Parser.parse(linesOfFile2, endOfFile2);
        var resultOfComparedFiles = GenDiff.genDiff(file1InMapFormat, file2InMapFormat);
        return Formatter.formatter(resultOfComparedFiles, format);
    }

    public static String generate(String filePath1, String filePath2) throws Exception {
        return generate(filePath1, filePath2, "stylish");
    }
}
