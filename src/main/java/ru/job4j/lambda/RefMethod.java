package ru.job4j.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * Класс выводит на консоль список имен.
 *
 * @author Andrey Shulgin
 */
public class RefMethod {
    public static void main(String[] args) {
        List<String> names = Arrays.asList(
                "Ivan",
                "Petr Arsentev"
        );
        Consumer<String> out = RefMethod::cutOut;
        names.forEach(out);
    }

    /**
     * Метод выводит на консоль список имен.
     * Если длинна имени больше 10, то происходит сокращение.
     *
     * @param value - Имя.
     */
    public static void cutOut(String value) {
        if (value.length() > 10) {
            System.out.println(value.substring(0, 10) + "..");
        } else {
            System.out.println(value);
        }
    }
}