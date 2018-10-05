package ru.job4j.profession;
/**
 * Профессия учителя.
 *  @author Dmitry Rozhdestvenskiy (mailto:dmr1433@gmail.com)
 *  @version $Id$
 *  @since 0.1
 */
public class Teacher extends Profession {
    String specializaton;
    public Teacher(String name, int age, int hunger, int thirst, int qualification, String sex, String specializaton) {
        this.name = name;
        this.age = age;
        this.hunger = hunger;
        this.thirst = thirst;
        this.qualification = qualification;
        this.sex = sex;
        this.specializaton = specializaton;
    }
    /**
     * Метод обучения студента.
     * @param student студент.
     * @return название урока.
     */
    public String teach(Student student) {
        return student.lesson;
    }
}
