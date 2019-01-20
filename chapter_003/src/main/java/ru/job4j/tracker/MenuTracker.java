package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

public class MenuTracker {
    private Input input;
    private Tracker tracker;
    private List<UserAction> actions = new ArrayList<>();

    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }
    public void fillActions(StartUI ui) {
        actions.add(new AddItem(0, "Добавить заявку."));
        actions.add(new ShowItems(1, "Показать все заявки."));
        actions.add(new EditItem(2, "Заменить заявку по id."));
        actions.add(new DeleteItem(3, "Удалить заявку."));
        actions.add(new FindItemById(4, "Поиск заявки по id."));
        actions.add(new FindItemByName(5, "Поиск заявки по имени."));
        actions.add(new Exit(6, "Выход из программы.", ui));
    }
    public void select(int key) {
        this.actions.get(key).execute(this.input, this.tracker);
    }
    public void show() {
        System.out.println("Меню.");
        for (UserAction action : actions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
    }
    private class AddItem extends BaseAction {
        public AddItem(int key, String name) {
            super(key, name);
        }
        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Добавление новой заявки --------------");
            String name = input.ask("Введите имя заявки : ");
            String desc = input.ask("Введите описание заявки : ");
            Long created = System.currentTimeMillis();
            String comments = "";
            Item item = new Item(name, desc, created, comments);
            tracker.add(item);
            System.out.println("Добавлена заявка: " + item);
        }
    }
    private class EditItem extends BaseAction {
        public EditItem(int key, String name) {
            super(key, name);
        }
        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Замена заявки --------------");
            String id = input.ask("Введите id заменяемой заявки : ");
            String name = input.ask("Введите имя новой заявки : ");
            String desc = input.ask("Введите описание новой заявки : ");
            Long created = System.currentTimeMillis();
            String comments = "";
            if (tracker.replace(id, new Item(name, desc, created, comments))) {
                    System.out.println("Заявка с id " + id + " заменена.");
                    System.out.println("------------ Новая заявка --------------");
                    System.out.println(tracker.findById(id));
                } else {
                    System.out.println("Заявка с id: " + id + " не найдена.");
                }
        }
    }
    private class ShowItems extends BaseAction {
        public ShowItems(int key, String name) {
            super(key, name);
        }
        @Override
        public void execute(Input input, Tracker tracker) {
            List<Item> result = tracker.getAll();
            if (result.size() > 0) {
                System.out.println("------------ Список имеющихся заявок --------------");
                for (Item item : result) {
                    System.out.println(item);
                }
            } else {
                System.out.println("Заявок нет.");
            }
        }
    }
    private class DeleteItem extends BaseAction {
        public DeleteItem(int key, String name) {
            super(key, name);
        }
        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Удаление заявки --------------");
            String id = input.ask("Введите id удаляемой заявки :");
            if (tracker.delete(id)) {
                System.out.println("Заявка с id " + id + " удалена.");
            } else {
                System.out.println("Заявка с id: " + id + " не найдена.");
            }
        }
    }
    private class FindItemById extends BaseAction {
        public FindItemById(int key, String name) {
            super(key, name);
        }
        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Поиск заявки --------------");
            String id = input.ask("Введите id искомой заявки. ");
            Item result = tracker.findById(id);
            if (result != null) {
                System.out.println("Искомая заявка найдена!");
                System.out.println(result);
            } else {
                System.out.println("Заявка с id: " + id + " не найдена.");
            }
        }
    }
    private class FindItemByName extends BaseAction {
        public FindItemByName(int key, String name) {
            super(key, name);
        }
        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Поиск заявки по имени --------------");
            String name = input.ask("Введите имя искомой заявки. ");
            List<Item> result = tracker.findByName(name);
            if (result.size() > 0) {
                System.out.println("По вашему запросу: " + name + " найдены следующие заявки:");
                for (Item item : result) {
                    System.out.println(item);
                }
            } else {
                System.out.println("По вашему запросу: " + name + " заявок не найдено.");
            }
        }
    }
    private class Exit extends BaseAction {
        private final StartUI ui;
        public Exit(int key, String name, StartUI ui) {
            super(key, name);
            this.ui = ui;
        }
        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Выход из программы --------------");
            this.ui.exit();
        }
    }
    public int getActionsLength() {
        return actions.size();
    }
}
