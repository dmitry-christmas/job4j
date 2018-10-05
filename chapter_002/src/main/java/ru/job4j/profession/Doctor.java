package ru.job4j.profession;
/**
 * Профессия врача.
 *  @author Dmitry Rozhdestvenskiy (mailto:dmr1433@gmail.com)
 *  @version $Id$
 *  @since 0.1
 */
public class Doctor extends Profession {
    String specializaton;
    public Doctor(String name, int hunger, int thirst, int qualification, String sex) {
        this.name = name;
        this.hunger = hunger;
        this.thirst = thirst;
        this.qualification = qualification;
        this.sex = sex;
    }
    /**
     * Метод лечения пациента.
     * @param patient пациент.
     * @return диагноз.
     */
    public String heal(Patient patient) {
        return patient.diagnose;
    }
}
