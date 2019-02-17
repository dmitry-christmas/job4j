package ru.job4j.bank;
/**
 * Класс ошибки недостатка денег на счёте.
 * @version $Id$
 * @since 0.1
 */
public class MoneyOutException extends RuntimeException {
    String msg;
    public MoneyOutException(String msg) {
        super(msg);
        this.msg = msg;
    }
}