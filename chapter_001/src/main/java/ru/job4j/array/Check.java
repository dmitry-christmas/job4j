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
        boolean result = false;
        int t = 0;
        int f = 0;
        for (int i = 0; i < data.length; i++) {
            if (data[i]) {
                t++;
            } else {
                f++;
            }
        }
        if (t == 3 || f == 3) {
        result = true;
        }
        return result;
    }
}
