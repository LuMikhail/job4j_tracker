package ru.job4j.collection.sort;

import java.util.Comparator;

public class LexSort implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        String[] right = o1.split("\\.");
        String[] left = o2.split("\\.");
        return Integer.compare(Integer.parseInt(right[0]), Integer.parseInt(left[0]));
    }
}
