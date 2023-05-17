package ru.job4j.tracker;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ShowAllActionTest {
    @Test
    public void whenShowAllItemsTestOutputIsSuccessfully() {
        Tracker tracker = new Tracker();
        Item one = new Item("test1");
        tracker.add(one);
        Output out = new StubOutput();
        List<UserAction> actions = List.of(new ShowAllAction(out), new ExitAction());
        String ln = System.lineSeparator();
        Input input = new StubInput(new String[]{"0", "1"});
        new StartUI(out).init(input, tracker, actions);
        assertThat(out.toString()).isEqualTo(
                "Menu:" + ln
                        + "0. Show all items" + ln
                        + "1. Exit Program" + ln
                        + "=== Show all items ===" + ln
                        + one + ln
                        + "Menu:" + ln
                        + "0. Show all items" + ln
                        + "1. Exit Program" + ln);
    }
}