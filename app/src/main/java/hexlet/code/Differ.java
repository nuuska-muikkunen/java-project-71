package hexlet.code;

import java.util.Map;

public class Differ {
    public static String generate(String filePath1, String filePath2) throws Exception {
        Map<String, Object> file1InMapFormat = Parser.parse(filePath1);
        Map<String, Object> file2InMapFormat = Parser.parse(filePath2);
        Map<String, Object> resultoOfComparedFiles = GenDiff.genDiff(file1InMapFormat, file2InMapFormat);
        String forOutput = resultoOfComparedFiles.toString();
        return forOutput.replace("=", ": ").replace(",", "\n")
                .replace("{", "{\n ").replace("}", "\n}");
    }
}
