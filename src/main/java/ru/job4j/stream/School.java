package ru.job4j.stream;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Распределение учеников по классам.
 *
 * @author Andrey Shulgin
 */
public class School {
    /**
     * Метод фильтрует учеников в зависимости от успеваемости.
     *
     * @param students - список студентов.
     * @param predict  - условие распределения.
     * @return - список тех, кто подходит по условию.
     */
    public List<Student> collect(List<Student> students, Predicate<Student> predict) {
        return students.stream().filter(predict).collect(Collectors.toList());
    }
}
