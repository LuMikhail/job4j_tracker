package ru.job4j.tracker;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ItemTest {
    @Test
    public void whenSortedAscendingByName() {
        List<Item> items = Arrays.asList(
                new Item(1, "Дмитрий"),
                new Item(2, "Николай"),
                new Item(3, "Александр"));
        List<Item> expected = Arrays.asList(
                new Item(3, "Александр"),
                new Item(1, "Дмитрий"),
                new Item(2, "Николай"));
        items.sort(new ItemAscByName());
        assertThat(items).isEqualTo(expected);
    }

    @Test
    public void whenSortedDecreasingByName() {
        List<Item> items = Arrays.asList(
                new Item(1, "Дмитрий"),
                new Item(2, "Анастасия"),
                new Item(3, "Александр"),
                new Item(4, "Юлия"));
        List<Item> expected = Arrays.asList(
                new Item(4, "Юлия"),
                new Item(1, "Дмитрий"),
                new Item(2, "Анастасия"),
                new Item(3, "Александр"));
        items.sort(new ItemDescByName());
        assertThat(items).isEqualTo(expected);
    }
}
