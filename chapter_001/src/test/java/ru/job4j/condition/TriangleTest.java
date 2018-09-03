package ru.job4j.condition;

import org.junit.Test;
import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.*;
/**
 * Тест площади тругольника.
 * @author Dmitry Rozhdestvenskiy (mailto:dmr1433@gmail.com)
 *  @version $Id$
 *  @since 0.1
 */
public class TriangleTest {
    @Test
    public void triangleArea() {
        Point a = new Point(0, 5);
        Point b = new Point(1, 5);
        Point c = new Point(2, 1);
        Triangle triangle = new Triangle(a, b, c);
        double result = triangle.area();
        double expected = 2.0;
        assertThat(result, closeTo(expected, 0.1));
    }
    @Test
    public void triangleExist() {
        Triangle t = new Triangle();
        boolean result = t.exist(6.0,4.0, 1.0);
        assertFalse(result);
    }
}
