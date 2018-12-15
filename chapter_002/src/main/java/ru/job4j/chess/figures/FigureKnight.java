package ru.job4j.chess.figures;

import ru.job4j.chess.ImpossibleMoveException;

public abstract class FigureKnight extends Figure{
    @Override
    public Cell[] way(Cell source, Cell dest) {
        int deltaX = Math.abs(dest.x - source.x);
        int deltaY = Math.abs(dest.y - source.y);
        if (!((deltaX == 2 && deltaY == 1) || (deltaY == 2 && deltaX == 1))) {
            throw new ImpossibleMoveException("Конь ходит буквой Г!");
        }
        return new Cell[] {dest};
    }
}
