package com.xl0e.nn.core;

import java.util.Random;

public class Synaps {
    private static final Random R = new Random(1);

    private double weight = R.nextDouble();
    private double weight1;

    private double value = -10;

    public double read() {
        if (value < -9) {
            throw new IllegalStateException("The value is not set yet");
        }
        return value;
    }

    public void write(double value) {
        this.value = weight * value;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public static void link(Neuron from, Neuron to) {
        Synaps s = new Synaps();
        from.output.add(s);
        to.input.add(s);
    }
}
