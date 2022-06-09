package ru.job4j.lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class FuncDiapasonTest {
    @Test
    public void whenLinearFunctionThenLinearResults() {
        FuncDiapason function = new FuncDiapason();
        List<Double> result = function.diapason(5, 9, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D, 17D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenQuadraticFunctionThenQuadraticResults() {
        FuncDiapason function = new FuncDiapason();
        List<Double> result = function.diapason(5, 8, x -> x * x);
        List<Double> expected = Arrays.asList(25D, 36D, 49D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenExponentialFunctionThenExponentialResults() {
        FuncDiapason function = new FuncDiapason();
        List<Double> result = function.diapason(4, 8, x -> Math.pow(2, x));
        List<Double> expected = Arrays.asList(16D, 32D, 64D, 128D);
        assertThat(result, is(expected));
    }
}
