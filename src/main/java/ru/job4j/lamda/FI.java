package ru.job4j.lamda;

import java.util.Comparator;

/**
 * Класс сравнивает строки с использованием лямбда выражений:
 * <p>  1. Сравнивает строки по возрастанию.
 *
 * <p> 2. Сравнивает строки по убыванию длины.
 *
 * @version 1.0
 */
public class FI {
    public static void main(String[] args) {
        String first = "Виноград";
        String second = "Инвентаризация";
        Comparator<String> decreaseSort = (left, right) -> left.compareTo(right);
        System.out.println(decreaseSort.compare(second, first));
        Comparator<String> decreaseSortLength = (left, right)
                -> Integer.compare((right.length()), left.length());
        System.out.println(decreaseSortLength.compare(second, first));
    }
}
