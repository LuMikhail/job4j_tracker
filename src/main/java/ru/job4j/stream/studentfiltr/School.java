package ru.job4j.stream.studentfiltr;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Класс с помощью метода collect создает новую коллекцию, в соответствии с условием лямбда-выражения.
 * Условия лямбда-выражений определены в классе SchoolTest.
 *
 * @version 1.0
 */
public class School {
    public List<Student> collect(List<Student> students, Predicate<Student> predict) {
        return students.stream()
                .filter(t -> predict.test(t))
                .collect(Collectors.toList());
    }
}
