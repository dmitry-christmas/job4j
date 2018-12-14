package ru.job4j.chess.figures.black;

import com.sun.org.apache.xerces.internal.impl.xs.opti.DefaultElement;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.figures.Cell;
import ru.job4j.chess.figures.Figure;
import ru.job4j.chess.figures.FigureQueen;

/**
 *
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class QueenBlack extends FigureQueen {
    private final Cell position;
    public QueenBlack(final Cell position) {
        this.position = position;
    }
    @Override
    public Cell position() {
        return this.position;
    }
    @Override
    public Figure copy(Cell dest) {
        return new QueenBlack(dest);
    }

}
