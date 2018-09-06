package ru.job4j.loop;
/**
 * Вычисление факториала положительного числа.
 *
 * @author Dmitry Rozhdestvenskiy (mailto:dmr1433@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Factorial {
    /**
     * @param n число для расчёта факториала.
     * @return - факториал из заданного числа, -1 при отрицательном n.
     */
    public int calc(int n) {
        int res = 1;
        if (n > 0) {
            for (int i = 1; i <= n; i++) {
                res *= i;
            }

        }
        return res;
    }

}
