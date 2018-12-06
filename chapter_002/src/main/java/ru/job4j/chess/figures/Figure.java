package ru.job4j.chess.figures;

public abstract class Figure {
    public abstract Cell position();
    int move;

    public abstract Cell[] way(Cell source, Cell dest);

    public String icon() {
        return String.format(
                "%s.png", this.getClass().getSimpleName()
        );

    }
    public abstract Figure copy(Cell dest);

    public int getMove() {
        return move;
    }
    public void setMove(int move) {
        this.move = move;
    }
}
