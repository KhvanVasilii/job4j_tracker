package ru.job4j.tracker;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class StartUITest {
    @Test
    public void whenCreateItem() {
        Tracker tracker = new Tracker();
        Output out = new StubOutput();
        Input in = new StubInput(new String[]{"0", "Item name", "1"});
        List<UserAction> actions = Arrays.asList(new CreateAction(out), new ExitAction());
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findAll().get(0).getName()).isEqualTo("Item name");
    }

    @Test
    public void whenReplaceItem() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        List<UserAction> actions = List.of(new EditAction(out), new ExitAction());
        Item item = tracker.add(new Item("Replaced item"));
        String replacedName = "New item name";
        String id = Integer.toString(item.getId());
        Input in = new StubInput(
                new String[]{"0", id, replacedName, "1"}
        );
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName()).isEqualTo(replacedName);
    }

    @Test
    public void whenDeleteItem() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Deleted item"));
        String id = Integer.toString(item.getId());
        Input in = new StubInput(
                new String[]{"0", id, "1"}
        );
        List<UserAction> actions = List.of(new DeleteAction(out), new ExitAction());
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId())).isNull();
    }

    @Test
    public void whenExit() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        List<UserAction> actions = List.of(new ExitAction());
        Input in = new StubInput(new String[]{"0"});
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString()).isEqualTo("Menu:" + System.lineSeparator()
                + "0. Exit Program" + System.lineSeparator());
    }

    @Test
    public void whenInvalidExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"11", "0"}
        );
        Tracker tracker = new Tracker();
        List<UserAction> actions = List.of(new ExitAction());
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo(
                "Menu:" + ln
                        + "0. Exit Program" + ln
                        + "Wrong input, you can select: 0 .. 0" + ln
                        + "Menu:" + ln
                        + "0. Exit Program" + ln
        );
    }
}