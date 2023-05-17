package ru.job4j.tracker;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class FindByNameActionTest {
    @Test
    public void whenFindByNameTestOutputIsSuccessfully() {
        Tracker tracker = new Tracker();
        Item one = new Item("test1");
        tracker.add(one);
        Output out = new StubOutput();
        List<UserAction> actions = List.of(new FindByNameAction(out), new ExitAction());
        String ln = System.lineSeparator();
        Input input = new StubInput(new String[]{"0", one.getName(), "1"});
        new StartUI(out).init(input, tracker, actions);
        assertThat(out.toString()).isEqualTo(
                "Menu:" + ln
                        + "0. Find items by name" + ln
                        + "1. Exit Program" + ln
                        + "=== Find items by name ===" + ln
                        + one + ln
                        + "Menu:" + ln
                        + "0. Find items by name" + ln
                        + "1. Exit Program" + ln);
    }
}