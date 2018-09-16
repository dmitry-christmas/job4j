package ru.job4j.array;
/**
 * Обертка над строкой.
 *  @author Dmitry Rozhdestvenskiy (mailto:dmr1433@gmail.com)
 *  @version $Id$
 *  @since 0.1
 */
public class ArrayChar {
    private char[] data;
    public ArrayChar(String line) {
        this.data = line.toCharArray();
    }
    /**
     * Проверяет. что слово начинается с префикса.
     * @param prefix префикс.
     * @return если слово начинается с префикса
     */
    public boolean startWith(String prefix) {
        boolean result = true;
        char[] value = prefix.toCharArray();
        for (int i = 0; i <= value.length - 1; i++) {
            if (data[i] != value [i]) {
                result = false;
                break;
            }
        }
        return result;
    }
}
