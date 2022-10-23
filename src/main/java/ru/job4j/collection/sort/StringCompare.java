package ru.job4j.collection.sort;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        int rsl = 0;
        int stringlength = Math.min(left.length(), right.length());
        for (int i = 0; i < stringlength; i++) {
            rsl = Character.compare(left.charAt(i), right.charAt(i));
            if (rsl != 0) {
                return rsl;
            }
        }
        if (left.length() != right.length()) {
            rsl = Integer.compare(left.length(), right.length());
        }
        return rsl;
    }
}
