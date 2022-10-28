package ru.job4j.lamda;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Класс сравнивает объекты в массиве и сортирует их с использованием лямбда выражений:
 * <p>
 * 1. Сортировка по возрастанию размера.
 * <p>
 * 2. Сортирует строки по возрастанию.
 * <p>
 * 3. Сортирует строки по убыванию длины.
 *
 * @version 1.0
 */
public class SortArray {
    public static void main(String[] args) {
        Attachment[] atts = {
                new Attachment("image 1", 170),
                new Attachment("image 3", 120),
                new Attachment("image 21", 23)
        };
        Comparator<Attachment> comparator = (left, right) -> Integer.compare(left.getSize(), right.getSize());
        Arrays.sort(atts, comparator);
        System.out.println(Arrays.toString(atts));
        Comparator<Attachment> decreaseSort = (left, right) -> left.getName().compareTo(right.getName());
        Arrays.sort(atts, decreaseSort);
        System.out.println(Arrays.toString(atts));
        Comparator<Attachment> decreaseSortLength = (left, right)
                -> Integer.compare((right.getName().length()), left.getName().length());
        Arrays.sort(atts, decreaseSortLength);
        System.out.println(Arrays.toString(atts));
    }
}