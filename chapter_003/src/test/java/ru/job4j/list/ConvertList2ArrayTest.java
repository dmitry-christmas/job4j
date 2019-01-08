package ru.job4j.list;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class ConvertList2ArrayTest {
    ConvertList2Array convertList = new ConvertList2Array();
    @Test
    public void when7ElementsThen9() {
        int[][] result = convertList.toArray(
                Arrays.asList(1, 2, 3, 4, 5, 6, 7),
                3
        );
        int[][] expect = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 0, 0}
        };
        assertThat(result, is(expect));
    }
   /* @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ConvertList2ArrayTest)) return false;
        ConvertList2ArrayTest that = (ConvertList2ArrayTest) o;
        return Objects.equals(convertList, that.convertList);
    }
    @Override
    public int hashCode() {
        return Objects.hash(convertList);
    }*/
    @Test
    public void when2Lists123456() {
        List<int[]> list = new ArrayList<>();
        list.add(new int[]{1, 2});
        list.add(new int[]{3, 4, 5, 6});
        List <Integer> result = convertList.convert(list);
        List <Integer> expected = Arrays.asList(1, 2, 3, 4, 5, 6);
        assertTrue(result.equals(expected));

    }
}