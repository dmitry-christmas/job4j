package ru.job4j.chess.figures.black;

import com.sun.org.apache.xerces.internal.impl.xs.opti.DefaultElement;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.figures.Cell;
import ru.job4j.chess.figures.Figure;

/**
 *
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class QueenBlack extends Figure {

    private final Cell position;

    public QueenBlack(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) {
        int deltaX = dest.x - source.x;
        int deltaY = dest.y - source.y;
        short indexX = 1;
        short indexY = 1;
        int delta = Math.max(Math.abs(deltaX), Math.abs(deltaY));
        Cell[] steps = new Cell[delta];
        if (deltaX < 0) {
            indexX = -1;
        }
        if (deltaY < 0) {
            indexY = -1;
        }
        boolean diagonal = isDiagonal(deltaX, deltaY);
        boolean horisontal = isHorizontalVertical(deltaX, deltaY);
        if (!diagonal && !horisontal) {
            throw new ImpossibleMoveException("Ферзь так не ходит");
        }
        if (diagonal) {
            for (int i = 0; i < steps.length; i++) {
                steps[i] = Cell.values()[source.ordinal() + (i + 1) * indexY + (i + 1) * indexX * 8];
            }
        } else {
            if (deltaX != 0 && deltaY == 0) {
                int index;
                if (deltaX > 0) {
                    index = 1;
                } else {
                    index = -1;
                }
                for (int i = 0; i < steps.length; i++) {
                    steps[i] = Cell.values()[source.ordinal() + (i + 1)* index * 8];
                }
            } else {
                int index;
                if (deltaY > 0) {
                    index = 1;
                } else {
                    index = -1;
                }
                    for (int i = 0; i < steps.length; i++) {
                        steps[i] = Cell.values()[source.ordinal() + (i + 1)* index];
                    }
                }
        }
        return steps;
    }

    @Override
    public Figure copy(Cell dest) {
        return new QueenBlack(dest);
    }

    private boolean isDiagonal(int deltaX, int deltaY) {
        boolean result = false;
        if (Math.abs(deltaX) == Math.abs(deltaY)) {
            result = true;
        }
        return result;
    }
    private boolean isHorizontalVertical(int deltaX, int deltaY){
        boolean result = false;
        if ((deltaX != 0 && deltaY == 0) || (deltaY != 0 && deltaX == 0)) {
            result = true;
        }
        return result;
    }

}
