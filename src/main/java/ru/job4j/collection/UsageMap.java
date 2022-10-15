package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("fedorov1987@mail.ru", "Beloglyadov Dmitry Viktorovich");
        map.put("fedorov1987@mail.ru", "Fedorov Sergey Nikolaevich");
        map.put("kapustina@mail.ru", "Kapustina Anastasia Andreevna");
        for (String key : map.keySet()) {
            String value = map.get(key);
            System.out.println(value);
        }
    }
}
