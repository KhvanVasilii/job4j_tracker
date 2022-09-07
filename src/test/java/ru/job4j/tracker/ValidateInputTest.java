package ru.job4j.tracker;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class ValidateInputTest {
    @Test
    public void whenInvalidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"one", "1"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected, is(1));
    }

    @Test
    public void whenValidInput() {
        Output out = new StubOutput();
        String[] testInput = {"0", "1", "2"};
        Input in = new StubInput(testInput);
        ValidateInput input = new ValidateInput(out, in);
        for (int index = 0; index < testInput.length; index++) {
            out.println(input.askInt("select"));
        }
        String ln = System.lineSeparator();
        assertThat(out.toString(), is("0" + ln
                                + "1" + ln
                                + "2" + ln));
    }

    @Test
    public void whenNegativeInput() {
        Output out = new StubOutput();
        Input in = new StubInput(new String[] {"-1"});
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Select:");
        assertThat(selected, is(-1));
    }

}