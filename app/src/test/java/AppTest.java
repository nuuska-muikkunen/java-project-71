
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.assertj.core.api.Assertions.assertThat;

public class AppTest {
    @Test
    public void normTest() {
        var expected = "{\n- follow: false\nhost: hexlet.io\n- proxy: 123.234.53.22\n- timeout: 50\n+ timeout: 20\n+ verbose: true}";
        String result = Differ.generate(/name/newcomer/java-project-71/app/src/test/resources/f1.json,
                                        /name/newcomer/java-project-71/app/src/test/resources/f2.json);
            assertThat(result).isEqualTo(expected);
    }
}