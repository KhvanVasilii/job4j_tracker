package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

class ItemTest {

    @Test
    public void whenSortByName() {
        List<Item> items = Arrays.asList(
                new Item("test - b"),
                new Item("test - a"),
                new Item("test - c")
        );
        items.sort(new ItemAscByName());
        List<Item> expected = Arrays.asList(
                new Item("test - a"),
                new Item("test - b"),
                new Item("test - c")
        );
        assertThat(items).isEqualTo(expected);
    }

    @Test
    public void whenDescSortByName() {
        List<Item> items = Arrays.asList(
                new Item("test - b"),
                new Item("test - a"),
                new Item("test - c")
        );
        items.sort(new ItemDescByName());
        List<Item> expected = Arrays.asList(
                new Item("test - c"),
                new Item("test - b"),
                new Item("test - a")
        );
        assertThat(items).isEqualTo(expected);
    }
}