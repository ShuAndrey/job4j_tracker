package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Класс демонстрирует работу Stream API.
 *
 * @author Andrey Shulgin
 */
public class FilterNegativeNumbers {

    /**
     * Метод демонстрирует работу Stream API.
     *
     * @param args - args.
     */
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 14, -17, 11, -8, -1, 4);
        List<Integer> positive = numbers.stream().filter(x -> x > 0).collect(Collectors.toList());
        positive.forEach(System.out::println);
    }
}