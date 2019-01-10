package ru.job4j.list2map;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class UserConvertTest {
    @Test
    public void ifList2MapThenMap() {
        UserConvert convert = new UserConvert();
        List<User> users = new ArrayList<>();
        User petr = new User(0, "Petr", "Bryansk");
        User dmitry = new User(1, "Dmitry", "Praha");
        users.add(petr);
        users.add(dmitry);
        Map<Integer, User> result = convert.process(users);
        Map<Integer, User> expected = new HashMap<>();
        expected.put(0, petr);
        expected.put(1, dmitry);
        assertThat(result, is(expected));
    }
}
