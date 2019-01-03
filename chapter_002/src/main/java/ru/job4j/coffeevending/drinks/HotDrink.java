package ru.job4j.coffeevending.drinks;

public abstract class HotDrink {
    private final int price;
    private final int volume;
    private final boolean milk;
    private final int sugar;
    private final String name;
    HotDrink(String name, int price, int volume, boolean milk, int sugar) {
        this.price = price;
        this.volume = volume;
        this.milk = milk;
        this.sugar = sugar;
        this.name = name;
    }
    public int getPrice() {
        return price;
    }
    public int getVolume() {
        return volume;
    }
    public boolean isMilk() {
        return milk;
    }
    public int getSugar() {
        return sugar;
    }
    public String getName() {
        return name;
    }
}
