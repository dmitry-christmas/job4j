package ru.job4j.pseudo;
/**
 *Класс формирования треугольника.
 * @author Dmitry Rozhdestvenskiy (mailto:dmr1433@gmail.com)
 * @version $Id$
 * @since 0.1
 *
 */
public class Triangle implements Shape {
    /**
     *Метод формирования треугольника с помощью StringBuilder().
     */
    @Override
    public String draw() {
        StringBuilder pic = new StringBuilder();
        pic.append("   X   ");
        pic.append(System.lineSeparator());
        pic.append("  XXX  ");
        pic.append(System.lineSeparator());
        pic.append(" XXXXX ");
        pic.append(System.lineSeparator());
        pic.append("XXXXXXX");
        return pic.toString();
    }
}
