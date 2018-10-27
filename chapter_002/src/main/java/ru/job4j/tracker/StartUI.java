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
            menu.fillActions(this);
                do {
                    menu.show();
                    String temp = input.ask("Выберите пункт меню: ");
                    Pattern p = Pattern.compile("[0-9]");
                    Matcher m = p.matcher(temp);
                    if (m.matches()) {
                        int key = Integer.valueOf(temp);
                        menu.select(key);

                    } else {
                        System.out.println("Пункт меню задан неправильно.");
                    }
                    if (this.functioning) {
                        if ("y".equals(this.input.ask("Exit? (y): "))) {
                            menu.select(6);
                        }
                    }
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
    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}
