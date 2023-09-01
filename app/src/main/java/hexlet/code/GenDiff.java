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
        Set<String> union = new HashSet<>(map1.keySet());
        union.addAll(map2.keySet());
        Set<String> intersection = new HashSet<>(map1.keySet());
        intersection.retainAll(map2.keySet());
        Set<String> only = new HashSet<>(union);
        only.removeAll(intersection);
        for (String str: only) {
            if (map1.containsKey(str)) {
                result.put("  - " + str, map1.get(str) == null ? "null" : map1.get(str));
            } else {
                result.put("  + " + str, map2.get(str) == null ? "null" : map2.get(str));
            }
        }
        for (String string: intersection) {
            var map1Value = map1.get(string) == null ? "null" : map1.get(string);
            var map2Value = map2.get(string) == null ? "null" : map2.get(string);
            if (Objects.equals(map1.get(string), map2.get(string))) {
                result.put("    " + string, map1Value);
            } else {
                result.put("  - " + string, map1Value);
                result.put("  + " + string, map2Value);
            }
        }
        return result;
    }
}
