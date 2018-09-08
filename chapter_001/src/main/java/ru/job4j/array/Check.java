package ru.job4j.array;
/**
 * Проверка boolean массива.
 *
 * @author Dmitry Rozhdestvenskiy (mailto:dmr1433@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Check {
    /**
     * @param data массив, который следует проверить.
     * @return результат проверки, если все значения массива одинаковые.
     */
    public boolean mono(boolean[] data) {
        boolean result = true;
        for (int i = 1; i < data.length; i++) {
            if (data[i] != data[0]) {
                result = false;
                break;
            }
        }
        return result;
    }
}
