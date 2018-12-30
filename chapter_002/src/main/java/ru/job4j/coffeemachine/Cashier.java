package ru.job4j.coffeemachine;
import ru.job4j.coffeemachine.coins.*;
import ru.job4j.coffeemachine.drinks.*;
import java.util.ArrayList;
import java.util.List;
import static java.lang.String.format;
/**
 * Симуляция кофейного аппарата. ПРинимает чешские кроны 50, 20, 10, 5, 2 и 1 крону.
 *  @author Dmitry Rozhdestvenskiy (mailto:dmr1433@gmail.com)
 *  @version $Id$
 *  @since 0.1
 */
public class Cashier {
    public HotDrink drink;
    private List<Coin> coins = new ArrayList<>();
    public boolean firstAdd() {
        boolean result = false;
        for (int i = 0; i < 100; i++) {
            if (i < 20) {
                coins.add(new Coin1());
            } else if (i < 40) {
                coins.add(new Coin2());
            } else if (i < 60) {
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
        } else {
            System.out.println("Ошибка добавления!");
        }
        return result;
    }
    public int cashRemain() {
        int result = 0;
        for (Coin coin : coins) {
            result = result + coin.getValue();
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
            System.out.println(format("Монета достоинством в %s Kč.", coins.get(index).getValue()));
            coins.remove(index);
            result = true;
        } else {
            System.out.println(format("Ошибка изъятия монеты в %s Kč", value));
        }
        return result;
    }
    /**
     * Метод ищет монету заданного достоинства, возвращает её индекс в списке.
     * @param value Достоинство монеты.
     * @return индекс в списке.
     */
    public int searchCoins(int value) {
        int result = -1;
        for (int i = 0; i < coins.size(); i++) {
            if (coins.get(i).getValue() == value) {
                result = i;
                break;
            }
        }
        return result;
    }
    /**
     * Метод расчёта выдачи сдачи.
     * @param money Количество внесённых денег.
     * @param price Цена покупаемого продукта.
     * @return Возвращает список монет к возврату.
     */
    public List<Coin> change(int money, int price) {
        List<Coin> coinsChange = new ArrayList<>();
        int[] coinsList = {50, 20, 10, 5, 2, 1};
        int change = money - price;
        for (int coin = 0; coin < coinsList.length; coin++) {
            if (searchCoins(coinsList[coin]) >= 0 && (change >= coinsList[coin])) {
                coinsChange.add(coins.get(searchCoins(coinsList[coin])));
                take(coinsList[coin]);
                change = change - coinsList[coin];
                if (change == 0) {
                    break;
                } else if (change >= coinsList[coin]) {
                    coin--;
                }
            }
        }
        if (change > 0) {
            System.out.println(format("Sorry jako, но сдачу в размере %s вернуть не получится, так как кончились деньги.", change));
        }
        return coinsChange;
    }

    /**
     * Основной метод покупки товара.
     * @param choice номер товара.
     * @param sugar количество сахара.
     * @param money массив с деньгами.
     */
    public void buy(int choice, int sugar, int[] money) {
        int sum = 0;
        if (choice == 1) {
            drink = new Espresso(sugar);
        } else {
            drink = new CafeLatte(sugar);
        }
        System.out.println(format("Выбран вариант %s: Напиток %s за %s Kč", choice, drink.getName(), drink.getPrice()));
        for (int coin: money) {
            if (coin == 1 || coin == 2 || coin == 5 || coin == 10 || coin == 20 || coin == 50) {
                sum = sum + coin;
            } else {
                System.out.println(format("Автомат не принимает монеты достоинством в %s Kč. Заберите монету обратно!", coin));
            }
            if (coin == 50) {
                add(new Coin50(), 1);
            }
            if (coin == 20) {
                add(new Coin20(), 1);
            }
            if (coin == 10) {
                add(new Coin10(), 1);
            }
            if (coin == 5) {
                add(new Coin5(), 1);
            }
            if (coin == 2) {
                add(new Coin2(), 1);
            }
            if (coin == 1) {
                add(new Coin1(), 1);
            }
        }
        System.out.println(format("Внесено: %s Kč.", sum));
        if (sum < drink.getPrice()) {
            System.out.println(format("Внесённой Вами суммы %s Kč недостаточно для покупки напитка за %s Kč", sum, drink.getPrice()));
        }
        if (sum > drink.getPrice()) {
            System.out.println(format("Ваша сдача: %s Kč.", sum - drink.getPrice()));
            change(sum, drink.getPrice());
            System.out.println("Возьмите напиток!");
        }
        if (sum == drink.getPrice()) {
            System.out.println("Спасибо за то, что без сдачи!");
            System.out.println("Возьмите напиток!");
        }
    }
    public static void main(String[] args) {
        Cashier cashier = new Cashier();
        cashier.firstAdd();
        cashier.cashRemain();
        cashier.buy(1, 3, new int[]{100, 10});
        cashier.cashRemain();
    }
}
