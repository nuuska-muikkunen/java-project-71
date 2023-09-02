package hexlet.code;

import java.util.Map;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.Objects;
import java.util.HashSet;

public class GenDiff {
    public static LinkedHashMap<String, Object> genDiff(Map<String, Object> map1, Map<String, Object> map2)
            throws Exception {
        LinkedHashMap<String, Object>  result = new LinkedHashMap<>();
        Set<String> unitedKeys = new HashSet<>(map1.keySet());
        unitedKeys.addAll(map2.keySet());
        Set<String> intersectingKeys = new HashSet<>(map1.keySet());
        intersectingKeys.retainAll(map2.keySet());
        Set<String> onlySingleMapKeys = new HashSet<>(unitedKeys);
        onlySingleMapKeys.removeAll(intersectingKeys);
        for (String string1: onlySingleMapKeys) {
            if (map1.containsKey(string1)) {
                result.put("  - " + string1, map1.get(string1) == null ? "null" : map1.get(string1));
            } else {
                result.put("  + " + string1, map2.get(string1) == null ? "null" : map2.get(string1));
            }
        }
        for (String string2: intersectingKeys) {
            var map1Value = map1.get(string2) == null ? "null" : map1.get(string2);
            var map2Value = map2.get(string2) == null ? "null" : map2.get(string2);
            if (Objects.equals(map1.get(string2), map2.get(string2))) {
                result.put("    " + string2, map1Value);
            } else {
                result.put("  - " + string2, map1Value);
                result.put("  + " + string2, map2Value);
            }
        }
        return result;
    }
}
