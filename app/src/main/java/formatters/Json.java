package formatters;

import java.io.File;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.LinkedHashMap;

public class Json {
    public static String json(LinkedHashMap<String, Object> sortedMap) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File("/home/newcomer/java-project-71/app/src/test/resources/output.json"), sortedMap);
        String jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(sortedMap);
        return jsonString;
    }
}
