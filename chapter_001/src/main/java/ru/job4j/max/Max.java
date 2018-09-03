package ru.job4j.max;
/**
 * Calculating of a max number.
 *
 * @author Dmitry Rozhdestvenskiy (mailto:dmr1433@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Max {
    /**
     * @param - the first and second numbers.
     */
    public int max(int first, int second) {
        return first >= second ? first : second;
    }
    public int max(int first, int second, int third) {
        int temp = this.max(first, second);
        return this.max(temp, third);
    }
}
