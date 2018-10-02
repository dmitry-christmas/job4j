package ru.job4j.tictactoe;

public class Logic3T {
    private final Figure3T[][] table;

    public Logic3T(Figure3T[][] table) {
        this.table = table;
    }

    public boolean isWinnerX() {
        boolean result;
        boolean resDiag = true;
        boolean resDiag1 = true;
        boolean resLine = false;
        for (int i = 0; i < this.table.length; i++) {
            if (!this.table[i][i].hasMarkX()) {
                resDiag = false;
            }
            if (!this.table[i][this.table.length - 1 - i].hasMarkX()) {
                resDiag1 = false;
            }
        }
        for (int i = 0; i < this.table.length; i++) {
            int x = 0;
            int y = 0;
            for (int j = 0; j < this.table.length; j++) {
                if (this.table[i][j].hasMarkX()) {
                    x++;
                }
                if (this.table[j][i].hasMarkX()) {
                    y++;
                }

                }
            if (x >= 3 || y >= 3) {
            resLine = true;
            break;
            }
        }

        if (resDiag || resDiag1 || resLine) {
            result = true;
        } else {
            result = false;
        }
        return result;
    }

    public boolean isWinnerO() {
        boolean result;
        boolean resDiag = true;
        boolean resDiag1 = true;
        boolean resLine = false;
        for (int i = 0; i < this.table.length; i++) {
            if (!this.table[i][i].hasMarkO()) {
                resDiag = false;
            }
            if (!this.table[i][this.table.length - 1 - i].hasMarkO()) {
                resDiag1 = false;
            }
        }
        for (int i = 0; i < this.table.length; i++) {
            int x = 0;
            int y = 0;
            for (int j = 0; j < this.table.length; j++) {
                if (this.table[i][j].hasMarkO()) {
                    x++;
                }
                if (this.table[j][i].hasMarkO()) {
                    y++;
                }

            }
            if (x >= 3 || y >= 3) {
                resLine = true;
                break;
            }
        }

        if (resDiag || resDiag1 || resLine) {
            result = true;
        } else {
            result = false;
        }
        return result;
    }

    public boolean hasGap() {
        boolean result = false;
        for (int i = 0; i < this.table.length; i++) {
            for (int j = 0; j < this.table.length; j++) {
                if (!this.table[i][j].hasMarkX() && !this.table[i][j].hasMarkO()) {
                    result = true;
                    break;
                }

            }
            if (result) {
                break;
            }
        }
        return result;
    }
}