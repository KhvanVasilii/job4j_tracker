package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StartUITest {
    @Test
    public void whenCreateItem() {
        Tracker tracker = new Tracker();
        Output out = new StubOutput();
        Input in = new StubInput(new String[]{"0", "Item name", "1"});
        UserAction[] actions = {new CreateAction(out), new ExitAction()};
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findAll()[0].getName(), is("Item name"));
    }

    @Test
    public void whenReplaceItem() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        UserAction[] actions = {new EditAction(out), new ExitAction()};
        Item item = tracker.add(new Item("Replaced item"));
        String replacedName = "New item name";
        String id = Integer.toString(item.getId());
        Input in = new StubInput(
                new String[] {"0", id, replacedName, "1"}
        );
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName(), is(replacedName));
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
        UserAction[] actions = {
                new DeleteAction(out),
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        assertNull(tracker.findById(item.getId()));
    }

    @Test
    public void whenExit() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        UserAction[] actions = {new ExitAction()};
        Input in = new StubInput(new String[] {"0"});
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is("Menu:" + System.lineSeparator()
                + "0. Exit Program" + System.lineSeparator()));
    }

    @Test
    public void whenInvalidExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"11", "0"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = new UserAction[]{
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                "Menu:" + ln
                        + "0. Exit Program" + ln
                        + "Wrong input, you can select: 0 .. 0" + ln
                        + "Menu:" + ln
                        + "0. Exit Program" + ln
        ));
    }
}