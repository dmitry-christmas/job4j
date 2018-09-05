package ru.job4j.loop;
/**
 * Вычисление чётных чисел из массива.
 *
 * @author Dmitry Rozhdestvenskiy (mailto:dmr1433@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Counter {
    /**
     * @param start первое число из последовательности для вычисления суммы чётных чисел.
     * @param finish последнее число из последовательности для вычисления суммы чётных чисел.
     * @return - сумма чётных чисел
     */
    public int add(int start, int finish) {
        int i;
        int result = 0;
        for (i = start; i <= finish; i++) {
            if (i % 2 == 0) {
                result += i;
            }
        }
        return result;
    }
}
