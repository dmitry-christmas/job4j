package ru.job4j.bank;
/**
 * Класс аккаунта клиента банка.
 * @author Dmitry Rozhdestvenskiy (dmr1433@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class Account {
    private double value;
    private String requisites;
    public Account(double value, String requisites) {
        this.value = value;
        this.requisites = requisites;
    }
    public double getValue() {
        return value;
    }
    public String getRequisites() {
        return requisites;
    }

    /**
     * Метод перечисления денег со счёта на счёт.
     * @param dest счёт назначения.
     * @param sum сумма перевода.
     * @return true, если перевод успешен.
     */
    public boolean transfer(Account dest, double sum) {
        boolean result = false;
        if (this.value - sum >= 0) {
            this.value -= sum;
            dest.value += sum;
            result = true;
        }
        return result;
    }
}
