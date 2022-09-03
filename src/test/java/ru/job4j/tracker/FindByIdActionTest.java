package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class FindByIdActionTest {
    @Test
    public void whenFindByIdTestOutputIsSuccessfully() {
        Tracker tracker = new Tracker();
        Item one = new Item("test1");
        tracker.add(one);
        Output out = new StubOutput();
        UserAction[] actions = {new FindByIdAction(out), new ExitAction()};
        String ln = System.lineSeparator();
        Input input = new StubInput(new String[] {"0", String.valueOf(one.getId()), "1"});
        new StartUI(out).init(input, tracker, actions);
        assertThat(out.toString(), is(
                "Menu:" + ln
                        + "0. Find item by id" + ln
                        + "1. Exit Program" + ln
                        + "=== Find item by id ===" + ln
                        + one + ln
                        + "Menu:" + ln
                        + "0. Find item by id" + ln
                        + "1. Exit Program" + ln));
    }

}