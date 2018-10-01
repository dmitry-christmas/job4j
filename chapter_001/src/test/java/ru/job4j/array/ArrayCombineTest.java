package ru.job4j.array;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * @author Dmitry Rozhdestvenskiy (mailto:dmr1433@gmail.com)
 *  @version $Id$
 *  @since 0.1
 */
public class ArrayCombineTest {
    @Test
    public void when1324675Then1234567() {
        ArrayCombine arrayCombine = new ArrayCombine();
        int[] array1 = {1, 2, 3, 4};
        int[] array2 = {3, 4, 5};
        int[] result = arrayCombine.combine2Arrays(array1, array2);
        int[] expect = {1, 2, 3, 3, 4, 4, 5};
        assertThat(result, is(expect));

    }
}
