package ru.job4j.condition;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Тест расстояния между точками
 * @author Dmitry Rozhdestvenskiy (mailto:dmr1433@gmail.com)
 *  @version $Id$
 *  @since 0.1
 */

public class PointTest {
    @Test
    public void whenOneOneTwoTwo() {
        Point a = new Point(1, 1);
        Point b = new Point(1,2);
        assertThat(
                a.distanceTo(b),
                is(1.0)
        );
    }
}
