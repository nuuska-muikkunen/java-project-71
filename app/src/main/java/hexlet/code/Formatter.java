package hexlet.code;

import formatters.Plain;
import formatters.Stylish;
import java.util.LinkedHashMap;

public class Formatter {
    public static String formatter(LinkedHashMap<String, Object> map, String format) {
        switch (format) {
            case "plain" -> {
                return Plain.plain(map);
            }
            default -> {
                return Stylish.stylish(map);
            }
        }
    }
}
