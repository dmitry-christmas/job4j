package ru.job4j.loop;
import java.util.function.BiPredicate;

/**
 * Построение пирамиды заданной высоты.
 *
 * @author Dmitry Rozhdestvenskiy (mailto:dmr1433@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Paint {
    /**
     * @param h высота пирамиды.
     * @return
     */
    public String piramid(int h) {
        StringBuilder screen = new StringBuilder();
                return this.loopBy(
                h,
                2 * h - 1,
                (row, column) -> row >= h - column - 1 && row + h - 1 >= column
        );
    }
    public String rightTrl(int h) {
        return this.loopBy(
                h,
                h,
                (row, column) -> row >= column
        );
    }
    public String leftTrl(int h) {
        return this.loopBy(
                h,
                h,
                (row, column) -> row >= h - column - 1
        );
    }
    private String loopBy(int h, int w, BiPredicate<Integer, Integer> predict) {
        StringBuilder screen = new StringBuilder();
        for (int row = 0; row != h; row++) {
            for (int column = 0; column != w; column++) {
                if (predict.test(row, column)) {
                    screen.append("^");
                } else {
                    screen.append(" ");
                }
            }
            screen.append(System.lineSeparator());
        }
        return screen.toString();
    }
}
