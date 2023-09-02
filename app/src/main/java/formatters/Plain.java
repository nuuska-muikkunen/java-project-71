package formatters;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import static org.apache.commons.lang3.ClassUtils.isPrimitiveOrWrapper;

public class Plain {
    public static String plain(LinkedHashMap<String, Object> sortedMap) {
        StringBuilder formattedString = new StringBuilder();
        ArrayList<String> changedElementsList = new ArrayList<>();
        String complexValue = "[complex value]";
        String keyWithPlusPrefix;
        for (String currentKey : sortedMap.keySet()) {
            switch (currentKey.substring(0, 4)) {
                case "  - " -> {
                    keyWithPlusPrefix = currentKey.replace("  - ", "  + ");
                    if (sortedMap.containsKey(keyWithPlusPrefix)) {
                        changedElementsList.add(keyWithPlusPrefix);
                        var value1 = sortedMap.get(currentKey) instanceof String
                                || isPrimitiveOrWrapper(sortedMap.get(currentKey).getClass())
                                ? sortedMap.get(currentKey) : complexValue;
                        var value2 = sortedMap.get(keyWithPlusPrefix) instanceof String
                                || isPrimitiveOrWrapper(sortedMap.get(keyWithPlusPrefix).getClass())
                                ? sortedMap.get(keyWithPlusPrefix) : complexValue;
                        formattedString.append("Property '").append(currentKey.substring(4))
                                .append("' was updated. From ")
                                .append(value1 instanceof String
                                        && !value1.equals(complexValue)
                                        && !value1.equals("null")
                                        ? "'" + value1 + "'" : value1).append(" to ")
                                .append(value2 instanceof String
                                        && !value2.equals(complexValue)
                                        && !value2.equals("null")
                                        ? "'" + value2 + "'" : value2).append("\n");
                    } else {
                        formattedString.append("Property '")
                                .append(currentKey.substring(4)).append("' was removed\n");
                    }
                }
                case "  + " -> {
                    if (!changedElementsList.contains(currentKey)) {
                        var value = sortedMap.get(currentKey) instanceof String
                                || isPrimitiveOrWrapper(sortedMap.get(currentKey).getClass())
                                ? sortedMap.get(currentKey).toString() : complexValue;
                        formattedString.append("Property '").append(currentKey.substring(4))
                                .append("' was added with value: ")
                                .append(value instanceof String
                                        && !value.equals(complexValue)
                                        && !value.equals("null")
                                        ? "'" + value + "'" : value).append("\n");
                    }
                }
                default -> {
                }
            }
        }
        //remove excess '/n' at the end of the last line
        return formattedString.substring(0, formattedString.length() - 1);
    }
}
