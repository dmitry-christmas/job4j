package ru.job4j.chess;

import ru.job4j.chess.figures.Cell;
import ru.job4j.chess.figures.Figure;

/**
 * //TODO add comments.
 *
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class Logic {
    public final Figure[] figures = new Figure[32];
    private int index = 0;

    public void add(Figure figure) {
        this.figures[this.index++] = figure;
    }

    public void move(Cell source, Cell dest)  {
        boolean checkDest = true;
        int index = this.findBy(source);
        if (index == -1) {
            throw new FigureNotFoundException("Фигура не найдена!");
        }
        Cell[] steps = this.figures[index].way(source, dest);
        for (int i = 0; i < steps.length; i++) {
            for (int j = 0; j <= 31; j++) {
                if (this.figures[j].position().equals(steps[i])) {
                checkDest = false;
                break;
                }
            }
        }
        if (!checkDest) {
            throw new OccupiedWayException("Фигуры на пути!");
        }
        this.figures[index] = this.figures[index].copy(dest);
        int move = this.figures[index].getMove();
        this.figures[index].setMove(++move);
    }

    public void clean() {
        for (int position = 0; position != this.figures.length; position++) {
            this.figures[position] = null;
        }
        this.index = 0;
    }

    private int findBy(Cell cell) {
        int rst = -1;
        for (int index = 0; index != this.figures.length; index++) {
            if (this.figures[index] != null && this.figures[index].position().equals(cell)) {
                rst = index;
                break;
            }
        }
        return rst;
    }
}
