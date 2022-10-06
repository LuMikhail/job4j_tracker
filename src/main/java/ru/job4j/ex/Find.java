package ru.job4j.ex;

public class Find {
    public static String get(String[] date, int index) {
        if (index < 0 || index >= date.length) {
            throw new IllegalArgumentException("Index out of bound");
        }
        return date[index];
    }

    public static void main(String[] args) {
        String[] date = {"one", "two", "three"};
        String rsl = Find.get(date, 2);
        System.out.println(rsl);
    }
}
