package hexlet.code;

import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;

public class FixtureToString {
    public static String fixtureToString(String filePath) throws Exception {
        File file = new File(filePath);
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        StringBuilder s = new StringBuilder("");
        String line;
        while ((line = br.readLine()) != null) {
            s.append(line + "\n");
        }
        return s.substring(0, s.length() - 1).trim();
    }
}
