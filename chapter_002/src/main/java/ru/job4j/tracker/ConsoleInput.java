package ru.job4j.tracker;

import java.util.*;

public class ConsoleInput implements Input {

    private Scanner scanner = new Scanner(System.in);
    public String ask(String question) {
    System.out.print(question);
    return scanner.next();
    }
    public int ask(String question, int[] range) {
        return Integer.valueOf(this.ask(question));
    }
}
