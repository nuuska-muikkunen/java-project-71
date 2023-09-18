package hexlet.code;

import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

public class GenDiff {
    public static List<Map<String, Object>> genDiff(Map<String, Object> map1, Map<String, Object> map2)
            throws Exception {
        List<Map<String, Object>> treeOfChanges = new ArrayList<>();
        Set<String> unitedKeys = new HashSet<>(map1.keySet());
        unitedKeys.addAll(map2.keySet());
        Set<String> keysOnlyFromMap1 = new HashSet<>(unitedKeys);
        keysOnlyFromMap1.removeAll(map2.keySet());
        Set<String> keysOnlyFromMap2 = new HashSet<>(unitedKeys);
        keysOnlyFromMap2.removeAll(map1.keySet());
        Set<String> keysInBothMaps = new HashSet<>(map1.keySet());
        keysInBothMaps.retainAll(map2.keySet());
        for (String string: keysOnlyFromMap1) {
            Map<String, Object> tempMap = new HashMap<>(Map.of("key", string,
                    "type of change", "delete", "value", map1.get(string) == null ? "null" : map1.get(string),
                    "value2", ""));
            treeOfChanges.add(tempMap);
        }
        for (String string1: keysOnlyFromMap2) {
            Map<String, Object> tempMap1 = new HashMap<>(Map.of("key", string1,
                    "type of change", "add",
                    "value", "", "value2", map2.get(string1) == null ? "null" : map2.get(string1)));
            treeOfChanges.add(tempMap1);
        }
        for (String string2: keysInBothMaps) {
            var value1 = map1.get(string2) == null ? "null" : map1.get(string2);
            var value2 = map2.get(string2) == null ? "null" : map2.get(string2);
            if (Objects.equals(value1, value2)) {
                Map<String, Object> tempMap2 = new HashMap<>(Map.of("key", string2,
                        "type of change", "nothing", "value", value1, "value2", ""));
                treeOfChanges.add(tempMap2);
            } else {
                Map<String, Object> tempMap2 = new HashMap<>(Map.of("key", string2,
                        "type of change", "change", "value", value1, "value2", value2));
                treeOfChanges.add(tempMap2);
            }
        }
        return treeOfChanges;
    }
}
