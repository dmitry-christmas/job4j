package ru.job4j.tracker;

import java.text.DateFormat;

/**
 * @version $Id$
 * @since 0.1
 */
public class StartUI {
    /**
     * Константа меню для добавления новой заявки.
     */
    private static final String ADD = "0";
    /**
     * Константа для отображения всех заявок.
     */
    private static final String GETALL = "1";
    /**
     * Константа для замены заявки.
     */
    private static final String REPLACE = "2";
    /**
     * Константа для удаления заявки.
     */
    private static final String DELETE = "3";

    /**
     * Константа для поиска по ID.
     */
    private static final String FINDID = "4";
    /**
     * Константа для поиска заявки по имени.
     */
    private static final String FINDNAME = "5";
    /**
     * Константа для выхода из цикла.
     */
    private static final String EXIT = "6";
    /**
     * Получение данных от пользователя.
     */
    private final Input input;
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
        boolean exit = false;
        while (!exit) {
            this.showMenu();
            String answer = this.input.ask("Введите пункт меню : ");
            switch (answer) {
                case ADD:
                    this.createItem();
                    break;
                case GETALL:
                    this.getItems();
                    break;
                case REPLACE:
                    this.replace();
                    break;
                case DELETE:
                    this.delete();
                    break;
                case FINDID:
                    this.findItem();
                    break;
                case FINDNAME:
                    this.findName();
                    break;
                case EXIT:
                    exit = true;
                    break;
                default:
                    this.unknown();
                    break;
            }
        }
    }
    /**
     * Метод реализует добавление новой заявки в хранилище.
     */
    private void createItem() {
        System.out.println("------------ Добавление новой заявки --------------");
        String name = this.input.ask("Введите имя заявки :");
        String desc = this.input.ask("Введите описание заявки :");
        Long created = System.currentTimeMillis();
        String comments = "";
        Item item = new Item(name, desc, created, comments);
        this.tracker.add(item);
        System.out.println("------------ Новая заявка с getId : " + item.getId() + "-----------");
    }
    /**
     * Метод реализует отображение всех заявок.
     */
    private void getItems() {
        Item[] result = this.tracker.getAll();
        if (result.length > 0) {
            System.out.println("Список имеющихся заявок:");
            for (int i = 0; i != result.length; i++) {
                System.out.println(result[i]);
            }
        } else {
            System.out.println("Заявок не найдено");
        }
    }
    /**
     * Метод реализует замену заявки.
     */
    private void replace() {
        System.out.println("------------ Замена заявки --------------");
        String id = this.input.ask("Введите id заменяемой заявки :");
        String name = this.input.ask("Введите имя новой заявки :");
        String desc = this.input.ask("Введите описание новой заявки :");
        Long created = System.currentTimeMillis();
        String comments = "";
        Item item = new Item(name, desc, created, comments);
        if (this.tracker.replace(id, item)) {
            System.out.println("Заявка с id " + id + " заменена.");
            System.out.println("------------ Новая заявка --------------");
            System.out.println(item);
        } else {
            System.out.println("Заявка с id: " + id + " не найдена.");
        }
    }
    /**
     * Метод реализует удаление заявки.
     */
    private void delete() {
        System.out.println("------------ Удаление заявки --------------");
        String id = this.input.ask("Введите id удаляемой заявки :");
        if (this.tracker.delete(id)) {
            System.out.println("Заявка с id " + id + " удалена.");
        } else {
            System.out.println("Заявка с id: " + id + " не найдена.");
        }

    }
    /**
     * Метод реализует поиск заявок по имени.
     */
    private void findName() {
        System.out.println("------------ Поиск заявки по имени --------------");
        String name = this.input.ask("Введите имя искомой заявки :");
        Item[] result = this.tracker.findByName(name);
        if (result.length > 0) {
            System.out.println("По вашему запросу: " + name + " найдены следующие заявки:");
            for (Item item : result) {
                System.out.println(item);
            }
        } else {
            System.out.println("По вашему запросу: " + name + " заявок не найдено.");
        }
    }
    /**
     * Метод реализует демонстрацию меню.
     */
    private void showMenu() {
        System.out.println("Меню.");
        System.out.println("0. Add new Item.");
        System.out.println("1. Show all items.");
        System.out.println("2. Edit item.");
        System.out.println("3. Delete item.");
        System.out.println("4. Find item by Id.");
        System.out.println("5. Find items by name.");
        System.out.println("6. Exit Program.");
    }
    /**
     * Метод реализует поиск заявки по id.
     */
    private void findItem() {
        String id = this.input.ask("Введите id искомой заявки");
        Item result = this.tracker.findById(id);
        if (result != null) {
            System.out.println("Искомая заявка найдена!");
            System.out.println(result);
        } else {
            System.out.println("Заявка с Id " + id + " не найдена.");
        }
    }
    /**
     * Метод ошибки ввода.
     */
    private void unknown() {
        System.out.println("Неверное значение меню. Введите ещё раз.");
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
