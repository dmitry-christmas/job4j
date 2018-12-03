package ru.job4j.chess;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.black.PawnBlack;

import java.util.Optional;

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

    public boolean move(Cell source, Cell dest)  {
        boolean rst = false;
        boolean checkDest = true;
        int index = this.findBy(source);
        if (index != -1) {
            Cell[] steps = this.figures[index].way(source, dest);
            for (int i = 0; i < steps.length; i++) {
                for (int j = 0; j <= 31; j++) {
                    if (this.figures[j].position().equals(steps[i])) {
                        checkDest = false;
                        break;
                    }
                }
            }
            if (steps.length > 0 && steps[steps.length - 1].equals(dest) && checkDest == true) {
                rst = true;
                this.figures[index] = this.figures[index].copy(dest);
                int move = this.figures[index].getMove();
                this.figures[index].setMove(++move);
            } else {
                throw new OccupiedWayException("Фигуры на пути!");
            }
        } else {
            throw new FigureNotFoundException("Фигура не найдена!");
        }
        return rst;
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
