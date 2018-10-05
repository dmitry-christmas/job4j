package ru.job4j.profession;
/**
 * Профессия студента.
 *  @author Dmitry Rozhdestvenskiy (mailto:dmr1433@gmail.com)
 *  @version $Id$
 *  @since 0.1
 */
public class Student extends Profession {
    String lesson;
    public Student(String name, int age, int hunger, int thirst, String sex, String lesson) {
        this.name = name;
        this.age = age;
        this.hunger = hunger;
        this.thirst = thirst;
        this.sex = sex;
        this.lesson = lesson;
    }
}
