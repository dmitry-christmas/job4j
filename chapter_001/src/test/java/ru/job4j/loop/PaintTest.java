package ru.job4j.loop;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import java.util.StringJoiner;
/**
 * @author Dmitry Rozhdestvenskiy (mailto:dmr1433@gmail.com)
 *  @version $Id$
 *  @since 0.1
 */

public class PaintTest {
    @Test
    public void whenPyramid4Right() {
        Paint paint = new Paint();
        String rsl = paint.rightTrl(4);
        assertThat(rsl,
                is(
                        new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                        .add("^   ")
                        .add("^^  ")
                        .add("^^^ ")
                        .add("^^^^")
                        .toString()
                )
        );
    }
    @Test
    public void whenPyramid4Left() {
        Paint paint = new Paint();
        String rsl = paint.leftTrl(4);
        assertThat(rsl,
                is(
                        new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                                .add("   ^")
                                .add("  ^^")
                                .add(" ^^^")
                                .add("^^^^")
                                .toString()
                )
        );
    }
    @Test
    public void whenPyramid4() {
        Paint paint = new Paint();
        String rsl = paint.piramid(4);
        assertThat(rsl,
                is(
                        new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                                .add("   ^   ")
                                .add("  ^^^  ")
                                .add(" ^^^^^ ")
                                .add("^^^^^^^")
                                .toString()
                )
        );
    }
    @Test
    public void whenPyramid10() {
        Paint paint = new Paint();
        String rsl = paint.piramid(10);
        assertThat(rsl,
                is(
                        new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                                .add("         ^         ")
                                .add("        ^^^        ")
                                .add("       ^^^^^       ")
                                .add("      ^^^^^^^      ")
                                .add("     ^^^^^^^^^     ")
                                .add("    ^^^^^^^^^^^    ")
                                .add("   ^^^^^^^^^^^^^   ")
                                .add("  ^^^^^^^^^^^^^^^  ")
                                .add(" ^^^^^^^^^^^^^^^^^ ")
                                .add("^^^^^^^^^^^^^^^^^^^")
                                .toString()
                )
        );
    }
}
