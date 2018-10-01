package ru.job4j.array;
/**
 * Объединение 2 массивов в третий отсортированный массив.
 *  @author Dmitry Rozhdestvenskiy (mailto:dmr1433@gmail.com)
 *  @version $Id$
 *  @since 0.1
 */
public class ArrayCombine {
    /**
     * Создаёт отсортированный массив из 2 отсортированных массивов.
     * @param array1 первый вводный массив.
     * @param array2 первый вводный массив.
     * @return объединённый отсортированный массив
     */
    public int[] combine2Arrays(int[] array1, int[] array2) {
        int[] arrayResult = new int[array1.length + array2.length];
        int firstIndex = 0;
        int secondIndex = 0;
        for (int i = 0; i < arrayResult.length; i++) {
            if (firstIndex >= array1.length) {
                arrayResult[i] = array2[secondIndex];
                secondIndex++;
            } else if (secondIndex >= array2.length) {
                arrayResult[i] = array1[firstIndex];
                firstIndex++;
            } else if (array1[firstIndex] <= array2[secondIndex]) {
                arrayResult[i] = array1[firstIndex];
                firstIndex++;
            } else {
                arrayResult[i] = array2[secondIndex];
                secondIndex++;
            }
        }
        return arrayResult;
    }
}
