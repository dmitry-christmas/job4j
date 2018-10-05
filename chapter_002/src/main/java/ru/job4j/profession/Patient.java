package ru.job4j.profession;
/**
 * Профессия пациента :).
 *  @author Dmitry Rozhdestvenskiy (mailto:dmr1433@gmail.com)
 *  @version $Id$
 *  @since 0.1
 */
public class Patient extends Profession {
    public Patient(String name, String diagnose, int hunger, int thirst, String sex) {
        this.name = name;
        this.diagnose = diagnose;
        this.hunger = hunger;
        this.thirst = thirst;
        this.sex = sex;
    }

}
