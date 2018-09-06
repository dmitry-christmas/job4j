package ru.job4j.loop;
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
        int w = 2 * h - 1;
        for (int row = 0; row != h; row++) {
            for (int column = 0; column != w; column++) {
                if (row >= h - column - 1 && row + h - 1 >= column) {
                    screen.append("^");
                } else {
                    screen.append(" ");
                }
            }
            screen.append(System.lineSeparator());
        }
        return screen.toString();
    }
    public String rightTrl(int h) {
        StringBuilder screen = new StringBuilder();
        String ln = System.lineSeparator();
        int w = h;
        for (int row = 0; row != h; row++) {
            for (int column = 0; column != w; column++) {
                if (row >= column) {
                    screen.append("^");
                } else {
                      screen.append(" ");
                }
            }
            screen.append(ln);
        }
        return screen.toString();
    }
    public String leftTrl(int h) {
        StringBuilder screen = new StringBuilder();
        String ln = System.lineSeparator();
        int w = h;
        for (int row = 0; row != h; row++) {
            for (int column = 0; column != w; column++) {
                if (row >= w - column - 1) {
                    screen.append("^");
                } else {
                    screen.append(" ");
                }
            }
            screen.append(ln);
        }
        return screen.toString();
    }
}
