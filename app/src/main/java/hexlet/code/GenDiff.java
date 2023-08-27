package hexlet.code;

import java.util.Map;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.HashSet;

public class GenDiff {
    public static LinkedHashMap<String, Object> genDiff(Map<String, Object> map1, Map<String, Object> map2)
            throws Exception {
        LinkedHashMap<String, Object>  result = new LinkedHashMap<>();
        Set<String> united = new HashSet<>(map1.keySet());
        Set<String> intersection = new HashSet<>(map1.keySet());
        united.addAll(map2.keySet());
        intersection.retainAll(map2.keySet());
        for (String string: united) {
            var map1Value = map1.get(string) == null ? "null" : map1.get(string);
            var map2Value = map2.get(string) == null ? "null" : map2.get(string);
            if (intersection.contains(string)) {
                if (map1Value.equals(map2Value)) {
                    result.put("    " + string, map1Value);
                } else {
                    result.put("  - " + string, map1Value);
                    result.put("  + " + string, map2Value);
                }
                continue;
            }
            if (map1.containsKey(string)) {
                result.put("  - " + string, map1Value);
            } else {
                result.put("  + " + string, map2Value);
            }
        }
        return result;
    }
}
