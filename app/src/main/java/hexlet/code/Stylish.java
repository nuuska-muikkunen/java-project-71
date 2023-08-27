package hexlet.code;

import static hexlet.code.SortBySubstring.sortMapBySubstring;
import java.util.LinkedHashMap;
public class Stylish {
    public static String stylish(LinkedHashMap<String, Object> resultOfComparedFiles) {
        LinkedHashMap<String, Object> temp = sortMapBySubstring(resultOfComparedFiles);
        StringBuilder formattedString = new StringBuilder("{\n");
        for (String j: temp.keySet()) {
            formattedString.append(j + ": " + temp.get(j) + "\n");
        }
        formattedString.append("}");
        return formattedString.toString();
    }
}
