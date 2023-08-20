package hexlet.code;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;
import java.util.TreeMap;

public class GenDiff {
    public static LinkedHashMap<String, Object> genDiff(Map<String, Object> data1, Map<String, Object> data2) {
        LinkedHashMap<String, Object> result = new LinkedHashMap<>();
        Set<String> united = new HashSet<>(data1.keySet());
        united.addAll(data2.keySet());
        Set<String> intersection = new HashSet<>(data1.keySet());
        intersection.retainAll(data2.keySet());
        LinkedHashMap<String, Object>  intermediate = new LinkedHashMap<>();
        for (String s1 : united) {
            if (data1.containsKey(s1)) {
                intermediate.put(s1, data1.get(s1));
            } else {
                intermediate.put(s1, data2.get(s1));
            }
        }
        TreeMap<String, Object> sorted = new TreeMap<>(intermediate);
        intermediate.clear();
        intermediate.putAll(sorted);
        for (String s : intermediate.keySet()) {
            if (intersection.contains(s)) {
                if (data1.get(s).equals(data2.get(s))) {
                    result.put("  " + s, data1.get(s));
                } else {
                    result.put("- " + s, data1.get(s));
                    result.put("+ " + s, data2.get(s));
                }
                continue;
            }
            if (data1.containsKey(s)) {
                result.put("- " + s, data1.get(s));
            } else {
                result.put("+ " + s, data2.get(s));
            }
        }
        return result;
    }
}
