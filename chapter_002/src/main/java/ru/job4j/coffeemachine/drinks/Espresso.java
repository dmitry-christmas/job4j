package ru.job4j.coffeemachine.drinks;

public class Espresso extends HotDrink {
    public Espresso(int sugar) {
        super("Кофе эспрессо", 16, 25, false, sugar);
    }
}
