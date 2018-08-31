package ru.job4j.calculator;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CalculatorTest {
    @Test
    public void whenAddOnePlusOneThenTwo() {
        Calculator calc = new Calculator();
        calc.add(2, 2);
        double result = calc.getResult();
        double expected = 4;
        assertThat(result, is(expected));
    }
    @Test
    public void subtractTest() {
        Calculator calc = new Calculator();
        calc.subtract(2, 2);
        double result = calc.getResult();
        double expected = 0;
        assertThat(result, is(expected));
    }
    @Test
    public void divideTest() {
        Calculator calc = new Calculator();
        calc.div(2, 2);
        double result = calc.getResult();
        double expected = 1;
        assertThat(result, is(expected));
    }
    @Test
    public void multipleTest() {
        Calculator calc = new Calculator();
        calc.multiple(5, 5);
        double result = calc.getResult();
        double expected = 25;
        assertThat(result, is(expected));
    }
}