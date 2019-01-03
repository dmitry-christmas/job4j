package ru.job4j.coffeevending.coins;

public abstract class Coin {
    private final int value;
    private final int weight;
    Coin(int value, int weight) {
        this.value = value;
        this.weight = weight;
    }
    public int getValue() {
        return value;
    }
    public int getWeight() {
        return weight;
    }
    @Override
    public boolean equals(Object obj) {
        boolean result = false;
        if (value == ((Coin) obj).value) {
            result = true;
        }
        return result;
    }
}
