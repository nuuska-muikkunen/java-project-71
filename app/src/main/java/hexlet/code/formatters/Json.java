package hexlet.code.formatters;

import hexlet.code.Utilities;
import java.util.Map;
import java.util.List;

public class Json {
    public static String json(List<Map<String, Object>> listForFormatting) throws Exception {
        StringBuilder formattedString = new StringBuilder("{\n");
        listForFormatting.forEach(map -> {
            var value1 = Utilities.isListOrMap(map.get("value"))
                    ? Utilities.quotateObject(map.get("value")) : map.get("value");
            var value2 = Utilities.isListOrMap(map.get("value2"))
                    ? Utilities.quotateObject(map.get("value2")) : map.get("value2");
            switch (map.get("type of change").toString()) {
                case "add" -> {
                    formattedString.append(String.format(Utilities.quotationsNeeded(map.get("value2"))
                            ? "  \"%s%s\" : \"%s\",\n" : "  \"%s%s\" : %s,\n", "  + ", map.get("key"), value2));
                }
                case "delete" -> {
                    formattedString.append(String.format(Utilities.quotationsNeeded(map.get("value"))
                            ? "  \"%s%s\" : \"%s\",\n" : "  \"%s%s\" : %s,\n", "  - ", map.get("key"), value1));
                }
                case "nothing" -> {
                    formattedString.append(String.format(Utilities.quotationsNeeded(map.get("value"))
                            ? "  \"%s%s\" : \"%s\",\n" : "  \"%s%s\" : %s,\n", "    ", map.get("key"), value1));
                }
                case "change" -> {
                    formattedString.append(String.format(Utilities.quotationsNeeded(map.get("value"))
                            ? "  \"%s%s\" : \"%s\",\n" : "  \"%s%s\" : %s,\n", "  - ", map.get("key"), value1));
                    formattedString.append(String.format(Utilities.quotationsNeeded(map.get("value2"))
                            ? "  \"%s%s\" : \"%s\",\n" : "  \"%s%s\" : %s,\n", "  + ", map.get("key"), value2));
                }
                default -> { }
            }
        });
        formattedString
                .replace(formattedString.length() - 2, formattedString.length() - 1, "").append("}");
        return formattedString.toString();
    }
}
