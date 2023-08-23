package hexlet.code;

import java.util.Map;
import java.nio.file.Files;
import java.nio.file.Paths;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.yaml.snakeyaml.Yaml;

public class Parser {
    public static Map<String, Object> parse(String filePath) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String linesOfFile = Files.readString(Paths.get(filePath).toAbsolutePath().normalize());
        return mapper.readValue(linesOfFile, new TypeReference<>() { });
    }

    public static Map<String, Object> parseYaml(String filePath) throws Exception {
        String linesOfFile = Files.readString(Paths.get(filePath).toAbsolutePath().normalize());
        Yaml yaml = new Yaml();
        return yaml.load(linesOfFile);
    }
}
