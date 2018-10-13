package ru.job4j.tracker;
import java.util.Arrays;
import java.util.Random;
/**
 * Класс трекер обёртка над массивом заявок.
 *  @author Dmitry Rozhdestvenskiy (mailto:dmr1433@gmail.com)
 *  @version $Id$
 *  @since 0.1
 */
public class Tracker {
    private Item[] items = new Item[100];
    private int position = 0;
    private static Random rn = new Random();
    /**
     * @param item создаваемая заявка.
     * @return создаваемая заявка.
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        this.items[this.position++] = item;
        return item;
    }
    /**
     * @param id Id заявки, подлежащей замене.
     * @param next новая заявка.
     */
    public void replace(String id, Item next) {
        next.setId(id);
        for (int index = 0; index < position; index++) {
            if (items[index] != null && items[index].getId().equals(id)) {
                items[index] = next;
                break;
            }
        }
    }
    /**
     * Метод удаления заявки.
     * @param id Id заявки, подлежащей удалению.
     */
    public void delete(String id) {
        for (int index = 0; index < position; index++) {
            if (items[index].getId().equals(id)) {
                System.arraycopy(items, index + 1, items, index, items.length - index - 1);
                position--;
                break;
            }
        }
    }
    /**
     * Метод возвращает массив заполненных заявок без нулевых элементов.
     * @return массив заполненных заявок без нулевых элементов.
     */
    public Item[] findAll() {
        int quantity = 0;
        for (Item item : items) {
            if (item != null) {
                quantity++;
            }
        }
        //return Arrays.copyOf(items, quantity);
        return Arrays.copyOf(items,position);
    }
    public Item[] findByName(String name) {
        Item[] temp = new Item[this.position];
        int i = 0;
        for (int index = 0; index < items.length; index++) {
            if (items[index] != null && items[index].getName().equals(name)) {
                temp[i] = items[index];
                i++;
            }
        }
        Item[] result = new Item[i];
        for (int index = 0; index < temp.length; index++) {
            if (temp[index] != null) {
                result[index] = temp[index];
            }
        }
        return result;
    }
    /**
     * Метод поиска заявки по id.
     * @param id Id заявки.
     * @return искомая заявка.

    public Item findById(String id) {
        Item result = null;
        for (Item item : items) {
            if (item != null && item.getId().equals(id)) {
                result = item;
                break;
            }
        }
        return result;
    }
    */
    /**
     * Вывод массива с заявками.
     * @return массив с заявками.
     */
    public Item[] getAll() {
        Item[] result = new Item[this.position];
        for (int index = 0; index != this.position; index++) {
        result[index] = this.items[index];
        }
        return result;
    }
    /**
     * метод для генерации уникального id.
     * @return уникальный id, состоящий из текущего времени в мс + случайного числа.
     */
    private String generateId() {
        return String.valueOf(System.currentTimeMillis() + rn.nextInt());
    }
}
