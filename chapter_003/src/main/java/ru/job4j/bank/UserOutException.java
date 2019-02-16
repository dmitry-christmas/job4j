package ru.job4j.bank;
/**
 * Класс ошибки отсутствия пользователя.
 * @version $Id$
 * @since 0.1
 */
public class UserOutException extends RuntimeException {
    String msg;
    public UserOutException(String msg) {
        super(msg);
        this.msg = msg;
    }
}
