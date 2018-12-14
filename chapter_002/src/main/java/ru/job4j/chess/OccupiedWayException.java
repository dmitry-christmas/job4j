package ru.job4j.chess;

public class OccupiedWayException extends RuntimeException {
    String msg;
    public OccupiedWayException(String msg) {
        super(msg);
        this.msg = msg;
    }
}
