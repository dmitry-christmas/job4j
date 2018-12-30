package ru.job4j.coffeemachine;
import org.junit.Test;
import ru.job4j.coffeemachine.coins.Coin;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ChangeTest {
    @Test
    public void startCash790BuyEspresso16Cash806() {
        Cashier cashier = new Cashier();
        cashier.firstAdd();
        cashier.buy(1, 5, new int[] {20});
        assertThat(cashier.cashRemain(), is(806));
    }
    @Test
    public void ifchange38Then2010521() {
        Cashier cashier = new Cashier();
        cashier.firstAdd();
        List<Coin> change = cashier.change(70, 32);
        assertThat(change.size(), is(5));
    }
}
