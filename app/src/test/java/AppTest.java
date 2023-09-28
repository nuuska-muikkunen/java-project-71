import hexlet.code.Differ;
import org.junit.jupiter.api.Test;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import static org.assertj.core.api.Assertions.assertThat;

public class AppTest {
    static final String PATH_TO_FIXTURE = "src/test/resources/fixtures/";

    public static String fixture(String nameOfFile) {
        return PATH_TO_FIXTURE + nameOfFile;
    }

    public static String fixtureToString(String filePath) throws Exception {
        File file = new File(filePath);
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        StringBuilder s = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null) {
            s.append(line).append("\n");
        }
        return s.substring(0, s.length() - 1).trim();
    }

    @Test
    public void recursiveTest() throws Exception {
//        is not working properly - needs review
//        var expected = Files.readString(Paths.get(fixture("expected.stylish"))
//                .toAbsolutePath().normalize()).trim();
        var expected = fixtureToString(fixture("expected.stylish"));
        String result = Differ.generate(fixture("file_1.json"),
                fixture("file_2.json"), "stylish");
        System.out.println("result length = " + result.length());
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void recursiveTest2() throws Exception {
        var expected = fixtureToString(fixture("expected.stylish"));
        String result = Differ.generate(fixture("file_1.json"),
                fixture("file_2.json"));
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void yamlTest() throws Exception {
        var expected = fixtureToString(fixture("expected.stylish"));
        String result = Differ.generate(fixture("file1.yml"),
                fixture("file2.yml"), "yaml");
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void plainTest() throws Exception {
        var expected = fixtureToString(fixture("expected.plain"));
        String result = Differ.generate(fixture("file_1.json"),
                fixture("file_2.json"), "plain");
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void jsonTest() throws Exception {
        var expected = fixtureToString(fixture("expected.json"));
        String result = Differ.generate(fixture("file_1.json"),
                fixture("file_2.json"), "json");
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void differentTypesOfFilesTest() throws Exception {
        var expected = "The files are of different types";
        String result = Differ.generate(fixture("file2.yml"),
                fixture("file_2.json"), "stylish");
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void unknownTypeOfFilesTest() throws Exception {
        var expected = "There are files of unknown format";
        String result = Differ.generate(fixture("foo1.doc"),
                fixture("foo2.doc"), "stylish");
        assertThat(result).isEqualTo(expected);
    }
}
