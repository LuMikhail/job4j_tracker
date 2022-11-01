package ru.job4j.stream.studentfiltr;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Класс содержит метод, который преобразует коллекцию List в Map.
 *
 * @version 1.0
 */
public class ListToMap {
    public static Map<String, Student> convert(List<Student> list) {
        return list.stream()
                .collect(Collectors.toMap(Student::getSurname, Function.identity(), (student, student2) -> student));
    }
}
