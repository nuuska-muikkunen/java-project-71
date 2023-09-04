package hexlet.code;

import java.util.LinkedHashMap;
import java.util.Map;

public class Differ {
    public static String generate(String filePath1, String filePath2, String format) throws Exception {
        Map<String, Object> file1InMapFormat;
        Map<String, Object> file2InMapFormat;
        LinkedHashMap<String, Object> resultOfComparedFiles;
        String endOfFile1 = filePath1.substring(filePath1.lastIndexOf("."));
        String endOfFile2 = filePath2.substring(filePath2.lastIndexOf("."));
        if (!endOfFile1.equals(endOfFile2)) {
            System.out.println("The files are of difefrent types");
            return "resultOfComparedFiles is empty";
        }
        switch (endOfFile1) {
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
                return "resultOfComparedFiles is empty";
            }
        }
        resultOfComparedFiles = GenDiff.genDiff(file1InMapFormat, file2InMapFormat);
        return Formatter.formatter(resultOfComparedFiles, format);
    }
}
