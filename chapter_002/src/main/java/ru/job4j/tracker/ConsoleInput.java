package ru.job4j.tracker;

import java.util.*;

public class ConsoleInput implements Input {

    private Scanner scanner = new Scanner(System.in);
    public String ask(String question) {
    System.out.print(question);
    return scanner.next();
    }
    public int ask(String question, int[] range) {
        int value = Integer.valueOf(this.ask(question));
        boolean exist = false;
        for (int i : range) {
            if (value == i) {
                exist = true;
            }
        }
        if (!exist) {
            throw new MenuOutException("Out of menu range.");
        }
        return value;
    }
}
