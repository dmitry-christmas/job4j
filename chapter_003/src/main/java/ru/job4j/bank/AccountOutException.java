package ru.job4j.bank;
/**
 * Класс ошибки отсутвия аккаунта у клиента.
 * @author Dmitry Rozhdestvenskiy (dmr1433@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class AccountOutException extends Exception {
    String msg;
    public AccountOutException(String msg) {
        super(msg);
        this.msg = msg;
    }
}