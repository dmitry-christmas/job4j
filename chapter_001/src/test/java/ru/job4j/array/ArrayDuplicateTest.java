package ru.job4j.array;
import org.junit.Test;
import java.util.Arrays;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ArrayDuplicateTest {
    @Test
    public void arrayDuplicateTest() {
        ArrayDuplicate arrayDuplicate = new ArrayDuplicate();
        String[] array = {"Привет", "Мир", "Привет", "Супер", "Мир"};
        String[] result = arrayDuplicate.remove(array);
        String[] expect = {"Привет", "Мир", "Супер"};
        assertThat(result, is(expect));
    }
}
