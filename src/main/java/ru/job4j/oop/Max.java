package ru.job4j.oop;

public class Max {
    public static int max(int first, int second) {
        int result = first > second ? first : second;
        return result;
    }

    public  static int max(int first, int second, int third) {
        int temp = max(first, second);
        return max(third, temp);
    }

    public static int max(int first, int second, int third, int fourth) {
        int temp = max(first, second, third);
        return max(fourth, temp);
    }

    public static void main(String[] args) {
        System.out.println(max(1, 10, 5, 7));
    }
}
