package ru.job4j.pseudo;
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
public class PaintTest {
    @Test
    public void whenDrawSquare() {
        PrintStream stdout = System.out;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        new Paint().draw(new Square());
        assertThat(new String(out.toByteArray()), is(
                new StringBuilder()
                .append("XXXXXX\r\n")
                .append("X    X\r\n")
                .append("XXXXXX")
                .append(System.lineSeparator())
                .toString()
        ));
        System.setOut(stdout);
    }
    @Test
    public void whenDrawTriangle() {
        PrintStream stdout = System.out;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        new Paint().draw(new Triangle());
        assertThat(new String(out.toByteArray()), is(
                new StringBuilder()
                .append("   X   ")
                .append(System.lineSeparator())
                .append("  XXX  ")
                .append(System.lineSeparator())
                .append(" XXXXX ")
                .append(System.lineSeparator())
                .append("XXXXXXX")
                .append(System.lineSeparator())
                .toString()
        ));
        System.setOut(stdout);
    }
}
