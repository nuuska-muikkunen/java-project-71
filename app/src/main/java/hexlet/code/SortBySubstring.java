package hexlet.code;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class SortBySubstring {
    private static final int PREFIX_LENGTH = 4;
    public static LinkedHashMap<String, Object> sortMapBySubstring(LinkedHashMap<String, Object> map) {
        return map.entrySet()
                .stream()
                .sorted(Comparator.comparing(i -> i.getKey().substring(PREFIX_LENGTH)))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1, LinkedHashMap::new));
    }
}
