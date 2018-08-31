package ru.job4j.calculator;
/**
 * Calculator
 *
 * @author Dmitry Rozhdestvenskiy (mailto:dmr1433@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Calculator {
    double result;
    /**
     * Method add.
     * @param first  a number.
     * @param second a number.
     *
     */
    public void add(double first, double second) {
        this.result = first + second;
    }
    public void subtract(double first, double second) {
        this.result = first - second;
    }
    public void div(double first, double second) {
        this.result = first / second;
    }
    public void multiple (double first, double second) {
        this.result = first * second;
    }
    /**
     * Method getResult
     * @return this.result
     */
    public double getResult (){
        return this.result;
    }
}
