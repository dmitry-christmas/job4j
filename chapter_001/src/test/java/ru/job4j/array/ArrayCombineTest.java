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
    public void when1234345Then1234567() {
        ArrayCombine arrayCombine = new ArrayCombine();
        int[] array1 = {1, 2, 3, 4};
        int[] array2 = {3, 4, 5};
        int[] result = arrayCombine.combine2Arrays(array1, array2);
        int[] expect = {1, 2, 3, 3, 4, 4, 5};
        assertThat(result, is(expect));
    }
    @Test
    public void when1234AndEmptyThen1234() {
        ArrayCombine arrayCombine = new ArrayCombine();
        int[] array1 = {1, 2, 3, 4};
        int[] array2 = {};
        int[] result = arrayCombine.combine2Arrays(array1, array2);
        int[] expect = {1, 2, 3, 4};
        assertThat(result, is(expect));
    }
    @Test
    public void when12345And678910Then12345678910() {
        ArrayCombine arrayCombine = new ArrayCombine();
        int[] array1 = {1, 2, 3, 4, 5};
        int[] array2 = {6, 7, 8, 9, 10};
        int[] result = arrayCombine.combine2Arrays(array1, array2);
        int[] expect = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        assertThat(result, is(expect));
    }
    @Test
    public void when12And678910Then12678910() {
        ArrayCombine arrayCombine = new ArrayCombine();
        int[] array1 = {1, 2};
        int[] array2 = {6, 7, 8, 9, 10};
        int[] result = arrayCombine.combine2Arrays(array1, array2);
        int[] expect = {1, 2, 6, 7, 8, 9, 10};
        assertThat(result, is(expect));
    }
}
