package ru.job4j.chess.figures;

import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.figures.black.PawnBlack;

public abstract class FigurePawn extends Figure {
    public final Cell position;
    public int color;
    public FigurePawn(Cell position, int color) {
        this.position = position;
        this.color = color;
    }
    @Override
    public Cell[] way(Cell source, Cell dest) {
        if ((this.color == 0 && source.y < dest.y) || (this.color == 1 && source.y > dest.y))  {
            throw new ImpossibleMoveException("Пешка так не ходит!");
        }
        if (this.color == 0) {
            if (this.getMove() == 0 && source.y > dest.y + 2) {
                throw new ImpossibleMoveException("Пешка ходит одну или две клетки!");
            }
            if (this.getMove() != 0 && source.y > dest.y + 1) {
                throw new ImpossibleMoveException("Пешка ходит по одной клетке!");
            }
        } else {
            if (this.getMove() == 0 && source.y < dest.y - 2) {
                throw new ImpossibleMoveException("Пешка ходит одну или две клетки!");
            }
            if (this.getMove() != 0 && source.y < dest.y - 1) {
                throw new ImpossibleMoveException("Пешка ходит по одной клетке!");
            }
        }

        if (source.x != dest.x) {
            throw new ImpossibleMoveException("Пешка так не ходит!");
        }
        return new Cell[] {dest};
    }

}
