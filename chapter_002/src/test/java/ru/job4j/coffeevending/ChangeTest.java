package ru.job4j.coffeevending;
import org.junit.Test;
import ru.job4j.coffeevending.coins.*;

import java.util.Arrays;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class ChangeTest {
    @Test
    public void startCash790BuyEspresso16Cash806() {
        Cashier cashier = new Cashier();
        cashier.buy(1, 5, new int[] {20});
        assertThat(cashier.cashRemain(), is(1776));
    }
    @Test
    public void ifchange38Then2010521() {
        Cashier cashier = new Cashier();
        List<Coin> change = cashier.change(70, 32);
        /*
        StringBuilder result = new StringBuilder();
        for (Coin coin : change) {
            result.append(coin.getValue());
        }
        assertTrue("2010521".equals(result.toString()));
        */
        List<Coin> expect = Arrays.asList(new Coin20(),
                new Coin10(),
                new Coin5(),
                new Coin2(),
                new Coin1());
        assertThat(change, is(expect));
    }
}
