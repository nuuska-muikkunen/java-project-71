package hexlet.code;

import java.util.Map;
import java.util.List;
import java.util.TreeSet;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.Objects;

public class GenDiff {

    public static Object replaceNullValueWithStringNull(Object object) {
        return object == null ? "null" : object;
    }

    public static List<Map<String, Object>> genDiff(Map<String, Object> map1, Map<String, Object> map2) {
        List<Map<String, Object>> treeOfChanges = new ArrayList<>();
        Set<Object> keys = new TreeSet<>(map1.keySet());
        keys.addAll(map2.keySet());
        Set<Object> sortedKeys = new TreeSet<>(keys);
        for (Object key : sortedKeys) {
            var value1 = replaceNullValueWithStringNull(map1.get(key));
            var value2 = replaceNullValueWithStringNull(map2.get(key));
            Map<String, Object> tempMap = new LinkedHashMap<>();
            tempMap.put("key", key);
            if (map1.containsKey(key)) {
                tempMap.put("type of change", "delete");
                tempMap.put("oldValue", value1);
            }
            if (map2.containsKey(key)) {
                tempMap.put("type of change", "add");
                tempMap.put("newValue", value2);
            }
            if (map1.containsKey(key) && map2.containsKey(key)) {
                if (Objects.equals(value1, value2)) {
                    tempMap.put("type of change", "nothing");
                } else {
                    tempMap.put("type of change", "change");
                }
                tempMap.put("oldValue", value1);
                tempMap.put("newValue", value2);
            }
            treeOfChanges.add(tempMap);
        }
        return treeOfChanges;
    }
    //        sortedKeys.stream()
//                .peek(o -> {
//                    Map<String, Object> tempMap = new LinkedHashMap<>();
//                    tempMap.put("key", o);
//                    var value1 = map1.get(o) == null ? "null" : map1.get(o);
//                    var value2 = map2.get(o) == null ? "null" : map2.get(o);
//                    var typeOfChange = map1.containsKey(o) && !map2.containsKey(o) ? "delete" : "change";
//                    typeOfChange = map2.containsKey(o) && !map1.containsKey(o) ? "add" : "change";
//                    typeOfChange = (Objects.equals(value1, value2)) ? "nothing" : "change";
//                    tempMap.put("type of change", typeOfChange);
//                    tempMap.put("value", value1);
//                    tempMap.put("value2", value2);
//                    treeOfChanges.add(tempMap);
//                })
//                .toList();
//        System.out.println(treeOfChanges);
//        return treeOfChanges;
}
