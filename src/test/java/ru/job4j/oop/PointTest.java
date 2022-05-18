package ru.job4j.oop;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PointTest {
    @Test
    public void whenDistance123To456Then5Dot196() {
        Point first = new Point(1, 2, 3);
        Point second = new Point(4, 5, 6);
        double result = first.distance3d(second);
        double expect = 5.196;
        assertEquals(result, expect, 0.001);
    }
}