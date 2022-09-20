package ru.job4j.ex;

public class Fact {
    public  int calc(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Start should be less than finish.");
        }
        int rsl = 1;
        for (int index = 0; index <= n; index++) {
            rsl *= index;
        }
        return rsl;
    }

    public static void main(String[] args) {
        new Fact().calc(-1);
    }
}
