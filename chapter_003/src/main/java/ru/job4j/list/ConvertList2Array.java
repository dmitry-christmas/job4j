package ru.job4j.list;

import java.util.ArrayList;
import java.util.List;

public class ConvertList2Array {
    public int[][] toArray(List<Integer> list, int rows) {
        int counter = 0;
        int cells = (int) Math.ceil((double) list.size() / rows);
        int[][] array = new int[rows][cells];
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cells; j++) {
                    if (counter < list.size()) {
                        array[i][j] = list.get(counter);
                        counter++;
                    }
                }
            }
        return array;
    }
    public List<Integer> convert(List<int[]> list) {
        List<Integer> result = new ArrayList<>();
        for (int[] array : list) {
            for (int i : array) {
                result.add(i);
            }
        }
        return result;
    }
}