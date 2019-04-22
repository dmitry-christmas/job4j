package ru.job4j.departmentssort;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class DepartmentsSortTest {
    Departments dep = new Departments();
    @Test
    public void depSortingTestUp() {
        String[] departments = {"K1\\SK1", "K1", "K1\\SK2", "K1\\SK1\\SSK1", "K1\\SK1\\SSK2", "K2", "K2\\SK1\\SSK1", "K2\\SK1\\SSK2"};
        String[] result = dep.sortingUp(departments);
        String[] expected = {"K1", "K1\\SK1", "K1\\SK1\\SSK1", "K1\\SK1\\SSK2", "K1\\SK2", "K2", "K2\\SK1\\SSK1", "K2\\SK1\\SSK2"};
        assertThat(result, is(expected));
    }
    @Test
    public void depSortingTestDown() {
        String[] departments = {"K1\\SK1", "K1", "K1\\SK2", "K1\\SK1\\SSK1", "K1\\SK1\\SSK2", "K2", "K2\\SK1\\SSK1", "K2\\SK1\\SSK2"};
        String[] result = dep.sortingDown(departments);
        String[] expected = {"K2\\SK1\\SSK2", "K2\\SK1\\SSK1", "K2", "K1\\SK2", "K1\\SK1\\SSK2", "K1\\SK1\\SSK1", "K1\\SK1", "K1"};
        assertThat(result, is(expected));
    }
}
