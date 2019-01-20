package ru.job4j.userssort;

import java.util.*;

public class SortUser {
    public TreeSet<User> sort(List<User> users) {
        TreeSet<User> result = new TreeSet<>();
        result.addAll(users);
        return result;
    }
    public List<User> sortNameLength(List<User> users) {
        Comparator<User> comparator = new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.getName().length() - o2.getName().length();
            }
        };
        users.sort(comparator);
        return users;
    }
    public List<User> sortByAllFields(List<User> users) {
        Comparator<User> comparatorName = new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                int result = 0;
                if (o1.getName() != o2.getName()) {
                    result = o1.getName().compareTo(o2.getName());
                } else {
                    result = o1.getAge() - o2.getAge();
                }
                return result;
            }
        };
        users.sort(comparatorName);

        return users;
    }
}
