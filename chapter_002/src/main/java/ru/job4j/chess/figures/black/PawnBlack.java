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
public class PawnBlack extends Figure {
    private final Cell position;
    private int move;

    public PawnBlack(final Cell position, int move) {
        this.position = position;
        this.move = move;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) {
        Cell[] steps = new Cell[0];
        if (this.move == 0 && source.y == dest.y + 2 && source.x == dest.x) {
            steps = new Cell[] {dest};
        }
        if (source.y == dest.y + 1 && source.x == dest.x) {
            steps = new Cell[] {dest};
        }
        if ((this.move == 0 && source.y > dest.y + 2) || this.move != 0 && source.y > dest.y + 1) {
            throw new ImpossibleMoveException("Пешка ходит по одной клетке!");
        }
        if (source.x != dest.x) {
            throw new ImpossibleMoveException("Пешка не ходит по диагонали!");
        }
        return steps;
    }
    @Override
    public Figure copy(Cell dest) {
        return new PawnBlack(dest, move);
    }
    public int getMove() {
        return move;
    }
    public void setMove(int move) {
        this.move = move;
    }
}
