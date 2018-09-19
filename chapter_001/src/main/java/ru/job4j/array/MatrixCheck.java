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
        if (data.length != data[0].length) {
            result = false;
        }
        boolean temp = data[0][0];
        boolean temp1 = data[0][data.length - 1];
        for (int i = 1; i < data.length; i++) {
            if (!result) {
                break;
            }
            if (data[i][i] != temp || data[i][data.length - 1 - i] != temp1) {
                result = false;
                break;
            }
        }
        return result;
    }
}
