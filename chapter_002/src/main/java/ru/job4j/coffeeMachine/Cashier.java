package ru.job4j.coffeeMachine;
import com.sun.xml.internal.ws.message.ByteArrayAttachment;
import ru.job4j.coffeeMachine.coins.*;
import ru.job4j.coffeeMachine.drinks.*;

import java.util.ArrayList;
import java.util.List;
import static java.lang.String.format;

public class Cashier {
    HotDrink drink;
    private List<Coin> coins = new ArrayList<>();
    public boolean firstAdd() {
        boolean result = false;
        for (int i = 0; i < 100; i++) {
            if (i < 15) {
                coins.add(new Coin1());
            } else if (i < 25) {
                coins.add(new Coin2());
            } else if (i < 50) {
                coins.add(new Coin5());
            } else if (i < 80) {
                coins.add(new Coin10());
            } else if (i < 99) {
                coins.add(new Coin20());
            } else {
                coins.add(new Coin50());
            }
        }
        if (coins.size() == 100) {
            result = true;
        } else {
            System.out.println("Ошибка!");
        }
        return result;
    }
    public boolean add(Coin coin, int quantity) {
        boolean result = false;
        int coinsQuantity = coins.size();
        for (int i = 0; i < quantity; i++) {
            coins.add(coin);
        }
        if (coins.size() == coinsQuantity + quantity) {
            result = true;
            System.out.println(format("В автомат добавлено %s монет достоинством по %s Kč", quantity, coin.getValue()));
            System.out.println(format("Теперь в автомате всего %s монет", coins.size()));
        } else {
            System.out.println("Ошибка добавления!");
        }
        return result;
    }
    public int cashRemain() {
        int result = 0;
        for (int i = 0; i < coins.size(); i++) {
            result = result + coins.get(i).getValue();
        }
        System.out.println(format("В автомате денег на %s Kč", result));
        return result;
    }
    public boolean take(int value) {
        boolean result = false;
        int index = -1;
        for (int i = 0; i < coins.size(); i++) {
            if (coins.get(i).getValue() == value) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            coins.remove(index);
        } else {
            System.out.println(format("Ошибка изъятия монеты в %s Kč", value));
        }
        return result;
    }
    public int calculateCoins(int value) {
        int result = 0;
        for (int i = 0; i < coins.size(); i++) {
            if (coins.get(i).getValue() == value) {
                result++;
            }
        }
        return result;
    }
    public List<Coin> change(int money, int price) {
        List<Coin> coinsChange = new ArrayList<>();

        return coinsChange;
    }
    public void buy(int choice, int sugar, int money) {
        if (choice == 1) {
            HotDrink drink = new Espresso(sugar);
        } else {
            HotDrink drink = new CafeLatte(sugar);
        }
        if (money != drink.getPrice()) {
            List<Coin> change = change(money, drink.getPrice());
            System.out.println(format("Ваша сдача: %s Kč", money - drink.getPrice()));
            for (Coin coin : change) {
                System.out.println(format("Монета достоинством в %s", coin.getValue()));
            }
            System.out.println("Возьмите напиток!");
        }
    }
    public static void main(String[] args) {
        Cashier cashier = new Cashier();
        cashier.firstAdd();
        cashier.add(new Coin10(), 1);
        cashier.cashRemain();
        cashier.take(50);
        cashier.cashRemain();
        cashier.buy(1, 3, 35);
    }
}
