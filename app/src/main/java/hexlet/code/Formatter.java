package hexlet.code;

import formatters.Plain;
import formatters.Stylish;
import formatters.Json;
import java.util.LinkedHashMap;

import static hexlet.code.SortBySubstring.sortMapBySubstring;

public class Formatter {
    public static String formatter(LinkedHashMap<String, Object> resultOfComparedFiles, String format) {
        LinkedHashMap<String, Object> sortedMap = sortMapBySubstring(resultOfComparedFiles);
        switch (format) {
            case "plain" -> {
                return Plain.plain(sortedMap);
            }
            case "json" -> {
                return Json.json(sortedMap);
            }
            default -> {
                return Stylish.stylish(sortedMap);
            }
        }
    }
}
