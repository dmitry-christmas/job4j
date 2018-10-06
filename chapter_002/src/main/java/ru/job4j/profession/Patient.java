package ru.job4j.profession;
/**
 * Профессия пациента :).
 *  @author Dmitry Rozhdestvenskiy (mailto:dmr1433@gmail.com)
 *  @version $Id$
 *  @since 0.1
 */
public class Patient {
    private String diagnose;
    private String name;
    private int age;
    public Patient() {
    }
    public String getDiagnose() {
        return diagnose;
    }
    public void setDiagnose(String diagnose) {
        this.diagnose = diagnose;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
