package ru.job4j.singletone;

public class Tracker4 {
    int objectNumber;
    private Tracker4() {
    }
    public static Tracker4 getInstance() {
        return Holder.INSTANCE;
    }
    public void setObjectNumber(int x) {
        this.objectNumber = x;
    }
    public int getObjectNumber() {
        return objectNumber;
    }
    private static final class Holder {
        private static final Tracker4 INSTANCE = new Tracker4();
    }
}
