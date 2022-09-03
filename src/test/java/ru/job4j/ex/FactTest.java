package ru.job4j.ex;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;

public class FactTest {
    @Test
    public void whenException() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    Fact.calc(-3);
                });
        assertThat(exception.getMessage(), is("N could not be less then 0"));
    }

    @Test
    public void whenFact3Result6() {
        int expected = 6;
        int actual = Fact.calc(3);
        assertThat(actual, is(expected));
    }

}