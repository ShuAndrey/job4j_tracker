package ru.job4j.stream;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Класс меняет список на карту.
 *
 * @author Andrey Shulgin
 */
public class ListToMap {

    /**
     * Метод изменяет список студентов на карту, в которой ключ - это фамилия,
     * а значение - студент.
     *
     * @param list - список студентов.
     * @return - карта студентов.
     */
    public static Map<String, Student> convert(List<Student> list) {
        return list.stream()
                .collect(Collectors.toMap(
                        Student::getSurname
                        , s -> s
                        , (e, r) -> e)
                );
    }
}