package ru.job4j.stream;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Класс Analyze получает статистику по аттестатам.
 *
 * @author Andrey Shulgin
 */
public class Analyze {

    /**
     * Метод averageScore вычисляет общий средний балл.
     *
     * @param stream - поток из учеников.
     * @return - средний балл или 0, если поток пуст.
     */
    public static double averageScore(Stream<Pupil> stream) {
        return stream
                .flatMapToInt(p -> p.getSubjects()
                        .stream()
                        .mapToInt(Subject::getScore))
                .average()
                .orElse(0D);
    }

    /**
     * Метод averageScoreBySubject вычисляет средний балл по каждому предмету.
     *
     * @param stream - поток из учеников.
     * @return - список из средних баллов по каждому предмету.
     */
    public static List<Tuple> averageScoreBySubject(Stream<Pupil> stream) {
        return stream
                .map(x -> new Tuple(x.getName(),
                        x.getSubjects()
                                .stream()
                                .mapToInt(Subject::getScore)
                                .average().
                                orElse(0D)))
                .collect(Collectors.toList());
    }

    /**
     * Метод averageScoreByPupil вычисляет средний балл по каждому ученику.
     *
     * @param stream - поток из учеников.
     * @return - список из средних баллов по каждому ученику.
     */
    public static List<Tuple> averageScoreByPupil(Stream<Pupil> stream) {
        return stream
                .flatMap(p -> p.getSubjects()
                        .stream())
                .collect(
                        Collectors.groupingBy(Subject::getName,
                                LinkedHashMap::new,
                                Collectors.averagingDouble(Subject::getScore)))
                .entrySet()
                .stream()
                .map(x -> new Tuple(x.getKey(), x.getValue()))
                .collect(Collectors.toList());
    }

    /**
     * Метод bestStudent - возвращает лучшего ученика.
     * Лучшим считается ученик с наибольшим баллом по всем предметам.
     *
     * @param stream - поток из учеников.
     * @return - лучший ученик или null, если поток пуст.
     */
    public static Tuple bestStudent(Stream<Pupil> stream) {
        return stream
                .map(x -> new Tuple(x.getName(),
                        x.getSubjects()
                                .stream()
                                .mapToInt(Subject::getScore)
                                .sum()))
                .max(Comparator.comparing(Tuple::getScore))
                .orElse(null);
    }

    /**
     * Метод bestSubject - возвращает предмет с наибольшим баллом для всех студентов.
     *
     * @param stream - поток из учеников.
     * @return - объект Tuple (имя предмета, сумма баллов каждого ученика по этому предмету).
     */
    public static Tuple bestSubject(Stream<Pupil> stream) {
        return stream
                .flatMap(p -> p.getSubjects()
                        .stream())
                .collect(
                        Collectors.groupingBy(Subject::getName,
                                LinkedHashMap::new,
                                Collectors.summingDouble(Subject::getScore)))
                .entrySet()
                .stream()
                .map(x -> new Tuple(x.getKey(), x.getValue()))
                .max(Comparator.comparing(Tuple::getScore))
                .orElse(null);
    }
}