package hexlet.code;

import java.util.Map;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.Objects;
import java.util.HashSet;

public class GenDiff {
    public static LinkedHashMap<String, Object> genDiff(Map<String, Object> map1, Map<String, Object> map2)
            throws Exception {
        LinkedHashMap<String, Object> result = new LinkedHashMap<>();
        Set<String> keysInBothMaps = new HashSet<>(map1.keySet());
        keysInBothMaps.retainAll(map2.keySet());
        for (String string: map1.keySet()) {
            result.put("  - " + string, map1.get(string) == null ? "null" : map1.get(string));
        }
        for (String string1: map2.keySet()) {
            result.put("  + " + string1, map2.get(string1) == null ? "null" : map2.get(string1));
        }
        for (String string2: keysInBothMaps) {
            var value1 = map1.get(string2) == null ? "null" : map1.get(string2);
            var value2 = map2.get(string2) == null ? "null" : map2.get(string2);
            if (Objects.equals(value1, value2)) {
                result.remove("  - " + string2);
                result.remove("  + " + string2);
                result.put("    " + string2, value1);
            }
        }
        return result;
    }
}
