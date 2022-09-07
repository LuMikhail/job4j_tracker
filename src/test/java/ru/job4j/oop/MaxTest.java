package ru.job4j.oop;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import static org.junit.jupiter.api.Assertions.*;

class MaxTest {

    @Test
    public void firstMax() {
        int first = 10;
        int second = 5;
        int third = 1;
        int result = Max.max(first, second, third);
        int expected = 10;
        Assert.assertEquals(expected, result);
    }

    @Test
    public void secondMax() {
        int first = 10;
        int second = 52;
        int third = 1;
        int result = Max.max(first, second, third);
        int expected = 52;
        Assert.assertEquals(expected, result);
    }

    @Test
    public void fourthMax() {
        int first = 1;
        int second = 5;
        int third = 100;
        int fourth = 145;
        int result = Max.max(first, second, third, fourth);
        int expected = 145;
        Assert.assertEquals(expected, result);
    }

    @Test
    public void allEq() {
        int first = 1;
        int second = 1;
        int third = 1;
        int result = Max.max(first, second, third);
        int expected = 1;
        Assert.assertEquals(expected, result);
    }

    @Test
    public void firstEqSecond() {
        int first = 10;
        int second = 10;
        int third = 1;
        int result = Max.max(first, second, third);
        int expected = 10;
        Assert.assertEquals(expected, result);
    }

    @Test
    public void firstEqThird() {
        int first = 100;
        int second = 1;
        int third = 100;
        int result = Max.max(first, second, third);
        int expected = 100;
        Assert.assertEquals(expected, result);
    }

    @Test
    public void secondEqFourth() {
        int first = 1;
        int second = 115;
        int fourth = 115;
        int result = Max.max(first, second, fourth);
        int expected = 115;
        Assert.assertEquals(expected, result);
    }
}
