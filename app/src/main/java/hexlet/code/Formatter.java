package hexlet.code;

import formatters.Plain;
import formatters.Stylish;
import formatters.Json;
import java.util.LinkedHashMap;

public class Formatter {
    public static String formatter(LinkedHashMap<String, Object> resultOfComparedFiles, String format)
                         throws Exception {
        switch (format) {
            case "plain" -> {
                return Plain.plain(resultOfComparedFiles);
            }
            case "json" -> {
                return Json.json(resultOfComparedFiles);
            }
            default -> {
                return Stylish.stylish(resultOfComparedFiles);
            }
        }
    }
}
