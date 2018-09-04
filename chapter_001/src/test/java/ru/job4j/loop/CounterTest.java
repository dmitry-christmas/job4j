package ru.job4j.loop;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * @author Dmitry Rozhdestvenskiy (mailto:dmr1433@gmail.com)
 *  @version $Id$
 *  @since 0.1
 */
public class CounterTest {
    @Test
    public void fromOneTillTenIsThirty() {
        Counter counter = new Counter();
        assertThat(
                counter.add(1, 10), is(30)
        );
    }
}
