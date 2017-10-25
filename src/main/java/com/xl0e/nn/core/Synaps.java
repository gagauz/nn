package com.xl0e.nn.core;

import java.util.Random;

public class Synaps {
    private static final Random R = new Random(1);

    private double weight = R.nextDouble();
    private double value;

    public double read() {
        return value;
    }

    public void write(double value) {
        this.value = weight * value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

}
