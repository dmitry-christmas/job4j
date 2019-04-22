package ru.job4j.departmentssort;
/**
 * Класс сортировки массива департаментов с извращением с помощью создания класса организации и TreeSet организаций.
 * @author Dmitry Rozhdestvenskiy (dmr1433@gmail.com)
 * @version $Id$
 * @since 0.1
 */
import java.util.*;

public class Departments {
    boolean checked = false;
    //Будущий метод проверки массива на пропуски
    /*public boolean check(String[] deps) {
        boolean result = false;
        do {
            deps = arrayCheck(deps);
        } while (checked = false);

        return result;
    }*/
    /**
     * метод сортировки департаментов в натуральном порядке с извращением через TreeSet Orgов.
     * @param deps Массив с департаментами.
     * @return Массив с отсортированными департаментами.
     */
    public String[] sortingUp(String[] deps) {
        Comparator<Org> depsComparatorUp = new Comparator<Org>() {
            @Override
            public int compare(Org o1, Org o2) {
                int result = o1.getKod().compareTo(o2.getKod());
                return result;
            }
        };
        Org[] org = orgCreation(deps);
        Set<Org> departmentsSet = new TreeSet<>(depsComparatorUp);
        departmentsSet.addAll(Arrays.asList(org));
        String[] result = new String[departmentsSet.size()];
        Iterator<Org> it = departmentsSet.iterator();
        for (int i = 0; i < result.length; i++) {
            result[i] = it.next().getKod();
        }
        return result;
    }
    /**
     * метод сортировки департаментов в обратном порядке с извращением через TreeSet Orgов.
     * @param deps Массив с департаментами.
     * @return Массив с отсортированными департаментами.
     */
    public String[] sortingDown(String[] deps) {
        Comparator<Org> depsComparatorUp = new Comparator<Org>() {
            @Override
            public int compare(Org o1, Org o2) {
                int result = o1.getKod().compareTo(o2.getKod()) * -1;
                return result;
            }
        };
        Org[] org = orgCreation(deps);
        Set<Org> departmentsSet = new TreeSet<>(depsComparatorUp);
        departmentsSet.addAll(Arrays.asList(org));
        String[] result = new String[departmentsSet.size()];
        Iterator<Org> it = departmentsSet.iterator();
        for (int i = 0; i < result.length; i++) {
            result[i] = it.next().getKod();
        }
        return result;
    }

    /**
     * Метод создания массива Orgов из массива с кодами департаментов.
     * @param deps
     * @return
     */
    public Org[] orgCreation(String[] deps) {
        Org[] result = new Org[deps.length];
        for (int i = 0; i < deps.length; i++) {
            result[i] = new Org(deps[i]);
        }
        return result;
    }

/*    public String[] arrayCheck(String[] deps) {
        List list = new ArrayList(Arrays.asList(deps));
        for(int i = 0; i < list.size(); i++) {
            int slashIndex = deps[i].lastIndexOf("\\");
            if (slashIndex > -1 && i == 0) {
                //add String 0
                String temp = deps[i].substring(0, slashIndex);

                list.add(0, temp);
                deps = new String[list.size()];
                list.toArray(deps);
            }
            if (i > -1 && i > 0) {
                String temp = deps[i].substring(0, slashIndex);

            }

        }
        return deps;
    }*/
}
