package com.studentmanagement.app.service;

public class Calculator {

    public int add(int a, int b) {
        return a + b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public int substract(int a, int b) {
        return a - b;
    }

    public int division(int a, int b) throws ArithmeticException {
        return a / b;
    }

}
