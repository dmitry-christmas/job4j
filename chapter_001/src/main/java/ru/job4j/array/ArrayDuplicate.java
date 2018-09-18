package ru.job4j.array;
import java.util.Arrays;
/**
 *  Проверяем массив на дубликаты.
 *  @author Dmitry Rozhdestvenskiy (mailto:dmr1433@gmail.com)
 *  @version $Id$
 *  @since 0.1
 */
public class ArrayDuplicate {
    /**
     * @param array проверяямый массив.
     * @return массив без дубликатов.
     */
    public String[] remove(String[] array) {
        int q = array.length; /*количество не дублированных значений*/
        for (int i = 0; i < q; i++) {
            for (int j = i + 1; j < q; j++) {
                if (array[j].equals(array[i])) {
                    array[j] = array[q - 1];
                    q--;
                    j--;
                }
            }
        }
        return Arrays.copyOf(array, q);
    }
}
