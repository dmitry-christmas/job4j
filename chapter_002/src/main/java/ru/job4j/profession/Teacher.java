package ru.job4j.profession;
/**
 * Профессия учителя.
 *  @author Dmitry Rozhdestvenskiy (mailto:dmr1433@gmail.com)
 *  @version $Id$
 *  @since 0.1
 */
public class Teacher extends Profession {
    private String specialization;
    public Teacher(String name, int age, int hunger, int thirst, int qualification, String sex, String specialization) {
        super(name, age, hunger, thirst, qualification, sex);
        this.specialization = specialization;
    }

    /**
     * Метод обучения студента.
     * @param student студент.
     * @return название урока.
     */
    public String teach(Student student) {
        return student.getLesson();
    }
    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }
}
