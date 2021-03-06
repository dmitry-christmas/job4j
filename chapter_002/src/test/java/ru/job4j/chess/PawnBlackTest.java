package ru.job4j.chess;

import org.junit.Before;
import org.junit.Test;
import ru.job4j.chess.figures.Cell;
import ru.job4j.chess.figures.black.*;
import ru.job4j.chess.figures.white.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PawnBlackTest {
    @Before
    public void buildDesk() {
        logic.figures[0] = new PawnBlack(Cell.A7);
        logic.figures[1] = new PawnBlack(Cell.B7);
        logic.figures[2] = new PawnBlack(Cell.C7);
        logic.figures[3] = new PawnBlack(Cell.B7);
        logic.figures[4] = new PawnBlack(Cell.D7);
        logic.figures[5] = new PawnBlack(Cell.E7);
        logic.figures[6] = new PawnBlack(Cell.F7);
        logic.figures[7] = new PawnBlack(Cell.G7);
        logic.figures[8] = new RookBlack(Cell.A8);
        logic.figures[9] = new KnightBlack(Cell.B8);
        logic.figures[10] = new BishopBlack(Cell.C8);
        logic.figures[11] = new QueenBlack(Cell.D8);
        logic.figures[12] = new KingBlack(Cell.E8);
        logic.figures[13] = new BishopBlack(Cell.F8);
        logic.figures[14] = new KnightBlack(Cell.G8);
        logic.figures[15] = new RookBlack(Cell.H8);
        logic.figures[16] = new PawnWhite(Cell.A2);
        logic.figures[17] = new PawnWhite(Cell.B2);
        logic.figures[18] = new PawnWhite(Cell.C2);
        logic.figures[19] = new PawnWhite(Cell.D2);
        logic.figures[20] = new PawnWhite(Cell.E2);
        logic.figures[21] = new PawnWhite(Cell.F2);
        logic.figures[22] = new PawnWhite(Cell.G2);
        logic.figures[23] = new PawnWhite(Cell.H2);
        logic.figures[24] = new RookWhite(Cell.A1);
        logic.figures[25] = new KnightWhite(Cell.B1);
        logic.figures[26] = new BishopWhite(Cell.C1);
        logic.figures[27] = new QueenWhite(Cell.D1);
        logic.figures[28] = new KingWhite(Cell.E1);
        logic.figures[29] = new BishopWhite(Cell.F1);
        logic.figures[30] = new KnightWhite(Cell.G1);
        logic.figures[31] = new RookWhite(Cell.H1);
    }
    Logic logic = new Logic();
    @Test
    public void whenRightMoveThenDest() {
        logic.move(Cell.A7, Cell.A5);
        assertThat(logic.figures[0].position(), is(Cell.A5));
    }
    @Test(expected = ImpossibleMoveException.class)
    public void whenWrongMoveThenImpossibleMoveException() {
        logic.move(Cell.A7, Cell.B6);
    }
    @Test(expected = OccupiedWayException.class)
    public void whenOccupiedWayThenOccupiedWayException() {
        logic.move(Cell.C7, Cell.C5);
        logic.move(Cell.D8, Cell.A5);
        logic.move(Cell.A7, Cell.A5);
    }
}
