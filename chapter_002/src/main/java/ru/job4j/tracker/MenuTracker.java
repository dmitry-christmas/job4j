package ru.job4j.tracker;

import javax.jws.soap.SOAPBinding;
import javax.sound.midi.Track;
import java.awt.*;

public class MenuTracker {
    private Input input;
    private Tracker tracker;
    private UserAction[] actions = new UserAction[7];

    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }
    public void fillActions(StartUI ui) {
        this.actions[0] = new AddItem();
        this.actions[1] = new MenuTracker.ShowItems();
        this.actions[2] = new EditItem();
        this.actions[3] = new DeleteItem();
        this.actions[4] = new FindItemById();
        this.actions[5] = new FindItemByName();
        this.actions[6] = new Exit(ui);
    }
    public void select(int key) {
        this.actions[key].execute(this.input, this.tracker);
    }
    public void show() {
        System.out.println("Меню.");
        for (int index = 0; index < actions.length; index++) {
            if (actions[index] != null) {
                System.out.println(actions[index].info());
            }
        }
    }
    private class AddItem implements UserAction {
        @Override
        public int key() {
            return 0;
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
        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Добавить новую заявку.");
        }
    }
    private class EditItem implements UserAction {
        @Override
        public int key() {
            return 2;
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

        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Редактировать заявку.");
        }
    }
    private static class ShowItems implements UserAction {
        @Override
        public int key() {
            return 1;
        }
        @Override
        public void execute(Input input, Tracker tracker) {
            Item[] result = tracker.getAll();
            if (result.length > 0) {
                System.out.println("------------ Список имеющихся заявок --------------");
                for (Item item : result) {
                    System.out.println(item);
                }
            } else {
                System.out.println("Заявок нет.");
            }
        }
        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Показать все заявки.");
        }
    }

    private class DeleteItem implements UserAction {
        @Override
        public int key() {
            return 3;
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

        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Удалить заявку.");
        }
    }
    private class FindItemById implements UserAction {
        @Override
        public int key() {
            return 4;
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
        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Поиск заявки по id.");
        }
    }

    private class FindItemByName implements UserAction {
        @Override
        public int key() {
            return 5;
        }
        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Поиск заявки по имени --------------");
            String name = input.ask("Введите имя искомой заявки. ");
            Item[] result = tracker.findByName(name);
            if (result.length > 0) {
                System.out.println("По вашему запросу: " + name + " найдены следующие заявки:");
                for (Item item : result) {
                    System.out.println(item);
                }
            } else {
                System.out.println("По вашему запросу: " + name + " заявок не найдено.");
            }
        }
        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Поиск заявки по имени.");
        }
    }
    private class Exit implements UserAction {
        private final StartUI ui;
        Exit(StartUI ui) {
            this.ui = ui;
        }
        @Override
        public int key() {
            return 6;
        }
        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Выход из программы --------------");
            this.ui.exit();
        }
        public String info() {
            return String.format("%s. %s", this.key(), "Выход из программы.");
        }
    }
    public int getActionsLength() {
        return actions.length;
    }
}
