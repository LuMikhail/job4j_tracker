package ru.job4j.oop;

public class College {
    public static void main(String[] args) {
        Freshman koly = new Freshman();
        Student student = koly;
        Object objKoly = koly;
        System.out.println("Пример повышающего привидения типов.");
    }
}
