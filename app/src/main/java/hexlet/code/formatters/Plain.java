package hexlet.code.formatters;

import hexlet.code.Utilities;

import java.util.List;
import java.util.Map;

public class Plain {
    public static String plain(List<Map<String, Object>> listForFormatting) {
        StringBuilder formattedString = new StringBuilder();
        listForFormatting.forEach(map -> {
            var value1 = Utilities.isListOrMap(map.get("value")) ? "[complex value]" : map.get("value");
            var value2 = Utilities.isListOrMap(map.get("value2")) ? "[complex value]" : map.get("value2");
            switch (map.get("type of change").toString()) {
                case "add" -> {
                    formattedString.append(String.format(Utilities.quotationsNeeded(map.get("value2"))
                            ? "Property '%s' was added with value: '%s'\n" : "Property '%s' was added with value: %s\n",
                            map.get("key"), value2));
                }
                case "delete" -> {
                    formattedString.append(String.format("Property '%s' was removed\n", map.get("key")));
                }
                case "change" -> {
                    StringBuilder stringForOutput = new StringBuilder("Property '%s' was updated. From ")
                            .append(Utilities.quotationsNeeded(map.get("value")) ? "'%s' to " : "%s to ")
                            .append(Utilities.quotationsNeeded(map.get("value2")) ? "'%s'\n" : "%s\n");
                    formattedString.append(String.format(stringForOutput.toString(), map.get("key"), value1, value2));
                }
                default -> { }
            }
        });
        return formattedString.substring(0, formattedString.length() - 1);
    }
}

