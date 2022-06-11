package ru.job4j.stream;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Фильтрация учеников по проходному баллу.
 *
 * @author Andrey Shulgin
 */
public class StudentLevel {
    /**
     * Метод фильтрует учеников по проходному баллу.
     *
     * @param students - список учеников.
     * @param bound    - проходной балл.
     * @return - список учеников у которых проходной балл выше bound.
     */
    public static List<Student> levelOf(List<Student> students, int bound) {
        return students.stream()
                .filter(Objects::nonNull)
                .sorted((left, right) ->
                        Integer.compare(right.getScore(), left.getScore()))
                .takeWhile(st -> st.getScore() > bound)
                .collect(Collectors.toList());
    }
}