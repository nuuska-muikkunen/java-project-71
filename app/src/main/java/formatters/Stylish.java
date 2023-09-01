package formatters;

import java.util.LinkedHashMap;
import static hexlet.code.SortBySubstring.sortMapBySubstring;

public class Stylish {
    public static String stylish(LinkedHashMap<String, Object> resultOfComparedFiles) {
        LinkedHashMap<String, Object> temp = sortMapBySubstring(resultOfComparedFiles);
        StringBuilder formattedString = new StringBuilder("{\n");
        for (String j: temp.keySet()) {
            formattedString.append(j).append(": ").append(temp.get(j)).append("\n");
        }
        formattedString.append("}");
        return formattedString.toString();
    }
}
