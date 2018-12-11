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
    /**
     * Проверка, идёт ли фигура по диагонали.
     * @param deltaX
     * @param deltaY
     * @return true - идёт по диагонали.
     */
    protected boolean isDiagonal(int deltaX, int deltaY) {
        boolean result = false;
        if (Math.abs(deltaX) == Math.abs(deltaY)) {
            result = true;
        }
        return result;
    }
    /**
     * Проверка, идёт ли фигура по горизонтали.
     * @param deltaX
     * @param deltaY
     * @return true - идёт по горизонтали.
     */
    protected boolean isHorizontalVertical(int deltaX, int deltaY) {
        boolean result = false;
        if ((deltaX != 0 && deltaY == 0) || (deltaY != 0 && deltaX == 0)) {
            result = true;
        }
        return result;
    }
}
