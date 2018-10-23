package ru.job4j.pseudo;
/**
 *Класс формирования квадрата.
 * @author Dmitry Rozhdestvenskiy (mailto:dmr1433@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Square implements Shape {
    /**
     *Метод формирования квадрата с помощью StringBuilder().
     */
    @Override
    public String draw() {
        StringBuilder pic = new StringBuilder();
        pic.append("XXXXXX");
        pic.append(System.lineSeparator());
        pic.append("X    X");
        pic.append(System.lineSeparator());
        pic.append("XXXXXX");
        return pic.toString();
    }
}
