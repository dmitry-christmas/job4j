package ru.job4j.singletone;

public class Tracker2 {
    private static Tracker2 instance;
    private int objectNumber;
    private Tracker2() {
    }
    public static Tracker2 getInstance() {
        if (instance == null) {
            instance = new Tracker2();
        }
        return instance;
    }
    public void setObjectNumber(int x) {
        this.objectNumber = x;
    }
    public int getObjectNumber() {
        return objectNumber;
    }
}
