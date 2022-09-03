package ru.job4j.ex;


import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;

public class CountTest {
    @Test
    public void whenException() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    Count.add(10, 2);
                });
        assertThat((exception.getMessage()), is("Start should be less than finish."));
    }

}