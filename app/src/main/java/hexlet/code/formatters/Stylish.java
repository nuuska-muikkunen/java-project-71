package hexlet.code.formatters;

import java.util.LinkedHashMap;

public class Stylish {
    public static String stylish(LinkedHashMap<String, Object> sortedMap) {
        StringBuilder formattedString = new StringBuilder("{\n");
        for (String j: sortedMap.keySet()) {
            formattedString.append(j).append(": ").append(sortedMap.get(j)).append("\n");
        }
        formattedString.append("}");
        return formattedString.toString();
    }
}
