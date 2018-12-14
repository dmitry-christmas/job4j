package ru.job4j.chess.figures;
import ru.job4j.chess.ImpossibleMoveException;
public abstract class FigureDiagonal extends Figure{
    /**
     * Метод выдачи массива клеток, через которые проходит фигура.
     * @param source клетка начала движения.
     * @param dest клетка конца движения.
     * @return Массив клеток.
     */
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
        Cell[] steps = new Cell[Math.abs(dest.x - source.x)];
        for (int i = 0; i < steps.length; i++) {
            steps[i] = Cell.values()[source.ordinal() + (i + 1) * indexY + (i + 1) * indexX * 8];
        }
        return steps;
    }
}
