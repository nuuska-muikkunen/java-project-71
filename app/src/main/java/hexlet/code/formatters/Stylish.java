package hexlet.code.formatters;

import java.util.List;
import java.util.Map;

public class Stylish {
    public static String stylish(List<Map<String, Object>> listForFormatting) {
        StringBuilder formattedString = new StringBuilder("{\n");
        listForFormatting.forEach(map -> {
            switch (map.get("type of change").toString()) {
                case "add" -> formattedString
                        .append(String.format("%s%s: %s\n", "  + ", map.get("key"), map.get("value2")));
                case "delete" -> formattedString
                        .append(String.format("%s%s: %s\n", "  - ", map.get("key"), map.get("value")));
                case "nothing" -> formattedString
                        .append(String.format("%s%s: %s\n", "    ", map.get("key"), map.get("value")));
                case "change" -> {
                    formattedString.append(String.format("%s%s: %s\n", "  - ", map.get("key"), map.get("value")));
                    formattedString.append(String.format("%s%s: %s\n", "  + ", map.get("key"), map.get("value2")));
                }
                default -> { }
            }
        });
        return formattedString.append("}").toString();
    }
}
