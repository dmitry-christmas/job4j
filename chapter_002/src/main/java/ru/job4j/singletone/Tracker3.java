package ru.job4j.singletone;

public class Tracker3 {
    private static final Tracker3 INSTANCE = new Tracker3();
    int objectNumber;
    private Tracker3() {
    }
    public static Tracker3 getInstance() {
        return INSTANCE;
    }
    public void setObjectNumber(int x) {
        this.objectNumber = x;
    }
    public int getObjectNumber() {
        return objectNumber;
    }
}
