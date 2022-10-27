package ru.job4j.lamda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Класс сортируем с помощью лямбда-выражений и выводит список строк в консоль.
 * <p>
 * Добавлена отладочная информация в лямбда-выражение.
 *
 * @version 1.0
 */
public class LambdaUsage {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("eeeee", "a", "ccc", "dddd", "bb");

        Comparator<String> comparator = (left, right) -> {
            System.out.println("compare - " + left + " : " + right);
            return Integer.compare(right.length(), left.length());
        };
        strings.sort(comparator);
        for (String str : strings) {
            System.out.println(str);
        }
    }
}
