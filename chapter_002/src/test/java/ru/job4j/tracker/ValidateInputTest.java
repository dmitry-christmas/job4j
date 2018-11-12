package ru.job4j.tracker;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * @author Dmitry Rozhdestvenskiy (mailto:dmr1433@gmail.com)
 *  @version $Id$
 *  @since 0.1
 */
public class ValidateInputTest {
    private final PrintStream stdout = System.out;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    @Before
    public void loadOutput() {
        System.setOut(new PrintStream(this.out));
    }
    @After
    public void backOutPut() {
        System.setOut(this.stdout);
    }
    @Test
    public void whenInvalidInput() {
        int [] range = {0, 1, 2, 3, 4, 5, 6};
        ValidateInput input = new ValidateInput(new StubInput(new String[]{"b", "1"}));
        input.ask("Выберите пункт меню", range);
        assertThat(this.out.toString(), is(
                String.format("Введите корректное значение меню.%s", System.lineSeparator()))
        );
    }
}
