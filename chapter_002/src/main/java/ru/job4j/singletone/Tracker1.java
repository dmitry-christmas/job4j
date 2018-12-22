package ru.job4j.singletone;

public enum Tracker1 {
    INSTANCE;
    int objectNumber;
    public void setObjectNumber(int x) {
        this.objectNumber = x;
    }
    public int getObjectNumber() {
        return objectNumber;
    }
}
