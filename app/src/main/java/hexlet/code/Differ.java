package hexlet.code;

import java.util.LinkedHashMap;
import java.util.HashMap;
import java.util.Map;

public class Differ {
    public static String generate(String filePath1, String filePath2, String format) throws Exception {
        Map<String, Object> file1InMapFormat = new HashMap<>();
        Map<String, Object> file2InMapFormat = new HashMap<>();
        switch (format) {
            case "stylish" -> {
                file1InMapFormat = Parser.parse(filePath1);
                file2InMapFormat = Parser.parse(filePath2);
            }
            case "yaml" -> {
                file1InMapFormat = Parser.parseYaml(filePath1);
                file2InMapFormat = Parser.parseYaml(filePath2);
            }
            default -> {
            }
        }
        LinkedHashMap<String, Object> resultOfComparedFiles = GenDiff.genDiff(file1InMapFormat, file2InMapFormat);
        return Stylish.stylish(resultOfComparedFiles);
    }
}
