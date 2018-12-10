package ru.job4j.chess;

public class ImpossibleMoveException extends RuntimeException {
    String msg;
    public ImpossibleMoveException(String msg) {
        super(msg);
        this.msg = msg;
    }
}
