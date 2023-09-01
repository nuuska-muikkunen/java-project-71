package hexlet.code;

import java.util.LinkedHashMap;
import java.util.Map;

public class Differ {
    public static String generate(String filePath1, String filePath2, String format) throws Exception {
        Map<String, Object> file1InMapFormat;
        Map<String, Object> file2InMapFormat;
        LinkedHashMap<String, Object> resultOfComparedFiles;
//        var linesOfFile1 = Files.readString(Paths.get(filePath1).toAbsolutePath().normalize());
//        var linesOfFile2 = Files.readString(Paths.get(filePath2).toAbsolutePath().normalize());
        String endOfFile = filePath1.substring(filePath1.lastIndexOf("."));
        switch (endOfFile) {
            case ".json" -> {
                file1InMapFormat = Parser.parse(filePath1);
                file2InMapFormat = Parser.parse(filePath2);
            }
            case ".yml", ".yaml" -> {
                file1InMapFormat = Parser.parseYaml(filePath1);
                file2InMapFormat = Parser.parseYaml(filePath2);
            }
            default -> {
                System.out.println("There are files of unknown format");
                return "resultOfComparedFiles";
            }
        }
        resultOfComparedFiles = GenDiff.genDiff(file1InMapFormat, file2InMapFormat);
        return Formatter.formatter(resultOfComparedFiles, format);
    }
}
