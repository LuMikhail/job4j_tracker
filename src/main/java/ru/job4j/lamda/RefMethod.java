package ru.job4j.lamda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * Класс выводит на консоль список имен. Если имя больше 10 символов, то вывод обрезается.
 *
 * @version 1.0
 */
public class RefMethod {
    public static void main(String[] args) {
        List<String> names = Arrays.asList(
                "Ivan",
                "Petr Arsentev"
        );
        Consumer<String> out = RefMethod::cutOut;
        names.forEach(out);
    }

    /**
     * Метод осуществляет действия с входящем аргументом:
     * если длина аргумента > 10 символов, то переменная при выводе на консоль обрезается.
     * @param value входящий аргумент типа String.
     */
    public static void cutOut(String value) {
        if (value.length() > 10) {
            System.out.println(value.substring(0, 10) + "..");
        } else {
            System.out.println(value);
        }
    }
}
