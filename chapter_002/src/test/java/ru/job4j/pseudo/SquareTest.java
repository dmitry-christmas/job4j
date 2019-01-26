package ru.job4j.pseudo;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * @author Dmitry Rozhdestvenskiy (mailto:dmr1433@gmail.com)
 *  @version $Id$
 *  @since 0.1
 */
public class SquareTest {
    @Test
    public void ifDrawSquareThenAquare() {
        Square square = new Square();
        assertThat(square.draw(), is(
            new StringBuilder()
            .append("XXXXXX")
            .append(System.lineSeparator())
            .append("X    X")
            .append(System.lineSeparator())
            .append("XXXXXX")
            .toString()
        ));

    }
}
