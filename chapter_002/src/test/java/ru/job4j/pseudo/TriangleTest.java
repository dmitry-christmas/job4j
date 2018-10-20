package ru.job4j.pseudo;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * @author Dmitry Rozhdestvenskiy (mailto:dmr1433@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class TriangleTest {
    @Test
    public void ifDrawTriangleThenTriangle() {
        Triangle triangle = new Triangle();
        assertThat(triangle.draw(), is(
                new StringBuilder()
                .append("   X   ")
                .append(System.lineSeparator())
                .append("  XXX  ")
                .append(System.lineSeparator())
                .append(" XXXXX ")
                .append(System.lineSeparator())
                .append("XXXXXXX")
                .toString()
        ));

    }
}
