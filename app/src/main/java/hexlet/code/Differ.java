package hexlet.code;

import java.lang.String;
import java.util.LinkedHashMap;
import java.util.Map;
import java.nio.file.Files;
import java.nio.file.Paths;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Differ {
    public static String generate(String filePath1, String filePath2) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String linesOf1stFile = Files.readString(Paths.get(filePath1).toAbsolutePath().normalize());
        String linesOf2stFile = Files.readString(Paths.get(filePath2).toAbsolutePath().normalize());
        Map<String, Object> map1 = mapper.readValue(linesOf1stFile, new TypeReference<>(){});
        Map<String, Object> map2 = mapper.readValue(linesOf2stFile, new TypeReference<>(){});
        LinkedHashMap<String, Object> map3 = GenDiff.genDiff(map1, map2);
        String t = map3.toString();
        return t.replace("=", ": ").replace(",", "\n")
                .replace("{", "{\n ").replace("}", "\n}");
    }
}
