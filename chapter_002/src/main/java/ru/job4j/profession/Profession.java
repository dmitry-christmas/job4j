package ru.job4j.profession;
/**
 * Общий класс профессий.
 *  @author Dmitry Rozhdestvenskiy (mailto:dmr1433@gmail.com)
 *  @version $Id$
 *  @since 0.1
 */
public class Profession {
    private String name;
    private int age;
    private int hunger;
    private int thirst;
    private int qualification;
    private String sex;
    public Profession(String name, int age, int hunger, int thirst, int qualification, String sex) {
        this.name = name;
        this.age = age;
        this.hunger = hunger;
        this.thirst = thirst;
        this.qualification = qualification;
        this.sex = sex;
    }
    void eating() {
        hunger--;
    }
    public void drinking() {
        thirst--;
    }
    public void living() {
        hunger++;
        thirst++;
    }
    public void studying() {
        qualification++;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public int getHunger() {
        return hunger;
    }
    public void setHunger(int hunger) {
        this.hunger = hunger;
    }
    public int getThirst() {
        return thirst;
    }
    public void setThirst(int thirst) {
        this.thirst = thirst;
    }
    public int getQualification() {
        return qualification;
    }
    public void setQualification(int qualification) {
        this.qualification = qualification;
    }
    public String getSex() {
        return sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
}