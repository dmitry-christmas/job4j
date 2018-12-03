package ru.job4j.chess.firuges.black;

import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

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
        if(this.move == 0 && source.y == dest.y + 2 && source.x == dest.x) {
            steps = new Cell[] { dest };
        }
        if (source.y == dest.y + 1 && source.x == dest.x) {
            steps = new Cell[] { dest };
        } else if (move != 0) {
            throw new ImpossibleMoveException("Пешка ходит по одной клетке!");
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
