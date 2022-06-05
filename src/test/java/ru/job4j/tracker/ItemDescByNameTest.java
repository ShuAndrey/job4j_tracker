package ru.job4j.tracker;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ItemDescByNameTest {

    @Test
    public void whenItemDescByName() {
        List<Item> items = Arrays.asList(
                new Item("second"),
                new Item("first"),
                new Item("third"),
                new Item("fourth")
        );
        Collections.sort(items, new ItemDescByName());
        List<Item> expected = Arrays.asList(
                new Item("third"),
                new Item("second"),
                new Item("fourth"),
                new Item("first")
        );
        assertEquals(items, expected);
    }

}