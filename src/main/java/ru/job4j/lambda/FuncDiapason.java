package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * Класс подсчета функции в диапазоне.
 *
 * @author Andrey Shulgin
 */
public class FuncDiapason {
    /**
     * Метод считает функцию в диапазоне.
     *
     * @param start - начало диапазона.
     * @param end   - конец диапазоне.
     * @param func  - формула подсчета.
     * @return - список результатов.
     */
    public List<Double> diapason(int start, int end, Function<Double, Double> func) {
        List<Double> result = new ArrayList<>();
        for (int index = start; index < end; index++) {
            result.add(func.apply((double) index));
        }

        return result;
    }
}
