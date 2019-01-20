package ru.job4j.userssort;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class SortUser {
    public TreeSet<User> sort(List<User> users) {
        /*Comparator<User> comparator = new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.getAge() - o2.getAge();
            }
        };*/
        TreeSet<User> result = new TreeSet<>();
        //users.sort();
        result.addAll(users);
        return result;
    }
}
