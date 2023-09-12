import hexlet.code.Differ;
import org.junit.jupiter.api.Test;
import static hexlet.code.FilePath.fileName;
import static hexlet.code.FilePath.fixture;
import static hexlet.code.FixtureToString.fixtureToString;
import static org.assertj.core.api.Assertions.assertThat;

public class AppTest {
    @Test
    public void recursiveTest() throws Exception {
        var expected = fixtureToString(fixture("expected.stylish"));
        System.out.println(expected.length());
        String result = Differ.generate(fileName("file_1.json"),
                fileName("file_2.json"), "stylish");
        System.out.println(result.length());
        assertThat(result).isEqualTo(expected);
    }
    @Test
    public void recursiveTest2() throws Exception {
        var expected = fixtureToString(fixture("expected.stylish"));
        String result = Differ.generate(fileName("file_1.json"),
                fileName("file_2.json"));
        assertThat(result).isEqualTo(expected);
    }
    @Test
    public void yamlTest() throws Exception {
        var expected = fixtureToString(fixture("expected.stylish"));
        String result = Differ.generate(fileName("file1.yml"),
                fileName("file2.yml"), "yaml");
        assertThat(result).isEqualTo(expected);
    }
    @Test
    public void plainTest() throws Exception {
        var expected = fixtureToString(fixture("expected.plain"));
        String result = Differ.generate(fileName("file_1.json"),
                fileName("file_2.json"), "plain");
        assertThat(result).isEqualTo(expected);
    }
    @Test
    public void jsonTest() throws Exception {
        var expected = fixtureToString(fixture("expected.json"));
        String result = Differ.generate(fileName("file_1.json"),
                fileName("file_2.json"), "json");
        assertThat(result).isEqualTo(expected);
    }
    @Test
    public void differentTypesOfFilesTest() throws Exception {
        var expected = "The files are of different types";
        String result = Differ.generate(fileName("file2.yml"),
                fileName("file_2.json"), "stylish");
        assertThat(result).isEqualTo(expected);
    }
    @Test
    public void unknownTypeOfFilesTest() throws Exception {
        var expected = "There are files of unknown format";
        String result = Differ.generate(fileName("foo1.doc"),
                fileName("foo2.doc"), "stylish");
        assertThat(result).isEqualTo(expected);
    }
}
