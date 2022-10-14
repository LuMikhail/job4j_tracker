package ru.job4j.collection;

import java.util.HashSet;

public class UniqueText {
    public static boolean isEquals(String originText, String duplicateText) {
        boolean rsl = true;
        String[] origins = originText.split(" ");
        HashSet<String> check = new HashSet<>();
        for (String origin : origins) {
            check.add(origin);
        }
        String[] texts = duplicateText.split(" ");
        for (String text : texts) {
            if (!check.contains(text)) {
                rsl = false;
                break;
            }
        }
        return rsl;
    }
}
