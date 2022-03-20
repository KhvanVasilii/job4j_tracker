package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < size; index++) {
            if (items[index].getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items[index] : null;
    }

    public Item[] findAll() {
        int size = 0;
        Item[] rsl = new Item[items.length];
        for (int i = 0; i < items.length; i++) {
            if (items[i] != null) {
                rsl[size++] = items[i];
            }
        }
        return Arrays.copyOf(rsl, size);
    }

    Item[] findByName(String key) {
        int size = 0;
        Item[] rsl = findAll();
        for (int i = 0; i < rsl.length; i++) {
            if (rsl[i].getName().equals(key)) {
                rsl[size++] = items[i];
            }
        }
        return Arrays.copyOf(rsl, size);
    }

    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        if (index != -1) {
            items[index] = item;
            items[index].setId(id);
            return true;
        }
        return false;
    }

}