package ru.job4j.collection;

import java.util.Comparator;

/**
 * Класс реализует сортировку департаментов по убыванию.
 *
 * @author Andrey Shulgin
 */
public class DepDescComp implements Comparator<String> {
    /**
     * Метод реализует сортировку департаментов по убыванию, если первый департамент одинаковый,
     * дальше сортировка происходит по возрастанию.
     *
     * @param o1 the first object to be compared.
     * @param o2 the second object to be compared.
     * @return - итоги сортировки.
     */
    @Override
    public int compare(String o1, String o2) {
        String[] o1Array = o1.split("/");
        String[] o2Array = o2.split("/");
        int rst = o2Array[0].compareTo(o1Array[0]);
        return rst != 0 ? rst : o1.compareTo(o2);
    }
}