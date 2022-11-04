package ru.job4j.stream.statistics;

import java.util.List;

/**
 *  Класс Pupil описывает ученика.
 */
public record Pupil(String name, List<Subject> subject) {
}
