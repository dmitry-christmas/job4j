package ru.job4j.array;
/**
 * Проверяем массив на одинаковые диагонали.
 *  @author Dmitry Rozhdestvenskiy (mailto:dmr1433@gmail.com)
 *  @version $Id$
 *  @since 0.1
 */
public class MatrixCheck {
    /**
     * @param data проверяемый массив.
     * @return результат проверки
     */
    public boolean mono(boolean[][] data) {
        boolean result = true;
        boolean temp = data[0][0];
        if (data.length != data[0].length) {
            result = false;
        }

        for (int i = 0; i < data.length; i++) {
            if (!result) {
                break;
            }
            for (int j = 0; j < data.length; j++) {
                if ((i == j || i + j == data.length - 1) && data[i][j] != temp || !result) {
                    result = false;
                    break;
                }
            }
        }
        return result;
    }
}
