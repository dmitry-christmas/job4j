package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MatrixCheckTest {
    @Test
    public void whenDataMonoByTrueThenTrue() {
        MatrixCheck matrixCheck = new MatrixCheck();
        boolean[][] input = new boolean[][] {
                {true, false, true},
                {false, true, false},
                {true, false, true}
        };
        boolean result = matrixCheck.mono(input);
        assertThat(result, is(true));
    }
    @Test
    public void whenDataNotMonoByTrueThenFalse() {
        MatrixCheck matrixCheck = new MatrixCheck();
        boolean[][] input = new boolean[][]{
                {true, false, false, true},
                {false, true, false, false},
                {true, true, true, true},
                {true, false, false, true}
        };
        boolean result = matrixCheck.mono(input);
        assertThat(result, is(false));
    }
}
