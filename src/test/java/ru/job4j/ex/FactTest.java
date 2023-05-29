package ru.job4j.ex;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FactTest {
    @Test
    public void whenException() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    Fact.calc(-3);
                });
        assertThat(exception.getMessage()).isEqualTo("N could not be less then 0");
    }

    @Test
    public void whenFact3Result6() {
        int expected = 6;
        int actual = Fact.calc(3);
        assertThat(actual).isEqualTo(expected);
    }

}