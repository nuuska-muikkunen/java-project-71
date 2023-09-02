package formatters;

import java.util.LinkedHashMap;
public class Json {
    public static String json(LinkedHashMap<String, Object> sortedMap) {
        StringBuilder formattedString = new StringBuilder("{\n");
        for (String j: sortedMap.keySet()) {
            formattedString.append(j).append(": ").append(sortedMap.get(j)).append("\n");
        }
        formattedString.append("}");
        return formattedString.toString();
    }
}
