package ru.job4j.stream;

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
        return profiles.stream().map(Profile::getAddress).collect(Collectors.toList());
    }
}