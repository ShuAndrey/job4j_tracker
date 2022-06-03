package ru.job4j.tracker;

import java.util.ArrayList;
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
        return List.copyOf(items);
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
        int index = indexOf(id);
        Item result = null;
        if (items.get(index).getId() == id) {
            result = items.get(index);
        }

        return result;
    }

    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        boolean result = false;
        if (items.get(index).getId() == id) {
            items.remove(items.get(index));
            item.setId(id);
            items.add(item);
            result = true;
        }
        return result;
    }

    public boolean delete(int id) {
        int index = indexOf(id);
        boolean result = false;
        if (items.get(index).getId() == id) {
            items.remove(items.get(index));
            result = true;
        }
        return result;
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < items.size(); index++) {
            if (items.get(index).getId() == id) {
                rsl = index;
            }
        }
        return rsl;
    }

}