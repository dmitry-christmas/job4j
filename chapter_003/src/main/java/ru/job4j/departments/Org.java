package ru.job4j.departments;
/**
 * Класс организации.
 * @author Dmitry Rozhdestvenskiy (dmr1433@gmail.com)
 * @version $Id$
 * @since 0.1
 */

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Org {
    private List deps;

    public Org(List deps) {
        this.deps = deps;
    }
    public List getDeps() {
        return deps;
    }

    public void setDeps(List deps) {
        this.deps = deps;
    }

    /**
     * Метод сортировки департаментов в обратном порядке.
     * @return ArrayList с отсортированными департаментами.
     */
    public List<String> sortingDown(List<String> departments) {
        Comparator<String> sortDown = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        };
        departments.sort(sortDown);
        return departments;
    }

    /**
     * Метод сортировки департаментов по алфавиту.
     * @param departments ArrayList с департаментами.
     * @return ArrayList с отсортированными департаментами.
     */
    public List<String> sortingUp(List<String> departments) {
        Comparator<String> sortUp = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        };
        departments.sort(sortUp);
        return departments;
    }
}
