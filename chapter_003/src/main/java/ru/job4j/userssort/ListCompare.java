package ru.job4j.userssort;

import java.util.Comparator;

public class ListCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int result = 0;
        int indexMax = left.length() > right.length() ? right.length() : left.length();
        for (int i = 0; i < indexMax; i++) {
            if (left.charAt(i) < right.charAt(i)) {
                result = -1;
                break;
            } else if (left.charAt(i) > right.charAt(i)) {
                result = 1;
                break;
            }
        }
        if (result == 0 && left.length() != right.length()) {
            result = left.length() > right.length() ? 1 : -1;
        }
        return result;
    }
}
