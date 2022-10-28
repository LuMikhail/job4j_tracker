package ru.job4j.lamda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * Класс создает новую коллекцию с использованием функционального интерфейса Predicate
 * согласно паттерну "Стратегия".
 *
 * @version 1.0
 */
public class SearchFolder {
    /**
     * Метод добавляет в новую коллекцию объекты - если объекты входящей коллекции
     * выполняют условия интерфейса Predicate
     *
     * @param list входящая коллекция
     * @param pred функциональный интерфейс Predicate.
     * @return возращаеется новая коллекция если Predicate - true.
     */
    public static List<Folder> filter(List<Folder> list, Predicate<Folder> pred) {
        List<Folder> result = new ArrayList<>();
        for (Folder element : list) {
            if (pred.test(element)) {
                result.add(element);
            }
        }
        return result;
    }
}
