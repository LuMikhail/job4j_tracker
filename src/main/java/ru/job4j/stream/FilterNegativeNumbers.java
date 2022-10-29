package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Класс с помощью stream фильтрует исходную коллекцию:
 * <p> если есть положительные числа и они не равны 0,
 * то создается новая коллекция с этими числами.
 * Созданная коллекция выводиться на консоль.
 *
 * @version 1.0
 */
public class FilterNegativeNumbers {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(2, 18, 145, -87, 789, -354, 0, -1);
        List<Integer> positive = numbers.stream().filter(i -> i > 0).collect(Collectors.toList());
        positive.forEach(System.out::println);
    }
}
