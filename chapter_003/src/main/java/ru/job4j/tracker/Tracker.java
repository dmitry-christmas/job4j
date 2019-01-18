package ru.job4j.tracker;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Класс трекер обёртка над массивом заявок.
 *  @author Dmitry Rozhdestvenskiy (mailto:dmr1433@gmail.com)
 *  @version $Id$
 *  @since 0.1
 */
public class Tracker {
    private List<Item> items = new ArrayList<>();
    private static Random rn = new Random();
    /**
     * @param item создаваемая заявка.
     * @return создаваемая заявка.
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        items.add(item);
        return item;
    }
    /**
     * @param id Id заявки, подлежащей замене.
     * @param next новая заявка.
     */
    public boolean replace(String id, Item next) {
        boolean replace = false;
            next.setId(id);
            for (Item item : items) {
                if (item.getId().equals(id)) {
                    items.set(items.indexOf(item), next);
                    replace = true;
                    break;
                }
            }
        return replace;
    }
    /**
     * Метод удаления заявки.
     * @param id Id заявки, подлежащей удалению.
     */
    public boolean delete(String id) {
        boolean delete = false;
        int index = 0;
            for (Item item : items) {
                if (item.getId().equals(id)) {
                    items.remove(index);
                    delete = true;
                    break;
                }
                index++;
            }
        return delete;
    }
    /**
     * Метод поиска заявки по имени.
     * @return массив искомых заявок.
     */
    public List<Item> findByName(String name) {
        List <Item> result = new ArrayList<>();
        for (Item item : items) {
            if (item.getName().equals(name)) {
                result.add(item);
            }
        }
        return result;
    }
    /**
     * Метод поиска заявки по id.
     * @param id Id заявки.
     * @return искомая заявка.
    */
    public Item findById(String id) {
        Item result = null;
        for (Item item : items) {
            if (item.getId().equals(id)) {
                result = item;
                break;
            }
        }
        return result;
    }
    /**
     * Вывод массива с заявками.
     * @return массив с заявками.
     */
    public List<Item> getAll() {
        return items;
    }
    /**
     * метод для генерации уникального id.
     * @return уникальный id, состоящий из текущего времени в мс + случайного числа.
     */
    private String generateId() {
        return String.valueOf(System.currentTimeMillis() + rn.nextInt());
    }
}
