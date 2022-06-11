package ru.job4j.stream;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Создание списка адресов из анкет.
 *
 * @author Andrey Shulgin
 */
public class Profiles {

    /**
     * Метод преобразует список анкет в список адресов.
     *
     * @param profiles - список анкет.
     * @return - список адресов.
     */
    public static List<Address> collect(List<Profile> profiles) {
        return profiles.stream()
                .map(Profile::getAddress)
                .collect(Collectors.toList());
    }

    /**
     * Метод преобразует список анкет в отсортированный список адресов
     * без дубликатов.
     *
     * @param profiles - список анкет.
     * @return - отсортированный список адресов.
     */
    public static List<Address> collectSortWithoutDuplicate(List<Profile> profiles) {
        return profiles.stream()
                .map(Profile::getAddress)
                .sorted(Comparator.comparing(Address::getCity))
                .distinct()
                .collect(Collectors.toList());
    }
}