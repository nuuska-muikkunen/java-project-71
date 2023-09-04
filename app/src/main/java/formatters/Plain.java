package formatters;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import static org.apache.commons.lang3.ClassUtils.isPrimitiveOrWrapper;

public class Plain {
    private static final String COMPLEX_VALUE = "[complex value]";
    public static boolean isComplexObject(Object obj) {
        return obj instanceof String || isPrimitiveOrWrapper(obj.getClass());
    }
    public static boolean hasToBeQuoted(Object obj) {
        return obj instanceof String && !obj.equals(COMPLEX_VALUE) && !obj.equals("null");
    }
    public static String plain(LinkedHashMap<String, Object> sortedMap) {
        StringBuilder formattedString = new StringBuilder();
        ArrayList<String> changedElementsList = new ArrayList<>();
        //String complexValue = "[complex value]";
        String keyWithPlusPrefix;
        for (String currentKey : sortedMap.keySet()) {
            switch (currentKey.substring(0, 4)) {
                case "  - " -> {
                    keyWithPlusPrefix = currentKey.replace("  - ", "  + ");
                    if (sortedMap.containsKey(keyWithPlusPrefix)) {
                        changedElementsList.add(keyWithPlusPrefix);
                        var value1 = isComplexObject(sortedMap.get(currentKey))
                                ? sortedMap.get(currentKey) : COMPLEX_VALUE;
                        var value2 = isComplexObject(sortedMap.get(keyWithPlusPrefix))
                                ? sortedMap.get(keyWithPlusPrefix) : COMPLEX_VALUE;
                        formattedString.append("Property '").append(currentKey.substring(4))
                                .append("' was updated. From ")
                                .append(hasToBeQuoted(value1)
                                        ? "'" + value1 + "'" : value1).append(" to ")
                                .append(hasToBeQuoted(value2)
                                        ? "'" + value2 + "'" : value2).append("\n");
                    } else {
                        formattedString.append("Property '")
                                .append(currentKey.substring(4)).append("' was removed\n");
                    }
                }
                case "  + " -> {
                    if (!changedElementsList.contains(currentKey)) {
                        var value = isComplexObject(sortedMap.get(currentKey))
                                ? sortedMap.get(currentKey).toString() : COMPLEX_VALUE;
                        formattedString.append("Property '").append(currentKey.substring(4))
                                .append("' was added with value: ")
                                .append(hasToBeQuoted(value)
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
