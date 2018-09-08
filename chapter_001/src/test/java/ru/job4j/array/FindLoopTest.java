package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * @author Dmitry Rozhdestvenskiy (mailto:dmr1433@gmail.com)
 *  @version $Id$
 *  @since 0.1
 */
public class FindLoopTest {
    @Test
    public void whenSearch5Array51015indexIs0() {
        FindLoop find = new FindLoop();
        int[] input = new int[] {5, 10, 15};
        int value = 5;
        int result = find.indexOf(input, value);
        int expect = 0;
        assertThat(result, is(expect));
    }
    @Test
    public void whenSearch6Array51015NotFound() {
        FindLoop find = new FindLoop();
        int[] input = new int[] {5, 10, 15};
        int value = 6;
        int result = find.indexOf(input, value);
        int expect = -1;
        assertThat(result, is(expect));
    }
}
