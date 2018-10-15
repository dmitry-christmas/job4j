package ru.job4j.tracker;
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
     * Константа для поиска по ID.
     */
    private static final String FINDID = "4";
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
                case FINDID:
                    this.findItem();
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
        Long created = 123L;
        String comments = "";
        Item item = new Item(name, desc, created, comments);
        this.tracker.add(item);
        System.out.println("------------ Новая заявка с getId : " + item.getId() + "-----------");
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
            System.out.println("Имя заявки: " + result.getName() + ". Id заявки " + result.getId() + ". Описание заявки " + result.getDesc() + ".");
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
     * Запускт программы.
     *
     * @param args
     */
    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}
