package ru.job4j.chess.figures;

import ru.job4j.chess.ImpossibleMoveException;

public abstract class FigureKing extends Figure {

    @Override
    public Cell[] way(Cell source, Cell dest) {
        int deltaX = dest.x - source.x;
        int deltaY = dest.y - source.y;
        if (Math.abs(deltaX) > 1 ||  Math.abs(deltaY) > 1) {
            throw new ImpossibleMoveException("Король ходит по одной клетке!");
        }
        Cell[] steps = new Cell[] {dest};
        return steps;
    }
}
