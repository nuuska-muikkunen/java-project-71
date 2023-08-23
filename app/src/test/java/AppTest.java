
import hexlet.code.Differ;
import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.BeforeEach;
import static org.assertj.core.api.Assertions.assertThat;

public class AppTest {
    @Test
    public void normTest() throws Exception {
        var expected = """
                {
                 - follow: false
                   host: hexlet.io
                 - proxy: 123.234.53.22
                 - timeout: 50
                 + timeout: 20
                 + verbose: true
                }""";
        String result = Differ.generate("/home/newcomer/java-project-71/app/src/test/resources/f1.json",
                "/home/newcomer/java-project-71/app/src/test/resources/f2.json", "stylish");
        assertThat(result).isEqualTo(expected);
    }
    @Test
    public void equalTest() throws Exception {
        var expected = """
                {
                   host: hexlet.io
                 - timeout: 50
                 + timeout: 20
                   verbose: true
                }""";
        String result = Differ.generate("/home/newcomer/java-project-71/app/src/test/resources/file2.json",
                "/home/newcomer/java-project-71/app/src/test/resources/file1.json", "stylish");
        assertThat(result).isEqualTo(expected);
    }
    @Test
    public void equalYamlTest() throws Exception {
        var expected = """
                {
                   host: hexlet.io
                 - timeout: 50
                 + timeout: 20
                   verbose: true
                }""";
        String result = Differ.generate("/home/newcomer/java-project-71/app/src/test/resources/file2.yaml",
                "/home/newcomer/java-project-71/app/src/test/resources/file1.yaml", "yaml");
        assertThat(result).isEqualTo(expected);
    }
}
