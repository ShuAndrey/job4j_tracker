package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Класс конвертирует матрицу в список.
 *
 * @author Andrey Shulgin
 */
public class MatrixToList {

    /**
     * Метод конвертирует матрицу в список.
     *
     * @param matrix - двумерный массив.
     * @return - список.
     */
    public static List<Integer> convert(Integer[][] matrix) {
        return Stream.of(matrix)
                .flatMap(Arrays::stream)
                .collect(Collectors.toList());
    }
}