package ru.job4j.chess.figures.black;

import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.figures.Cell;
import ru.job4j.chess.figures.Figure;
import ru.job4j.chess.figures.FigureDiagonal;

/**
 * Класс логики шахматного слона.
 * @author Dmitry Rozhdestvenskiy (dmr1433@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class BishopBlack extends FigureDiagonal {
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
     * Метод перерисовки фигуры в случае успешного хода.
     * @param dest Клетка окончания движения.
     * @return Новый обхект фигуры.
     */
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }

}
