package ru.job4j.departments;
/**
 * Класс сортировки департаментов.
 * @author Dmitry Rozhdestvenskiy (dmr1433@gmail.com)
 * @version $Id$
 * @since 0.1
 */
import java.util.*;

public class Departments {
    /**
     * метод сортировки департаментов в натуральном порядке.
     * @param departments Массив с департаментами.
     * @return Массив с отсортированными департаментами.
     */
    public String[] depSortingUp(String[] departments) {
        Arrays.sort(departments);
        return departments;
    }

    /**
     * Метод сортировки департаментов в обратном порядке.
     * @param departments Массив с департаментами.
     * @return Отсортированный по убыванию массив.
     */
    public String[] depSortingDown(String[] departments) {
        departments = depSortingUp(departments);
        for (int i = 0; i < departments.length; i++) {
            if (i != departments.length - i - 1) {
                String temp = departments[i];
                departments[i] = departments[departments.length - i - 1];
                departments[departments.length - i - 1] = temp;
                i++;
            }
        }
        return departments;
    }

    /**
     * Метод сортировки с использованием TreeSet.
     * @param departments
     * @return
     */
    public String[] depSortingDownBySet(String[] departments) {
        Comparator<String> depsComparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int result = o1.compareTo(o2) * -1;
                return result;
            }
        };
        Set<String> depsSet = new TreeSet<>(depsComparator);
        depsSet.addAll(Arrays.asList(departments));
        departments = depsSet.toArray(new String[depsSet.size()]);

        return departments;
    }
}
