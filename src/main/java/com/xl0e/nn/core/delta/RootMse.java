package com.xl0e.nn.core.delta;

public class RootMse implements Delta {

    public double calculate(double[] ideal, double[] actual, int number) {
        double sum = 0;
        for (int i = 0; i < ideal.length; i++) {
            sum += Math.pow(ideal[i] - actual[i], 2);
        }
        return Math.sqrt(sum / number);
    }
}
