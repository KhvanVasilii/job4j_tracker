package ru.job4j.tracker;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class EditActionTest {

    @Test
    public void whenReplaceItemTestOutputIsSuccessfully() {
        Tracker tracker = new Tracker();
        Item one = new Item("test1");
        tracker.add(one);
        Output out = new StubOutput();
        List<UserAction> actions = List.of(new EditAction(out), new ExitAction());
        String replaceName = "New Test Name";
        String ln = System.lineSeparator();
        Input input = new StubInput(new String[]{"0", String.valueOf(one.getId()), replaceName, "1"});
        new StartUI(out).init(input, tracker, actions);
        assertThat(out.toString()).isEqualTo(
                "Menu:" + ln
                        + "0. Edit item" + ln
                        + "1. Exit Program" + ln
                        + "=== Edit item ===" + ln
                        + "Заявка изменена успешно." + ln
                        + "Menu:" + ln
                        + "0. Edit item" + ln
                        + "1. Exit Program" + ln);
    }
}