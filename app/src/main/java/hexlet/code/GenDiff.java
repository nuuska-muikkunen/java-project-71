package hexlet.code;

import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;
import java.util.Map;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ArrayList;

public class GenDiff {
    public static List<Map<String, Object>> genDiff(Map<String, Object> map1, Map<String, Object> map2)
            throws Exception {
        List<Map<String, Object>> treeOfChanges = new ArrayList<>();
        Set<Object> keys = new TreeSet<>(map1.keySet());
        keys.addAll(map2.keySet());
        Set<Object> sortedKeys = new TreeSet<>(keys);
        for (Object key : sortedKeys) {
            var value1 = map1.get(key) == null ? "null" : map1.get(key);
            var value2 = map2.get(key) == null ? "null" : map2.get(key);
            Map<String, Object> tempMap = new LinkedHashMap<>();
            tempMap.put("key", key);
            if (map1.containsKey(key)) {
                tempMap.put("type of change", "delete");
            }
            if (map2.containsKey(key)) {
                tempMap.put("type of change", "add");
            }
            if (map1.containsKey(key) && map2.containsKey(key)) {
                if (Objects.equals(value1, value2)) {
                    tempMap.put("type of change", "nothing");
                } else {
                    tempMap.put("type of change", "change");
                }
            }
            tempMap.put("value", value1);
            tempMap.put("value2", value2);
            treeOfChanges.add(tempMap);
        }
        return treeOfChanges;
    }
}
