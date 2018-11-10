package ru.job4j.tracker;
import java.text.DateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * @version $Id$
 * @since 0.1
 */
public class StartUI {
    private final Input input;
    private boolean functioning = true;
    /**
     * Хранилище заявок.
     */
    private final Tracker tracker;
    /**
     * Конструктор, инициализирующий поля.
     *
     * @param input   ввод данных.
     * @param tracker хранилище заявок.
     */

    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }
    /**
     * Основной цикл программы.
     */
    public void init() {
        MenuTracker menu = new MenuTracker(this.input, this.tracker);
        int[] range = new int[menu.getActionsLength()];
        for (int i = 0; i < range.length; i++) {
            range[i] = i;
        }
            menu.fillActions(this);
                do {
                    menu.show();
                    menu.select(input.ask("Выберите пункт меню: ", range));
                    /*if (this.functioning) {
                        if ("y".equals(this.input.ask("Exit? (y): "))) {
                            menu.select(6);
                        }
                    }*/
                } while (this.functioning);
    }
    public void exit() {
        this.functioning = false;
    }
    /**
     * Запуск программы.
     *
     * @param args
     */
    /*public static void main(String[] args) {
        new StartUI(new ValidateInput(), new Tracker()).init();
    }*/
}
