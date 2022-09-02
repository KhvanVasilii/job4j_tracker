package ru.job4j.tracker;

import org.junit.Test;

import java.time.format.DateTimeFormatter;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ShowAllActionTest {
    @Test
    public void whenShowAllItemsTestOutputIsSuccessfully() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");
        Tracker tracker = new Tracker();
        Item one = new Item("test1");
        tracker.add(one);
        Output out = new StubOutput();
        UserAction[] actions = {new ShowAllAction(out), new ExitAction()};
        String ln = System.lineSeparator();
        Input input = new StubInput(new String[] {"0", "1"});
        new StartUI(out).init(input, tracker, actions);
        assertThat(out.toString(), is(
                "Menu:" + ln
                        + "0. Show all items" + ln
                        + "1. Exit Program" + ln
                        + "=== Show all items ===" + ln
                        + "Item{"
                        + "id=" + one.getId()
                        + ", name='" + one.getName() + '\''
                        + ", created=" + one.getCreated().format(formatter)
                        + '}' + ln
                        + "Menu:" + ln
                        + "0. Show all items" + ln
                        + "1. Exit Program" + ln));
    }

}