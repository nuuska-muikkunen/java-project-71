import hexlet.code.Differ;
import org.junit.jupiter.api.Test;
import static hexlet.code.Differ.fixture;
import static hexlet.code.Differ.fixtureToString;
import static org.assertj.core.api.Assertions.assertThat;

public class AppTest {
    @Test
    public void recursiveTest() throws Exception {
        var expected = fixtureToString(fixture("expected.stylish"));
        String result = Differ.generate(fixture("file_1.json"),
                fixture("file_2.json"), "stylish");
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
