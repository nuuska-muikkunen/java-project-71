package hexlet.code;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class SortBySubstring {
    public static LinkedHashMap<String, Object> sortMapBySubstring(LinkedHashMap<String, Object> map) {
        LinkedHashMap<String, Object> sortedMap
                = map.entrySet()
                .stream()
                .sorted((i1, i2)
                        -> i1.getKey().substring(4).compareTo(
                        i2.getKey().substring(4)))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1, LinkedHashMap::new));
        return sortedMap;
    }
}
