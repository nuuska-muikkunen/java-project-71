package hexlet.code;

import java.util.Map;
import java.nio.file.Files;
import java.nio.file.Paths;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
public class Parser {
    public static Map<String, Object> parse(String filePath) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String linesOfFile = Files.readString(Paths.get(filePath).toAbsolutePath().normalize());
        Map<String, Object> map = mapper.readValue(linesOfFile, new TypeReference<>() { });
        return map;
    }
}
