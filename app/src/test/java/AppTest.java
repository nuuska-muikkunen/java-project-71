
import hexlet.code.Differ;
import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.BeforeEach;
import static org.assertj.core.api.Assertions.assertThat;

public class AppTest {
//    @Test
//    public void normTest() throws Exception {
//        var expected = """
//                {
//                 - follow: false
//                   host: hexlet.io
//                 - proxy: 123.234.53.22
//                 - timeout: 50
//                 + timeout: 20
//                 + verbose: true
//                }""";
//        String result = Differ.generate("/home/newcomer/java-project-71/app/src/test/resources/f1.json",
//                "/home/newcomer/java-project-71/app/src/test/resources/f2.json", "stylish");
//        assertThat(result).isEqualTo(expected);
//    }
//    @Test
//    public void equalTest() throws Exception {
//        var expected = """
//                {
//                   host: hexlet.io
//                 - timeout: 50
//                 + timeout: 20
//                   verbose: true
//                }""";
//        String result = Differ.generate("/home/newcomer/java-project-71/app/src/test/resources/file2.json",
//                "/home/newcomer/java-project-71/app/src/test/resources/file1.json", "stylish");
//        assertThat(result).isEqualTo(expected);
//    }
//    @Test
//    public void equalYamlTest() throws Exception {
//        var expected = """
//                {
//                   host: hexlet.io
//                 - timeout: 50
//                 + timeout: 20
//                   verbose: true
//                }""";
//        String result = Differ.generate("/home/newcomer/java-project-71/app/src/test/resources/file2.yaml",
//                "/home/newcomer/java-project-71/app/src/test/resources/file1.yaml", "yaml");
//        assertThat(result).isEqualTo(expected);
//    }
    @Test
    public void recursiveTest() throws Exception {
        var expected = """
                {
                    chars1: [a, b, c]
                  - chars2: [d, e, f]
                  + chars2: false
                  - checked: false
                  + checked: true
                  - default: null
                  + default: [value1, value2]
                  - id: 45
                  + id: null
                  - key1: value1
                  + key2: value2
                    numbers1: [1, 2, 3, 4]
                  - numbers2: [2, 3, 4, 5]
                  + numbers2: [22, 33, 44, 55]
                  - numbers3: [3, 4, 5]
                  + numbers4: [4, 5, 6]
                  + obj1: {nestedKey=value, isNested=true}
                  - setting1: Some value
                  + setting1: Another value
                  - setting2: 200
                  + setting2: 300
                  - setting3: true
                  + setting3: none
                }""";
        String result = Differ.generate("src/test/resources/file_1.json",
                "src/test/resources/file_2.json", "stylish");
        assertThat(result).isEqualTo(expected);
    }
    @Test
    public void yamlTest() throws Exception {
        var expected = """
                {
                    chars1: [a, b, c]
                  - chars2: [d, e, f]
                  + chars2: false
                  - checked: false
                  + checked: true
                  - default: null
                  + default: [value1, value2]
                  - id: 45
                  + id: null
                  - key1: value1
                  + key2: value2
                    numbers1: [1, 2, 3, 4]
                  - numbers2: [2, 3, 4, 5]
                  + numbers2: [22, 33, 44, 55]
                  - numbers3: [3, 4, 5]
                  + numbers4: [4, 5, 6]
                  + obj1: {nestedKey=value, isNested=true}
                  - setting1: Some value
                  + setting1: Another value
                  - setting2: 200
                  + setting2: 300
                  - setting3: true
                  + setting3: none
                }""";
        String result = Differ.generate("src/test/resources/file1.yml",
                "src/test/resources/file2.yml", "yaml");
        assertThat(result).isEqualTo(expected);
    }
//    @Test
//    public void plainTest() throws Exception {
//        var expected = """
//                {
//                    chars1: [a, b, c]
//                  - chars2: [d, e, f]
//                  + chars2: false
//                  - checked: false
//                  + checked: true
//                  - default: null
//                  + default: [value1, value2]
//                  - id: 45
//                  + id: null
//                  - key1: value1
//                  + key2: value2
//                    numbers1: [1, 2, 3, 4]
//                  - numbers2: [2, 3, 4, 5]
//                  + numbers2: [22, 33, 44, 55]
//                  - numbers3: [3, 4, 5]
//                  + numbers4: [4, 5, 6]
//                  + obj1: {nestedKey=value, isNested=true}
//                  - setting1: Some value
//                  + setting1: Another value
//                  - setting2: 200
//                  + setting2: 300
//                  - setting3: true
//                  + setting3: none
//                }""";
//        String result = Differ.generate("src/test/resources/file_1.json",
//                "src/test/resources/file_2.json", "stylish");
//        assertThat(result).isEqualTo(expected);
//    }
}
