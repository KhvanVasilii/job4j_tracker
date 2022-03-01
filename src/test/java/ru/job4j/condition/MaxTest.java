package ru.job4j.condition;

import org.junit.Assert;
import org.junit.Test;

public class MaxTest {

    @Test
    public void whenMax1To2Then2() {
        int first = 1;
        int second = 2;
        int result = Max.max(first, second);
        int expected = 2;
        Assert.assertEquals(result, expected);
    }

    @Test
    public void whenMax2To2Then2() {
        int first = 2;
        int second = 2;
        int result = Max.max(first, second);
        int expected = 2;
        Assert.assertEquals(result, expected);
    }

    @Test
    public void whenMax3To2Then3() {
        int first = 3;
        int second = 2;
        int result = Max.max(first, second);
        int expected = 3;
        Assert.assertEquals(result, expected);
    }

    @Test
    public void whenMax3And2And4Then4() {
        int first = 3;
        int second = 2;
        int third = 4;
        int result = Max.max(first, second, third);
        int expected = 4;
        Assert.assertEquals(result, expected);
    }

    @Test
    public void whenMax3And2And4and5Then5() {
        int first = 3;
        int second = 2;
        int third = 4;
        int fourth = 5;
        int result = Max.max(first, second, third, fourth);
        int expected = 5;
        Assert.assertEquals(result, expected);
    }

}