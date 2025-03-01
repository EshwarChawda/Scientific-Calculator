package com.calculator;

public class ScientificCalculator {
    public double squareRoot(double x) {
        if (x < 0) throw new IllegalArgumentException("Cannot compute square root of negative number");
        return Math.sqrt(x);
    }

    public long factorial(int x) {
        if (x < 0) throw new IllegalArgumentException("Factorial is not defined for negative numbers");
        long result = 1;
        for (int i = 1; i <= x; i++) {
            result *= i;
        }
        return result;
    }

    public double naturalLog(double x) {
        if (x <= 0) throw new IllegalArgumentException("Logarithm is undefined for non-positive numbers");
        return Math.log(x);
    }

    public double power(double base, double exponent) {
        return Math.pow(base, exponent);
    }
}
