package ru.job4j.chess.figures.black;

import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.figures.Cell;
import ru.job4j.chess.figures.Figure;

/**
 *
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class RookBlack extends Figure {
    private final Cell position;

    public RookBlack(final Cell position) {
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
        int delta = 0;
        int index;
        if (Math.abs(deltaX) > Math.abs(deltaY)) {
            delta = Math.abs(deltaX);
        } else {
            delta = Math.abs(deltaY);
        }
        Cell[] steps = new Cell[delta];
        if (deltaX != 0 && deltaY == 0) {
                if (deltaX > 0) {
                    index = 1;
                } else {
                    index = -1;
                }
                for (int i = 0; i < steps.length; i++) {
                    steps[i] = Cell.values()[source.ordinal() + (i + 1) * index * 8];
                }
        }
        if (deltaX == 0 && deltaY != 0) {
                if (deltaY > 0) {
                    index = 1;
                } else {
                    index = -1;
                }
                for (int i = 0; i < steps.length; i++) {
                    steps[i] = Cell.values()[source.ordinal() + (i + 1) * index];
                }
        }
        if (!isHorizontalVertical(deltaX, deltaY)) {
            throw new ImpossibleMoveException("Ладья перемещается или по горизонтали, или по вертикали");
        }
        return steps;
    }
    @Override
    public Figure copy(Cell dest) {
        return new RookBlack(dest);
    }
}
