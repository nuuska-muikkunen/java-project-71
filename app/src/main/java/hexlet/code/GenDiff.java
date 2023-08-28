package hexlet.code;

import java.util.Map;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.HashSet;

public class GenDiff {
    public static LinkedHashMap<String, Object> genDiff(Map<String, Object> map1, Map<String, Object> map2)
            throws Exception {
        LinkedHashMap<String, Object>  result = new LinkedHashMap<>();
        Set<String> intersection = new HashSet<>(map1.keySet());
        intersection.retainAll(map2.keySet());
        Set<String> only1 = new HashSet<>(map1.keySet());
        only1.removeAll(intersection);
        Set<String> only2 = new HashSet<>(map2.keySet());
        only2.removeAll(intersection);
        for (String string1: only1) {
            result.put("  - " + string1, map1.get(string1) == null ? "null" : map1.get(string1));
        }
        for (String string2: only2) {
            result.put("  + " + string2, map2.get(string2) == null ? "null" : map2.get(string2));
        }
        for (String string: intersection) {
            var map1Value = map1.get(string) == null ? "null" : map1.get(string);
            var map2Value = map2.get(string) == null ? "null" : map2.get(string);
            if (map1Value.equals(map2Value)) {
                result.put("    " + string, map1Value);
            } else {
                result.put("  - " + string, map1Value);
                result.put("  + " + string, map2Value);
            }
        }
        return result;
    }
}
