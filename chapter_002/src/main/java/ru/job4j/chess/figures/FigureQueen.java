package ru.job4j.chess.figures;

import ru.job4j.chess.ImpossibleMoveException;

public abstract class FigureQueen extends Figure {
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
        if (diagonal) {
            for (int i = 0; i < steps.length; i++) {
                steps[i] = Cell.values()[source.ordinal() + (i + 1) * indexY + (i + 1) * indexX * 8];
            }
        }
        if (horisontal) {
            if (deltaX != 0 && deltaY == 0) {
                int index;
                if (deltaX > 0) {
                    index = 1;
                } else {
                    index = -1;
                }
                for (int i = 0; i < steps.length; i++) {
                    steps[i] = Cell.values()[source.ordinal() + (i + 1) * index * 8];
                }
            } else {
                int index;
                if (deltaY > 0) {
                    index = 1;
                } else {
                    index = -1;
                }
                for (int i = 0; i < steps.length; i++) {
                    steps[i] = Cell.values()[source.ordinal() + (i + 1) * index];
                }
            }
        }
        if (!diagonal && !horisontal) {
            throw new ImpossibleMoveException("Ферзь так не ходит");
        }
        return steps;
    }
}
