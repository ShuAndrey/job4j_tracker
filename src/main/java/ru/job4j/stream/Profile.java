package ru.job4j.stream;

/**
 * Модель данных.
 *
 * @author Andrey Shulgin
 */
public class Profile {
    private Address address;

    public Profile(Address address) {
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }
}