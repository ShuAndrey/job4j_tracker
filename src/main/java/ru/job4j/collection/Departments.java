package ru.job4j.collection;

import java.util.*;

/**
 * Класс производит сортировку департаментов.
 *
 * @author Andrey Shulgin
 */
public class Departments {

    /**
     * Метод убирает дубликаты из коллекции, которые будут получаться
     * в результате последовательного складывания единичных департаментов.
     *
     * @param deps - список департаментов.
     * @return - список департаментов без дублирующих.
     */
    public static List<String> fillGaps(List<String> deps) {
        Set<String> tmp = new LinkedHashSet<>();
        for (String value : deps) {
            String start = "";
            for (String el : value.split("/")) {
                start += "".equals(start) ? el : "/" + el;
                tmp.add(start);
            }
        }
        return new ArrayList<>(tmp);
    }

    /**
     * Метод сортирует департаменты по возрастанию.
     *
     * @param orgs - список департаментов.
     */
    public static void sortAsc(List<String> orgs) {
        Collections.sort(orgs);
    }

    /**
     * Метод сортирует департаменты по убыванию.
     *
     * @param orgs - список департаментов.
     */
    public static void sortDesc(List<String> orgs) {
        orgs.sort(new DepDescComp());
    }
}