package ru.job4j.tracker;
/**
 * Класс собственной ошибки.
 * @version $Id$
 * @since 0.1
 */
public class MenuOutException extends RuntimeException {
    public MenuOutException(String msg) {
        super(msg);
    }
}
