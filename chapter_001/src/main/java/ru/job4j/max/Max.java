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
        int result = 0;
        result = first >= second ? first : second;
        return result;
    }
}
