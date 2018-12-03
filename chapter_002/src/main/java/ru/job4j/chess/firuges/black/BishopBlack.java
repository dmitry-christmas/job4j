package ru.job4j.chess.firuges.black;

import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.Logic;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

/**
 *
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class BishopBlack extends Figure {
    private final Cell position;
    public BishopBlack(final Cell position) {
        this.position = position;
    }

    public Cell position() {
        return this.position;
    }

    public Cell[] way(Cell source, Cell dest) {
        int deltaX = dest.x - source.x;
        int deltaY = dest.y - source.y;
        short indexX = 1;
        short indexY = 1;
        if (deltaX < 0) {
            indexX = -1;
        }
        if (deltaY < 0) {
            indexY = -1;
        }
        if (!isDiagonal(deltaX, deltaY)) {
            throw new ImpossibleMoveException("Слон ходит по диагонали!");
        }
        Cell[] steps = new Cell[Math.abs(deltaX)];
        for (int i = 0; i < steps.length; i++) {
            steps[i] = Cell.values()[source.ordinal() + (i + 1) * indexY + (i + 1) * indexX * 8];
        }
        return steps;
    }

    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
    private boolean isDiagonal(int deltaX, int deltaY) {
        boolean result = false;
            if (Math.abs(deltaX) == Math.abs(deltaY)) {
                result = true;
            }
        return result;
    }
}
