package ru.job4j.stream.statistics;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Класс Analyze получает статистику по аттестатам учеников:
 * <p> 1. Вычисляет общий средний балл.</p>
 * <p> 2. Вычисляет средний балл по каждому ученику.</p>
 * <p> 3. Вычисляет средний балл по каждому предмету.</p>
 * <p> 4. Определяет лучшего ученика.</p>
 * <p> 5. Определяет предмет с наибольшим баллом для всех студентов.</p>
 *
 * @version 1.0
 */
public class Analyze {

    /**
     * Метод - вычисляет общий средний балл.
     *
     * @param stream поток учеников со списком предметов и аттестационных баллов.
     * @return возвращает общий средний балл.
     */
    public static double averageScore(Stream<Pupil> stream) {
        return stream.flatMap(pupil -> pupil.subject().stream())
                .mapToInt(Subject::score)
                .average()
                .orElse(0D);
    }

    /**
     * Метод - вычисляет средний балл по каждому ученику.
     *
     * @param stream поток учеников со списком предметов и аттестационных баллов.
     * @return Возвращает список из объекта Tuple (имя ученика и средний балл).
     */
    public static List<Tuple> averageScoreByPupil(Stream<Pupil> stream) {
        return stream
                .map(pupil -> new Tuple(pupil.name(), pupil.subject().stream()
                        .mapToDouble(Subject::score)
                        .average()
                        .orElse(0D)))
                .collect(Collectors.toList());
    }

    /**
     * Метод - вычисляет средний балл по каждому предмету.
     *
     * @param stream поток учеников со списком предметов и аттестационных баллов.
     * @return Возвращает список из объектов Tuple (название предмета и средний балл).
     */
    public static List<Tuple> averageScoreBySubject(Stream<Pupil> stream) {
        return stream.flatMap(pupil -> pupil.subject().stream())
                .collect(Collectors.groupingBy(Subject::name,
                        Collectors.averagingDouble(Subject::score)))
                .entrySet()
                .stream()
                .map(tuple -> new Tuple(tuple.getKey(), tuple.getValue()))
                .collect(Collectors.toList());
    }

    /**
     * Метод - возвращает лучшего ученика. Лучшим считается ученик с наибольшим суммарным баллом по всем предметам.
     *
     * @param stream поток учеников со списком предметов и аттестационных баллов.
     * @return Возвращает объект Tuple (имя ученика и суммарный балл).
     */
    public static Tuple bestStudent(Stream<Pupil> stream) {
        return stream
                .map(pupil -> new Tuple(pupil.name(), pupil.subject().stream()
                        .mapToDouble(Subject::score)
                        .sum()))
                .max(Comparator.comparingDouble(Tuple::score))
                .orElse(null);
    }

    /**
     * Метод - возвращает предмет с наибольшим баллом для всех студентов
     *
     * @param stream оток учеников со списком предметов и аттестационных баллов.
     * @return Возвращает объект Tuple (имя предмета, сумма баллов каждого ученика по этому предмету).
     */
    public static Tuple bestSubject(Stream<Pupil> stream) {
        return stream.flatMap(pupil -> pupil.subject().stream())
                .collect(Collectors.groupingBy(Subject::name,
                        Collectors.summingDouble(Subject::score)))
                .entrySet()
                .stream()
                .map(tuple -> new Tuple(tuple.getKey(), tuple.getValue()))
                .max(Comparator.comparingDouble(Tuple::score))
                .orElse(null);
    }
}
