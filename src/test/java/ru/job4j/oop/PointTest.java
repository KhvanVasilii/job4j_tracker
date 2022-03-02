package ru.job4j.oop;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class PointTest {

    @Test
    public void when00to20then2() {
        Point a = new Point(0, 0);
        Point b = new Point(2, 0);
        double out = a.distance(b);
        double expected = 2;
        Assert.assertEquals(expected, out, 0.01);
    }

    @Test
    public void when00To21Then2dot23() {
        Point a = new Point(0, 0);
        Point b = new Point(2, 1);
        double out = a.distance(b);
        double expected = 2.23;
        Assert.assertEquals(expected, out, 0.01);
    }

    @Test
    public void when00To22Then2Dot82() {
        Point a = new Point(0, 0);
        Point b = new Point(2, 2);
        double out = a.distance(b);
        double expected = 2.82;
        Assert.assertEquals(expected, out, 0.01);
    }

    @Test
    public void when123And555Then5Dot3851() {
        Point a = new Point(1, 2, 3);
        Point b = new Point(5, 5, 5);
        double out = a.distance3d(b);
        double expect = 5.3851;
        Assert.assertEquals(expect, out, 4);
    }
}