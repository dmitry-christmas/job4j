package ru.job4j.max;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * @author Dmitry Rozhdestvenskiy (mailto:dmr1433@gmail.com)
 *  @version $Id$
 *  @since 0.1
 */
public class MaxTest {
    @Test
    public void whenTenIsMoreThanFive() {
        Max maximum = new Max();
        int result = maximum.max(10, 5);
        assertThat(
                result, is(10)
        );
    }
    @Test
    public void whenTenIsMoreThanFiveAndTwo() {
        Max maximum = new Max();
        int result = maximum.max(10, 5, 2);
        assertThat(
                result, is(10)
        );
    }
}
