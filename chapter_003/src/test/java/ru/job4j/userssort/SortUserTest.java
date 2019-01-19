package ru.job4j.userssort;

import org.junit.Test;
import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SortUserTest {
    SortUser sortUser = new SortUser();
    @Test
    public void ifUsersThenSort() {
        List<User> users = new ArrayList<>();
        User dmitry = new User("Dmitry", 40);
        User elena = new User("Elena", 14);
        User olga = new User("Olga", 44);
        User jurij = new User("Jurij", 7);
        users.addAll(Arrays.asList(dmitry, elena, olga, jurij));
        List<User> result = new ArrayList<>(sortUser.sort(users));
        List<User> expected = new ArrayList<>();
        expected.addAll(Arrays.asList(jurij, elena, dmitry, olga));
        assertThat(
                result, is(expected)
        );
    }
}
