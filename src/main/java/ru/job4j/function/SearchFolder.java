package ru.job4j.function;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * Класс показывает работу функционального интерфейса предикат.
 *
 * @author Andrey Shulgin
 */
public class SearchFolder {
    /**
     * Метод добавляет значение из одной коллекции в другую в зависимости
     * от условий прописанных в предикат.
     *
     * @param list - коллекция.
     * @param pred - предикат.
     * @return - коллекция из элементов которые удовлетворяют условиям предиката.
     */
    public static List<Folder> filter(List<Folder> list, Predicate<Folder> pred) {
        List<Folder> rsl = new ArrayList<>();
        for (Folder folder : list) {
            if (pred.test(folder)) {
                rsl.add(folder);
            }
        }
        return rsl;
    }
}