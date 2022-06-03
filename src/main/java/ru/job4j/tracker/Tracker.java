package ru.job4j.tracker;

import jdk.dynalink.linker.LinkerServices;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tracker {
    private final List<Item> items = new ArrayList<>();
    private int ids = 1;

    public Item add(Item item) {
        item.setId(ids++);
        items.add(item);
        return item;
    }

    public List<Item> findAll() {
        return items;
    }

    public List<Item> findByName(String key) {
        List<Item> result = new ArrayList<>();
        for (Item item : items) {
            if (item.getName().equals(key)) {
                result.add(item);
            }
        }
        return result;
    }

    public Item findById(int id) {
        Item result = null;
        for (Item item : items) {
            if (item.getId() == id) {
                result = item;
            }
        }
        return result;
    }

    public boolean replace(int id, Item item) {
        boolean result = false;
        for (Item one : items) {
            if (one.getId() == id) {
                items.remove(one);
                item.setId(id);
                items.add(item);
                result = true;
                break;
            }
        }
        return result;
    }

    public boolean delete(int id) {
        boolean result = false;
        for (Item item : items) {
            if (item.getId() == id) {
                items.remove(item);
                result = true;
                break;
            }
        }
        return result;
    }
}