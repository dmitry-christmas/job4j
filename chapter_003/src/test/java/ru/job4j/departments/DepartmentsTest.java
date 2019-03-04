package ru.job4j.departments;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class DepartmentsTest {
    Departments dep = new Departments();
    @Test
    public void depSortingTestUp() {
        String[] departments = {"K1\\SK1", "K1", "K1\\SK2", "K1\\SK1\\SSK1", "K1\\SK1\\SSK2", "K2", "K2\\SK1\\SSK1", "K2\\SK1\\SSK2"};
        dep.depSortingUp(departments);
        String[] expected = {"K1", "K1\\SK1", "K1\\SK1\\SSK1", "K1\\SK1\\SSK2", "K1\\SK2", "K2", "K2\\SK1\\SSK1", "K2\\SK1\\SSK2"};
        assertThat(departments, is(expected));
    }
    @Test
    public void depSortingTestDown() {
        String[] departments = {"K1\\SK1", "K1", "K1\\SK2", "K1\\SK1\\SSK1", "K1\\SK1\\SSK2", "K2", "K2\\SK1\\SSK1", "K2\\SK1\\SSK2"};
        dep.depSortingDown(departments);
        String[] expected = {"K2\\SK1\\SSK2", "K2\\SK1\\SSK1", "K2", "K1\\SK2", "K1\\SK1\\SSK2", "K1\\SK1\\SSK1", "K1\\SK1", "K1"};
        assertThat(departments, is(expected));
    }
    @Test
    public void depSortingSetTestDown() {
        String[] departments = {"K1\\SK1", "K1", "K1\\SK2", "K1\\SK1\\SSK1", "K1\\SK1\\SSK2", "K2", "K2\\SK1\\SSK1", "K2\\SK1\\SSK2"};
        departments = dep.depSortingDownBySet(departments);
        String[] expected = {"K2\\SK1\\SSK2", "K2\\SK1\\SSK1", "K2", "K1\\SK2", "K1\\SK1\\SSK2", "K1\\SK1\\SSK1", "K1\\SK1", "K1"};
        assertThat(departments, is(expected));
    }
    @Test
    public void orgSortingTestUp() {
        List departments = new ArrayList(Arrays.asList("K1\\SK1", "K1", "K1\\SK2", "K1\\SK1\\SSK1", "K1\\SK1\\SSK2", "K2", "K2\\SK1\\SSK1", "K2\\SK1\\SSK2"));
        Org org = new Org(departments);
        org.sortingUp(org.getDeps());
        List result = new ArrayList(Arrays.asList("K1", "K1\\SK1", "K1\\SK1\\SSK1", "K1\\SK1\\SSK2", "K1\\SK2", "K2", "K2\\SK1\\SSK1", "K2\\SK1\\SSK2"));
        assertThat(org.getDeps(), is(result));
    }
    @Test
    public void orgSortingTestDown() {
        List departments = new ArrayList(Arrays.asList("K1\\SK1", "K1", "K1\\SK2", "K1\\SK1\\SSK1", "K1\\SK1\\SSK2", "K2", "K2\\SK1\\SSK1", "K2\\SK1\\SSK2"));
        Org org = new Org(departments);
        org.sortingDown(org.getDeps());
        List result = new ArrayList(Arrays.asList("K2\\SK1\\SSK2", "K2\\SK1\\SSK1", "K2", "K1\\SK2", "K1\\SK1\\SSK2", "K1\\SK1\\SSK1", "K1\\SK1", "K1"));
        assertThat(org.getDeps(), is(result));
    }
}
