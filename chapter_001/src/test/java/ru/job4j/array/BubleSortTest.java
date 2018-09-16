package ru.job4j.array;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * @author Dmitry Rozhdestvenskiy (mailto:dmr1433@gmail.com)
 *  @version $Id$
 *  @since 0.1
 */
public class BubleSortTest {
    @Test
    public void whenSortArrayWithTenElementsThenSortedArray() {
        BubleSort bubleSort = new BubleSort();
        int[] array = {1, 5, 4, 2, 3, 1, 7, 8, 0, 5};
        int[] result = bubleSort.sort(array);
        boolean res = true;
        for (int i = 1; i < result.length; i++) {
            if (result[i] < result[i - 1]) {
                res = false;
                break;
            }
        }
        assertThat(res, is(true));
    }
}
