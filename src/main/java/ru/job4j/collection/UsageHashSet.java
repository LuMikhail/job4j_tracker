package ru.job4j.collection;

import java.util.Collections;
import java.util.HashSet;

public class UsageHashSet {
    public static void main(String[] args) {
        HashSet<String> autos = new HashSet<>();
        Collections.addAll(autos, "Lada", "BMW", "Volvo", "BMW", "Toyota", "Volvo", "Lada");
        for (String auto : autos) {
            System.out.println(auto);
        }
    }
}
