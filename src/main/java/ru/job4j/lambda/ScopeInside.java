package ru.job4j.lambda;

import java.util.function.Supplier;

/**
 * Класс вычисляет сумму значений в массиве.
 *
 * @author Andrey Shulgin
 */
public class ScopeInside {
    /**
     * Метод показывает работу метода add.
     *
     * @param args - args.
     */
    public static void main(String[] args) {
        int[] number = {1, 2, 3};
        int total = 0;
        int finalTotal = total;
        for (int i = 0; i < number.length; i++) {
            int num = number[i];
            total = add(
                    () -> finalTotal + num
            );
        }
        System.out.println(total);
    }

    /**
     * Метод вычисления суммы.
     *
     * @param calc - calc
     * @return - сумма.
     */
    private static Integer add(Supplier<Integer> calc) {
        return calc.get();
    }
}