package ru.job4j.coffeeMachine.drinks;

public abstract class HotDrink {
    private final int price;
    private final int value;
    private final boolean milk;
    private final int sugar;
    HotDrink(int price, int value, boolean milk, int sugar) {
        this.price = price;
        this.value = value;
        this.milk = milk;
        this.sugar = sugar;
    }
    public int getPrice() {
        return price;
    }
    public int getValue() {
        return value;
    }
    public boolean isMilk() {
        return milk;
    }
    public int getSugar() {
        return sugar;
    }
}
