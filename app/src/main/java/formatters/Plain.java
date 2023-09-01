package formatters;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import static hexlet.code.SortBySubstring.sortMapBySubstring;
import static org.apache.commons.lang3.ClassUtils.isPrimitiveOrWrapper;

public class Plain {
    public static String plain(LinkedHashMap<String, Object> resultOfComparedFiles) {
        LinkedHashMap<String, Object> temp = sortMapBySubstring(resultOfComparedFiles);
        StringBuilder formattedString = new StringBuilder();
        ArrayList<String> changed = new ArrayList<>();
        String complexValue = "[complex value]";
        String s;
        for (String j : temp.keySet()) {
            switch (j.substring(0, 4)) {
                case "  - " -> {
                    s = j.replace("  - ", "  + ");
                    if (temp.containsKey(s)) {
                        changed.add(s);
                        var value1 = temp.get(j) instanceof String || isPrimitiveOrWrapper(temp.get(j).getClass())
                                ? temp.get(j) : complexValue;
                        var value2 = temp.get(s) instanceof String || isPrimitiveOrWrapper(temp.get(s).getClass())
                                ? temp.get(s) : complexValue;
                        formattedString.append("Property '").append(j.substring(4)).append("' was updated. From ")
                            .append(value1 instanceof String && !value1.equals(complexValue) && !value1.equals("null")
                                        ? "'" + value1 + "'" : value1).append(" to ")
                            .append(value2 instanceof String && !value2.equals(complexValue) && !value2.equals("null")
                                        ? "'" + value2 + "'" : value2).append("\n");
                    } else {
                        formattedString.append("Property '").append(j.substring(4)).append("' was removed\n");
                    }
                }
                case "  + " -> {
                    var value = temp.get(j) instanceof String || isPrimitiveOrWrapper(temp.get(j).getClass())
                            ? temp.get(j).toString() : complexValue;
                    if (!changed.contains(j)) {
                        formattedString.append("Property '").append(j.substring(4)).
                                append("' was added with value: ")
                                .append(value instanceof String && !value.equals(complexValue) && !value.equals("null")
                                        ? "'" + value + "'" : value).append("\n");
                    }
                }
                default -> {
                }
            }
        }
        return formattedString.substring(0, formattedString.length() - 1);
    }
}

