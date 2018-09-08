package ru.job4j.array;
/**
 * Поиск методом перебора.
 *
 * @author Dmitry Rozhdestvenskiy (mailto:dmr1433@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class FindLoop {
    /**
     * @param data массив, в котором производим поиск.
     * @param el элемент, который ищем
     * @return индекс элемента, который ищем., -1, если элемент не найден.
     */
    public int indexOf(int[] data, int el) {
        int rst = -1;
        for (int i = 0; i != data.length; i++) {
            if (data[i] == el) {
                rst = i;
                break;
            }
        }
        return rst;
    }
}
