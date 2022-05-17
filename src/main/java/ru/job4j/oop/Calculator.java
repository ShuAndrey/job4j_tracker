package ru.job4j.oop;

public class Calculator {

    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public int multiply(int a) {
        return x * a;
    }

    public static int minus(int b) {
        return b - x;
    }

    public int divide(int c) {
        return c / x;
    }

    public int sumAllOperation(int d) {
        return sum(d) + multiply(d) + minus(d) + divide(d);
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        int result = sum(10);
        System.out.println(result);
        result = calculator.multiply(5);
        System.out.println(result);
        result = minus(7);
        System.out.println(result);
        result = calculator.divide(15);
        System.out.println(result);
        result = calculator.sumAllOperation(11);
        System.out.println(result);
    }
}