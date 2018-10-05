package ru.job4j.profession;
/**
 * Профессия инженера.
 *  @author Dmitry Rozhdestvenskiy (mailto:dmr1433@gmail.com)
 *  @version $Id$
 *  @since 0.1
 */
public class Engineer extends Profession {
    public Engineer(String name, int age, int hunger, int thirst, int qualification, String sex) {
    this.name = name;
    this.age = age;
    this.hunger = hunger;
    this.thirst = thirst;
    this.qualification = qualification;
    this.sex = sex;
    }
    /**
     * Метод строительства дома.
     * @param house дом.
     * @return тип строящегося дома.
     */
    public String built(House house) {
        return house.type;
    }
}
