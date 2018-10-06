package ru.job4j.profession;
/**
 * Профессия врача.
 *  @author Dmitry Rozhdestvenskiy (mailto:dmr1433@gmail.com)
 *  @version $Id$
 *  @since 0.1
 */
public class Doctor extends Profession {
    private String specialization;
    public Doctor(String name, int age, int hunger, int thirst, int qualification, String sex, String specialization) {
        super(name, age, hunger, thirst, qualification, sex);
        this.specialization = specialization;
    }
    /**
     * Метод лечения пациента.
     * @param patient пациент.
     * @return диагноз.
     */
    public String heal(Patient patient) {
        return patient.getDiagnose();
    }
    public String getSpecialization() {
        return specialization;
    }
    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }
}
