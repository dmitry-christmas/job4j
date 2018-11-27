package ru.job4j.chess.firuges.black;

import ru.job4j.chess.Logic;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

/**
 *
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class BishopBlack implements Figure {
    private final Cell position;
    public BishopBlack(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) {
        Cell[] steps = new Cell[0];
        for (int i = 1; i <= 7; i++) {
            if (((source.y == dest.y + i && source.x == dest.x + i) ||
                    (source.y == dest.y - i && source.x == dest.x - i) ||
                    (source.y == dest.y + i && source.x == dest.x - i) ||
                    (source.y == dest.y - i && source.x == dest.x + i))
                        && bishopCheck(source, dest)) {
                steps = new Cell[]{dest};
                break;
            }
        }
        return steps;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
    private boolean bishopCheck(Cell source, Cell dest) {
        boolean checkDest = true;
        int x = dest.x - source.x;
        int y = dest.y - source.y;
        int xIndex;
        int yIndex;
        if (x > 0) {
            xIndex = 1;
        } else {
            xIndex = -1;
        }
        if (y > 0) {
            yIndex = 1;
        } else {
            yIndex = -1;
        }
        for (int i = 1; i <= Math.abs(x); i++) {
            for (int j = 0; j <= 31; j++) {
                if (Logic.figures[j].position().x == source.x + i * xIndex &&
                        Logic.figures[j].position().y == source.y + i * yIndex) {
                    checkDest = false;
                    break;
                }
                if (checkDest == false) {
                    break;
                }
            }
        }
        return checkDest;
    }
}
