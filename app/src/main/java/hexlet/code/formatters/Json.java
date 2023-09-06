package hexlet.code.formatters;

import java.io.File;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.LinkedHashMap;

public class Json {
    public static String json(LinkedHashMap<String, Object> sortedMap) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File("src/test/resources/output.json"), sortedMap);
        return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(sortedMap);
    }
}
