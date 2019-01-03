package ru.job4j.search;
import java.util.ArrayList;
import java.util.List;
/**
 * Симуляция телефонного справочника.
 *  @author Dmitry Rozhdestvenskiy (mailto:dmr1433@gmail.com)
 *  @version $Id$
 *  @since 0.1
 */
public class PhoneDictionary {
    private List<Person> persons = new ArrayList<Person>();

    public void add(Person person) {
        this.persons.add(person);
    }
    /**
     * Вернуть список всех пользователей, который содержат key в любых полях.
     * @param key Ключ поиска.
     * @return Список подощедщих пользователей.
     */
    public List<Person> find(String key) {
        List<Person> result = new ArrayList<>();
        for (Person person : persons) {
            String name = person.getName();
            String surname = person.getSurname();
            String phone = person.getPhone();
            String adress = person.getAddress();
            if (name.contains(key) || surname.contains(key) || phone.contains(key) || adress.contains(key)) {
                result.add(person);
                break;
            }
        }
        return result;
    }
}
