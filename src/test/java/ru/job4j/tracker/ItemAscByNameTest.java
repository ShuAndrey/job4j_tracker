package ru.job4j.tracker;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ItemAscByNameTest {
    @Test
    public void whenItemAscByName() {
        List<Item> items = Arrays.asList(
                new Item("second"),
                new Item("first"),
                new Item("third"),
                new Item("fourth")
        );
        Collections.sort(items, new ItemAscByName());
        List<Item> expected = Arrays.asList(
                new Item("first"),
                new Item("fourth"),
                new Item("second"),
                new Item("third")
        );
        assertEquals(items, expected);
    }
}