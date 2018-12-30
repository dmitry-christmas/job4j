package ru.job4j.coffeemachine.coins;

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
}
