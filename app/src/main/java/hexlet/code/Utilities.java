package hexlet.code;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class Utilities {
    public static boolean isListOrMap(Object value) {
        return value instanceof Map || value instanceof List;
    }
    public static boolean quotationsNeeded(Object value) {
        return !isListOrMap(value) && !value.equals("null") && !value.equals(false)
                && !value.equals(true) && !(value instanceof Number);
    }
    public static Object quotateObject(Object element) {
        if (element instanceof List) {
            List<Object> tempList = new ArrayList<>();
            for (Object key : (List) element) {
                if (!(key instanceof Number)) {
                    tempList.add("\"" + key + "\"");
                } else {
                    tempList.add(key);
                }
            }
            return tempList;
        }
        if (element instanceof Map) {
            Map<String, Object> tempMap = new HashMap<>();
            for (Object key: ((Map<?, ?>) element).keySet()) {
                if (!(((Map<?, ?>) element).get(key) instanceof Number)) {
                    tempMap.put("\"" + key + "\"",
                            quotationsNeeded(((Map<?, ?>) element).get(key))
                                    ? "\"" + ((Map<?, ?>) element).get(key) + "\""
                                    : ((Map<?, ?>) element).get(key));
                } else {
                    tempMap.put((String) key, ((Map<?, ?>) element).get(key));
                }
            }
            StringBuilder mini = new StringBuilder("{\n");
            for (String key: tempMap.keySet()) {
                mini.append("    ").append(key).append(" : ").append(tempMap.get(key)).append(",\n");
            }
            mini.replace(mini.length() - 2, mini.length() - 1, "").append("  }");
            return mini;
        }
        return element;
    }
}
