package ru.job4j.array;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * @author Dmitry Rozhdestvenskiy (mailto:dmr1433@gmail.com)
 *  @version $Id$
 *  @since 0.1
 */
public class TurnTest {
    @Test
    public void whenArray12345Then54321() {
        Turn turner = new Turn();
        int[] result = turner.turn(new int[]{1, 2, 3, 4, 5});
        int[] expect = new int[]{5, 4, 3, 2, 1};
        assertThat(result, is(expect));
    }
    @Test
    public void whenArray1234Then5432() {
        Turn turner = new Turn();
        int[] result = turner.turn(new int[]{1, 2, 3, 4});
        int[] expect = new int[]{4, 3, 2, 1};
        assertThat(result, is(expect));
    }
}
