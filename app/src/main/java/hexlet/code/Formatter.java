package hexlet.code;

import formatters.Plain;
import formatters.Stylish;
import formatters.Json;
import java.util.LinkedHashMap;
import static hexlet.code.SortBySubstring.sortMapBySubstring;

public class Formatter {
    public static String formatter(LinkedHashMap<String, Object> resultOfComparedFiles, String format)
                         throws Exception {
        var mapWithNullValues = sortMapBySubstring(resultOfComparedFiles);
        for (String s: mapWithNullValues.keySet()) {
            if (mapWithNullValues.get(s).equals("null")) {
                mapWithNullValues.replace(s, null);
            }
        }
        switch (format) {
            case "plain" -> {
                return Plain.plain(mapWithNullValues);
            }
            case "json" -> {
                return Json.json(mapWithNullValues);
            }
            default -> {
                return Stylish.stylish(mapWithNullValues);
            }
        }
    }
}
