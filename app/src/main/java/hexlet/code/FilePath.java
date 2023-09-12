package hexlet.code;

public class FilePath {
    static final String PATH_TO_FILE = "src/test/resources/";
    static final String PATH_TO_FIXTURE = "src/test/resources/fixtures/";
    public static String fileName(String nameOfFile) {
        return PATH_TO_FILE + nameOfFile;
    }
    public static String fixture(String nameOfFile) {
        return PATH_TO_FIXTURE + nameOfFile;
    }
}
