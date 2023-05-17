package ru.job4j.tracker;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class FindByIdActionTest {
    @Test
    public void whenFindByIdTestOutputIsSuccessfully() {
        Tracker tracker = new Tracker();
        Item one = new Item("test1");
        tracker.add(one);
        Output out = new StubOutput();
        List<UserAction> actions = List.of(new FindByIdAction(out), new ExitAction());
        String ln = System.lineSeparator();
        Input input = new StubInput(new String[]{"0", String.valueOf(one.getId()), "1"});
        new StartUI(out).init(input, tracker, actions);
        assertThat(out.toString()).isEqualTo(
                "Menu:" + ln
                        + "0. Find item by id" + ln
                        + "1. Exit Program" + ln
                        + "=== Find item by id ===" + ln
                        + one + ln
                        + "Menu:" + ln
                        + "0. Find item by id" + ln
                        + "1. Exit Program" + ln);
    }
}