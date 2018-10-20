package ru.job4j.pseudo;
/**
 *класс вывода в консоль отрисованных фигур.
 */
public class Paint {
    /**
     * метод рисования в консоли.
     * @param shape фигура.
     */
    public void draw(Shape shape) {
        System.out.println(shape.draw());
    }
}
