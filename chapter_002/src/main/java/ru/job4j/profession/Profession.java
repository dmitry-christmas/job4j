package ru.job4j.profession;
/**
 * Общий класс профессий.
 *  @author Dmitry Rozhdestvenskiy (mailto:dmr1433@gmail.com)
 *  @version $Id$
 *  @since 0.1
 */
public class Profession {
    String name;
    String diagnose;
    int age;
    int hunger = 0;
    int thirst = 0;
    int qualification = 1;
    String sex;
    void eating() {
        hunger--;
    }
    void drinking() {
        thirst--;
    }
    void living() {
        hunger++;
        thirst++;
    }
    void studying() {
        qualification++;
    }
    public String getName() {
        return name;
    }
}