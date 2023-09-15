package hexlet.code.formatters;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.LinkedHashMap;

public class Json {
    public static String json(LinkedHashMap<String, Object> sortedMap) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(sortedMap);
    }
}
