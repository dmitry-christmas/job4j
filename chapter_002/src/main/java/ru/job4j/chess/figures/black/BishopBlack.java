package ru.job4j.chess.figures.black;

import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.figures.Cell;
import ru.job4j.chess.figures.Figure;

/**
 * Класс логики шахматного слона.
 * @author Dmitry Rozhdestvenskiy (dmr1433@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class BishopBlack extends Figure {
    private final Cell position;
    public BishopBlack(final Cell position) {
        this.position = position;
    }

    /**
     * Метод выдаёт координаты клетки.
     * @return
     */
    public Cell position() {
        return this.position;
    }
    /**
     * Метод с выдачей массива клеток, через которые проходит фигура.
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

    /**
     * Метод перерисовки фигуры в случае успешного хода.
     * @param dest Клетка окончания движения.
     * @return Новый обхект фигуры.
     */
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }

    /**
     * Метод проверки по диагонали ли идёт слон
     * @param deltaX Разница по x.
     * @param deltaY Разница по Y.
     * @return true - по диагонали.
     */
    private boolean isDiagonal(int deltaX, int deltaY) {
        boolean result = false;
            if (Math.abs(deltaX) == Math.abs(deltaY)) {
                result = true;
            }
        return result;
    }
}
